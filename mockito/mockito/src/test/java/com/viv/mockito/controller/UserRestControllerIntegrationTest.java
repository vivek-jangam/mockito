package com.viv.mockito.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.viv.mockito.entity.User;
import com.viv.mockito.service.UserService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService userService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {
		User user = new User();
		user.setName("sibin");
		
		when(userService.getUserByName("sibin")).thenReturn(user);
		
		mvc.perform(get("/api/user").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("sibin"));
	}

}
