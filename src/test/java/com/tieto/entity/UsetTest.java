package com.tieto.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UsetTest {
	User user;
	String value;
	
	public UsetTest(){
		user = new User();
	}
	
	
	@Test
	public void userNameTest(){
		value = "testusername";
		user.setUsername(value);
		assertEquals(user.getUsername(), value);
	}
}
