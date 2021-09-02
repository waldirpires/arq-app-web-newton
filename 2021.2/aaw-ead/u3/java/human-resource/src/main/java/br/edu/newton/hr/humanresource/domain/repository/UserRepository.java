package br.edu.newton.hr.humanresource.domain.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.edu.newton.hr.humanresource.domain.entity.User;

public interface UserRepository extends MongoRepository<User, String>{
    
	List<User> findByEstado(String estado);
}
