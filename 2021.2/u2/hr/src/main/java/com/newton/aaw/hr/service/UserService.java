package com.newton.aaw.hr.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.newton.aaw.hr.domain.entity.User;

@Service
public class UserService {

	private static int id = 0;
	private Map<Integer, User> users = new HashMap<Integer, User>();

	// C - CRUD
	public User create(User u) {
		u.setId(++id);

		users.put(id, u);
		
		return u;
	}
	
	// u - CRUD
	public User update(Integer id, User u) {

		var existing = get(id);

		existing.setName(u.getName());
		existing.setPassword(u.getPassword());
		
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
	
	// R - CRUD
	public List<User> getAll() {
		return new ArrayList<>(users.values());
	}
	
	// D - CRUD
	public void delete(Integer id) {
		get(id);
		
		users.remove(id);
	}
	
}
