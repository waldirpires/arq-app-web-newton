package com.newton.aaw.hr.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.newton.aaw.hr.domain.entity.User;

@Service
public class UserService {

	private static int id = 0;
	private Map<Integer, User> users = new HashMap<Integer, User>();
	
	// C - CRUD
	public User save(User u) {
		id++;
		u.setId(id);

		users.put(id, u);
		
		return u;
	}
	
	// R - CRUD
	public User get(Integer id) {
		
		var user = users.get(id);
		
		if (user == null) {
			// lançar uma exceção
		} 
		
		return user;
	}
	
}
