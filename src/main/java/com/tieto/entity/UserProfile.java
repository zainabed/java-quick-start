package com.tieto.entity;

public class UserProfile {

	private User user;
	
	public void setUser(User user){
		this.user = user;
	}
	
	public String getUserId(){
		return this.user.getId();
	}
}
