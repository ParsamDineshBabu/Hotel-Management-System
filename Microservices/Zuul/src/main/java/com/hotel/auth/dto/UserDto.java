package com.hotel.auth.dto;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class UserDto {

    private String username;
    private String token;
    private String role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public UserDto() {
	}
	
	public UserDto(String username, String token, String role) {
		super();
		this.username = username;
		this.token = token;
		this.role = role;
	}
//	public UserDto(String username, String role) {
//		super();
//		this.username = username;
//		this.role = role;
//	}
	
	
    
}
