package com.hotel.auth.dto;

import com.hotel.auth.enums.ClientType;
import lombok.*;

@SuppressWarnings("unused")
public class CredentialsDto {

    private String email;
    private String password;
    private String role;

    public CredentialsDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
}