package com.hotel.RolesMicro.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "owner")
public class Owner {
    
	private String username;
	private String password;
	
	public Owner() {
	}

	public Owner(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Owner [username=" + username + ", password=" + password + "]";
	}
	
}
