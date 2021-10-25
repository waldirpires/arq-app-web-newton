package com.newton.aaw.hr.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.newton.aaw.hr.domain.entity.User;

class TokenServiceTest {
	
	private TokenService unit;
	
	@BeforeEach
	public void setup() {
		unit = new TokenService();
	}

	@Test
	void test_generateToken_withValidUser_shouldGenerateOk() {
		// given:
		var user = new User();
		user.setName("wrpires");
		user.setEmail("waldir.junior@newtonpaiva.br");
		
		// test:
		var token = unit.generateToken(user);
		
		// assert:
		assertNotNull(token);
		var claims = unit.decodeToken(token);
		assertEquals(
				"wrpires:waldir.junior@newtonpaiva.br", 
				claims.getSubject()
		);
	}
	
	@Test
	void test_validate_withValidToken_shouldThrowNoExceptions() {
		// given:
		var user = new User();
		user.setName("wrpires");
		user.setEmail("waldir.junior@newtonpaiva.br");
		
		var token = unit.generateToken(user);

		// test: 
		unit.validate("Bearer " + token);
		
		// assert: 
	}
	
	@Test
	void test_validate_withExpiredToken_shouldThrowTokenExpiredExceptions() throws InterruptedException {
		// given:
		var user = new User();
		user.setName("wrpires");
		user.setEmail("waldir.junior@newtonpaiva.br");
		
		var exp = new Date(System.currentTimeMillis() + 2000);
		
		var token = unit.generateToken(user, exp);

		Thread.sleep(3000);
		
		// test: 
		unit.validate("Bearer " + token);
		
		// assert: 
	}
	

}
