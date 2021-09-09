package br.edu.newton.hr.humanresource;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.edu.newton.hr.humanresource.controller.UserController;
import br.edu.newton.hr.humanresource.domain.entity.User;
import br.edu.newton.hr.humanresource.domain.service.UserService;
import br.edu.newton.hr.humanresource.exception.NotFoundException;

@WebMvcTest(UserController.class)
public class UserControllerMvcTest {

	@MockBean
	private UserService userService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void test_getById_with_inexistentEntity_shouldReturn404() throws Exception {
		// given
		var id = UUID.randomUUID().toString();
		
		// mock definitions
		Mockito.when(userService.getById(id))
			.thenThrow(new NotFoundException("User with ID " + id + " not found"));
		
		// test/assert
		mockMvc.perform(
				MockMvcRequestBuilders.get("/v1/users/" +id))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	void test_getById_with_existingEntity_shouldReturn200() throws Exception {
		// given
		var id = UUID.randomUUID().toString();
		
		// mock definitions
		Mockito.when(userService.getById(id))
			.thenReturn(new User().withId(id));
		
		// test/assert
		mockMvc.perform(
				MockMvcRequestBuilders.get("/v1/users/" +id))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
