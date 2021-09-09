package br.edu.newton.hr.humanresource.domain.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.edu.newton.hr.humanresource.domain.entity.User;
import br.edu.newton.hr.humanresource.domain.repository.UserRepository;
import br.edu.newton.hr.humanresource.exception.NotFoundException;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	private UserRepository userRepository;
	
	private UserServiceImpl unit;
	
	@BeforeEach
	public void setup() {
		unit = new UserServiceImpl(userRepository);
	}
	
	
	@Test
	void test_getById_withExistingId_shouldReturnObject() {
		// given
		var id = UUID.randomUUID().toString();
		var user = new User().withId(id);
		
		// mock definitions
		Mockito.when(userRepository.findById(id))
			.thenReturn(Optional.of(user));
		
		// test
		var result = unit.getById(id);
		
		// assert
		assertEquals(user, result);
		
		// verify
		Mockito.verify(userRepository).findById(id);
	}

	@Test
	void test_getById_withInexistingId_shouldReturnException() {
		// given
		var id = UUID.randomUUID().toString();
		
		// mock definitions
		Mockito.when(userRepository.findById(id))
		.thenReturn(Optional.empty());
		
		// test
		try {
			unit.getById(id);
			fail("Expected NotFoundException");
		} catch (NotFoundException ex) {
			// assert
			assertEquals("User with ID " + id + " not found", ex.getMessage());
		}
		
		// verify
		Mockito.verify(userRepository).findById(id);
	}
}
