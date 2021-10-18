package com.newton.aaw.hr.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.newton.aaw.hr.domain.entity.User;
import com.newton.aaw.hr.domain.repository.UserRepository;
import com.newton.aaw.hr.exception.NotAuthorizedException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UserRepository userRepository;
	
	
	public User login(String userName, String password) {
		// 1. verificar o nome do usuário		
		var user = userRepository.findOneByName(userName);
		if (user.isEmpty()) {
			throw new NotAuthorizedException("User with name " + userName + " not found!");
		}
		
		// 2. verificar a senha informada
		var userExists = user.get();
		if (!userExists.getPassword().equals(password)) {
			throw new NotAuthorizedException("User " + userName + " password incorrect!");
		}
		
		// 3. atualizar as informações de login/logout
		userExists.setLoggedInAt(LocalDateTime.now());
		userExists.setLoggedOutAt(null);

		userRepository.save(userExists);
		
		return userExists;		
	}
	
	public void logout(String userName) {
		
	}	
}
