package com.newton.aaw.hr.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newton.aaw.hr.api.LoginDto;
import com.newton.aaw.hr.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
	
	private final AuthenticationService authenticationService;
	
	@PostMapping("/auth/login")
	public ResponseEntity<Void> login(@RequestBody LoginDto login) {
		// realizar a autenticação
		authenticationService.login(
				login.getUserName(), 
				login.getPassword()
		);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping("/auth/logout")
	public ResponseEntity<Void> logout(@RequestBody LoginDto logout) {
		authenticationService.logout(
				logout.getUserName()
		);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
