package com.gui.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserTests {
	
	@Autowired
	private UserRepository repo;
	
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		
		user.setEmail("data@teste.com");
		user.setFirstName("Frodo");
		user.setLastName("O Gato");
		user.setBirthdate(Date.valueOf("2020-02-01"));
		user.setCpf("123.435.643-32");
		user.setPassword("frodogato123");
		
		User savedUser = repo.save(user);
		
		User existingUser = entityManager.find(User.class, savedUser.getCpf());
		
		assertThat(existingUser.getEmail()).isEqualTo(user.getEmail());
	}
	
	@Test
	public void testFindUserByEmail() {
		String email = "guilherme_teste@teste.com";
		
		User user = repo.findByEmail(email);
		
		assertThat(user).isNotNull();
	}
}
