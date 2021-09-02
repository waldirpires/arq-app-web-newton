package br.edu.newton.hr.humanresource.domain.service;

import java.util.List;

import br.edu.newton.hr.humanresource.domain.entity.User;

public interface UserService {

	// GET by ID
	User getById(String id);
	
	// CREATE, UPDATE
	User save(User user);
	
	// GET all
	List<User> getAll();
	
	// DELETE
	void delete(String id);
}
