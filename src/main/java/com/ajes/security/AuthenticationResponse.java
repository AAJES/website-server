package com.ajes.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class AuthenticationResponse {
	
	private String jwtToken;

	public AuthenticationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthenticationResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}


	
}
