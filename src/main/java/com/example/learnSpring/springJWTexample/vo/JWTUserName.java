package com.example.learnSpring.springJWTexample.vo;

import java.io.Serializable;

public class JWTUserName implements Serializable {
	
	private static final long serialVersionUID = 5926468583005150707L;
	
	private String userName;
	private String password;
	
	public JWTUserName()
	{
		
	}

	public JWTUserName(String username, String password) {
		this.setUserName(username);
		this.setPassword(password);
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
