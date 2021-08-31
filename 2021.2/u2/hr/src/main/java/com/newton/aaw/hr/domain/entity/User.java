package com.newton.aaw.hr.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private Integer id;
	
	private String name;
	
	private String password; 
	
}
