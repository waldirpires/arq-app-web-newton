package br.edu.newton.hr.humanresource.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.newton.hr.humanresource.domain.entity.User;
import br.edu.newton.hr.humanresource.domain.service.UserService;
import lombok.RequiredArgsConstructor;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@PostMapping("/v1/users")
	public User save(@RequestBody User user) {
		
		var saved = userService.save(user);
		
		return saved;
	}

	@PutMapping("/v1/users/{id}")
	public User update(@PathVariable String id, @RequestBody User user) {
		
		var saved = userService.save(user);
		
		return saved;
	}

	@GetMapping("/v1/users/{id}")
	public User getById(@PathVariable String id) {
		
		var user = userService.getById(id);
		
		return user;
	}	

	@GetMapping("/v1/users")
	public List<User> getAll() {
		
		return userService.getAll();
	}	

	@DeleteMapping("/v1/users/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		userService.delete(id);
		
		return new ResponseEntity<Void>(NO_CONTENT);
	}
	
}
