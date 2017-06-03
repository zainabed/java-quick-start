package com.tieto.entity;

import static org.junit.Assert.*;

import org.junit.Test;


public class UserTest{

	User user = new User();
	
	@Test
	public void testId(){
		String id = "23434";
		user.setId(id);
		assertEquals(user.getId(),id);
	}
	
	@Test
	public void testUsername(){
		String username = "testuser";
		user.setUsername(username);
		assertEquals(user.getUsername(), username);
	}
	
}
