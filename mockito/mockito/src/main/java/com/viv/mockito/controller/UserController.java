package com.viv.mockito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viv.mockito.entity.User;
import com.viv.mockito.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public User getAllEmployees() {
		return userService.getUserByName("sibin");
	}
	
	@PostMapping("/user")
	public User addUser() {
		User user = new User();
		user.setId(1);
		user.setName("sibin");
		return userService.addUser(user);
		
	}
}
