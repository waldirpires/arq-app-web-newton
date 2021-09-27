package com.newton.aaw.hr.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.newton.aaw.hr.domain.entity.Employee;
import com.newton.aaw.hr.domain.repository.EmployeeRepository;
import com.newton.aaw.hr.exception.NotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	
	public Employee create(Employee e) {
		var now  = LocalDateTime.now();
		
		e.setCreatedAt(now);
		e.setModifiedAt(now);
		
		employeeRepository.save(e);
		
		return e;
	}
	
	public Employee update(String id, Employee u) {
		var existing = get(id);

		existing.setFirstName(u.getFirstName());
		existing.setLastName(u.getLastName());
		existing.setDateOfBirth(u.getDateOfBirth());
		existing.setGender(u.getGender());
		existing.setStartDate(u.getStartDate());
		existing.setEndDate(u.getEndDate());
		existing.setPosition(u.getPosition());
		existing.setMonthlySalary(u.getMonthlySalary());
		existing.setHourSalary(u.getHourSalary());
		existing.setArea(u.getArea());
		
		existing.setModifiedAt(LocalDateTime.now());
		
		employeeRepository.save(existing);
		
		return existing;
	}
	
	public Employee get(String id) {
		var employee = employeeRepository.findById(id);
		
		if (employee.isEmpty()) {
			throw new NotFoundException("Employee with ID " + id + " not found");
		}
		
		return employee.get();
	}
	
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	public void delete(String id) {
		get(id);
		
		employeeRepository.deleteById(id);
	}
}
