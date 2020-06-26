package com.onlinetest.model;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class AuthenticationResponse {

	private final String jwttoken;
	private final GrantedAuthority currentUserRole;

	public AuthenticationResponse(String jwt, GrantedAuthority currentUserRole) {
		super();
		this.jwttoken = jwt;
		this.currentUserRole = currentUserRole;
	}
}
