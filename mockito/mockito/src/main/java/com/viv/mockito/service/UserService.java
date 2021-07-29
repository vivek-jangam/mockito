package com.viv.mockito.service;

import com.viv.mockito.entity.User;

public interface UserService {

	public User getUserByName(String name);

	public User addUser(User user);
}
