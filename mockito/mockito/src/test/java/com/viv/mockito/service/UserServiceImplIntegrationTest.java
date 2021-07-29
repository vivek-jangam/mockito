package com.viv.mockito.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.viv.mockito.entity.User;
import com.viv.mockito.repository.UserRepository;

@ExtendWith(SpringExtension.class)
class UserServiceImplIntegrationTest {

	@TestConfiguration
	static class UserServiceImplTestContextConfiguration {

		@Bean
		public UserService userService() {
			return new UserServiceImplementation();
		}
	}

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@BeforeEach
	void setUp() throws Exception {
		User user = new User();
		user.setName("sibin");
		user.setId(1);
		Mockito.when(userRepository.findByName(user.getName())).thenReturn(user);
	}

	@Test
	public void whenValidName_thenEmployeeShouldBeFound() {
		String name = "sibin";
		User found = userService.getUserByName(name);

		Assertions.assertEquals(found.getName(), name);
	}

}
