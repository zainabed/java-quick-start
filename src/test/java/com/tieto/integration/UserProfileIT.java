package com.tieto.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tieto.entity.User;
import com.tieto.entity.UserProfile;

public class UserProfileIT {

	User user;
	UserProfile userProfile;
	String userId = "123";
	
	public UserProfileIT(){
		user = new User();
		user.setId(userId);
		userProfile = new UserProfile();
		userProfile.setUser(user);
	}
	
	@Test
	public void getUserIdFromUserProfile(){
		assertEquals(userProfile.getUserId(), userId);
	}
}
