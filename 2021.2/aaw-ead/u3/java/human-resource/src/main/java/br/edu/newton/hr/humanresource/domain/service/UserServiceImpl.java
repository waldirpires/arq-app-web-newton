package br.edu.newton.hr.humanresource.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.newton.hr.humanresource.domain.entity.User;
import br.edu.newton.hr.humanresource.domain.repository.UserRepository;
import br.edu.newton.hr.humanresource.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	
	@Override
	public User getById(String id) {

		var user = userRepository.findById(id);
		
		if (user.isEmpty()) {
			throw new NotFoundException("User with ID " + id + " not found");
		}
		
		return user.get();
	}

	@Override
	public User save(User user) {

		if (user.getId() != null) { // update
			var existing = getById(user.getId());
			
			log.info("Existing: {}", existing);
			
			existing.setCidade(user.getCidade());
			existing.setEstado(user.getEstado());
			existing.setIdade(user.getIdade());
			existing.setNome(user.getNome());
			existing.setPais(user.getPais());
			existing.setModifiedAt(LocalDateTime.now());
			
			userRepository.save(existing);
			
			log.info("Saved: {}", existing);

			return existing;
		}
		
		if (user.getCreatedAt() == null) {
			user.setCreatedAt(LocalDateTime.now());
		}

		user.setModifiedAt(LocalDateTime.now());
		
		userRepository.save(user);
		
		return user;
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(String id) {
		
		getById(id);
		
		userRepository.deleteById(id);
	}

}
