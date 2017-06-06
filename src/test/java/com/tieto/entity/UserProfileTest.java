package com.tieto.entity;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserProfileTest {
  private User user = mock(User.class);
  private UserProfile userProfile = new UserProfile();
  private String userId = "122";
  
  public UserProfileTest() {
  	userProfile.setUser(user);	
  }
  
  
  @Before
  public void beforeClass() {
  	when(user.getId()).thenReturn(userId);
    	
  }
  
  @Test
  public void testUserId(){
  	assertEquals(userProfile.getUserId(), userId);
  }
  
}
