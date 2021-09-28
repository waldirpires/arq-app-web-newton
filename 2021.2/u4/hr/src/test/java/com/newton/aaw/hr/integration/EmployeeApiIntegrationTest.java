package com.newton.aaw.hr.integration;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.newton.aaw.hr.controller.EmployeeController;
import com.newton.aaw.hr.domain.entity.Employee;
import com.newton.aaw.hr.exception.NotFoundException;
import com.newton.aaw.hr.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
public class EmployeeApiIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService employeeService;
	
	@Test
	void test_getById_withInvalidId_shouldReturn404() throws Exception {
		// given
		var id = "001";
		
		// mock definitions
		Mockito.when(employeeService.get(id))
			.thenThrow(new NotFoundException("Not found"));
		
		// test/assert
		mockMvc.perform(MockMvcRequestBuilders.get("/employees/" +id))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isNotFound()); // 404
		
		// verify
		Mockito.verify(employeeService).get(id);
	}

	@Test
	void test_getById_withValidId_shouldReturn200() throws Exception {
		// given
		var id = "001";
		
		// mock definitions
		Mockito.when(employeeService.get(id))
			.thenReturn(new Employee().withId(id));
		
		// test/assert
		mockMvc.perform(MockMvcRequestBuilders.get("/employees/" +id))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk()); // 200
		
		// verify
		Mockito.verify(employeeService).get(id);
	}
	
	void test_delete_withValidId_shouldReturn204() {
		
	}

	void test_delete_withInvalidId_shouldReturn404() {
		
	}

}
