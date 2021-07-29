package com.viv.mockito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viv.mockito.entity.User;
import com.viv.mockito.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserByName(String name) {
		System.out.println("in service : "+name);
		return userRepository.findByName(name);
	}
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);	
	}

	

	

}
