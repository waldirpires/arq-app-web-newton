package com.newton.aaw.hr.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.newton.aaw.hr.domain.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	@Id
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate dateOfBirth;
	
	private Gender gender;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private String position;
	
	private Float monthlySalary;
	
	private String hourSalary;
	
	private String area;	
	
	private LocalDateTime createdAt;
	
	private LocalDateTime modifiedAt;
		
}

