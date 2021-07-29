package com.viv.mockito.repository;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.viv.mockito.entity.User;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryIntegrationTest {
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private UserRepository userRepository;

	
	@Test
	public void whenFindByName_thenReturnUser() {
		
		//given
		String name = "sibin";
		User user = new User();
		user.setName(name);
		testEntityManager.persist(user);
		testEntityManager.flush();
		
		//when
		User found = userRepository.findByName(name);
		
		//then
		Assertions.assertNotNull(found);
		
		Assertions.assertEquals(found.getName(), name);
		
		
	}

}
