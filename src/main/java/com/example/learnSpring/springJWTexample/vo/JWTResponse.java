package com.example.learnSpring.springJWTexample.vo;

import java.io.Serializable;

public class JWTResponse implements Serializable {
	
	private static final long serialVersionUID = -8091879091924046844L;
	
	private String authToken;

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
	

}
