package com.newton.aaw.hr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newton.aaw.hr.api.EmployeeDto;
import com.newton.aaw.hr.domain.entity.Employee;
import com.newton.aaw.hr.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor 
public class EmployeeController implements EmployeesResource {

	private final EmployeeService employeeService;
	
	@Override
	public EmployeeDto getById(@PathVariable String id) {
		var employee = employeeService.get(id);
		
		return new EmployeeDto(employee);
	}
	
	@Override
	public List<EmployeeDto> getAll() {
		var employees = employeeService.getAll();
		
		var employeeDtos = new ArrayList<EmployeeDto>();
		
		for (var employee: employees) {
			employeeDtos.add(new EmployeeDto(employee));
		}
		
		return employeeDtos;
	}
	
	@Override
	public EmployeeDto create(@RequestBody EmployeeDto employeeDto) {
		var employee = new Employee(employeeDto);
		
		employee = employeeService.create(employee);
		
		return new EmployeeDto(employee);
	}

	@Override
	public EmployeeDto update(@PathVariable String id, @RequestBody EmployeeDto employeeDto) {
		var employee = new Employee(employeeDto);
		
		employee = employeeService.update(id, employee);
		
		return new EmployeeDto(employee);
	}
	
	@Override
	public ResponseEntity<Void> delete(@PathVariable String id) {
		employeeService.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
