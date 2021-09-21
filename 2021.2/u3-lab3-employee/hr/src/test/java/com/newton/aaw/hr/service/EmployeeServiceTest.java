package com.newton.aaw.hr.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.newton.aaw.hr.domain.entity.Employee;
import com.newton.aaw.hr.domain.repository.EmployeeRepository;
import com.newton.aaw.hr.exception.NotFoundException;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	private EmployeeService unit;

	@BeforeEach
	public void setup() {
		unit = new EmployeeService(employeeRepository);
	}
	
	@Test
	void test_getById_withEmployee_shouldReturnObj() {
		// given:
		var employee = new Employee();
		employee.setId("employee1");
		
		// mock definitions: 
		Mockito.when(employeeRepository.findById("employee1"))
			.thenReturn(Optional.of(employee));
		
		// test:
		var result = unit.get("employee1");
		
		// assert:
		Assertions.assertEquals(result, employee);
		
		// verify: 
		Mockito.verify(employeeRepository).findById("employee1");
	}
	
	@Test
	void test_getById_withNoEmployee_shouldThrowException() {
		// given:
		var id = "employee1";
		
		// mock definitions
		Mockito.when(employeeRepository.findById(id))
		.thenReturn(Optional.empty());

		// test:
		try {
			unit.get(id);
			fail("Expected NotFoundException");
		} catch (NotFoundException ex) {
			// assert:
			Assertions.assertEquals(ex.getMessage(), "Employee with ID " + id + " not found");
		}
		
		// verify: 
		Mockito.verify(employeeRepository).findById(id);		
	}

}
