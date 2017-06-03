package com.tieto.entity;

public class User {
	 private String id;
	 private String username;
	 
   protected void setId(String id){
  	 this.id = id;
   }
   
   public String getId(){
  	 return this.id;
   }
   
   public void setUsername(String username) {
  	 this.username = username;
   }
   
   public String getUsername(){
  	 return this.username;
   }
}
