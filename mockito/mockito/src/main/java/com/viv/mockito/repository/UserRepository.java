package com.viv.mockito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viv.mockito.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByName(String name);

}
