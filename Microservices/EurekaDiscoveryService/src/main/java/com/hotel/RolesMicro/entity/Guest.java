package com.hotel.RolesMicro.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "guest")
public class Guest {
	@Id
	private String fullName;
	private String age;
	private String email;
	private long contactNo;
	private int noOfAdults;
	private int noOfChild;
	
	public Guest() {
	}

	public Guest(String fullName, String age, String email, long contactNo, int noOfAdults, int noOfChild) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.email = email;
		this.contactNo = contactNo;
		this.noOfAdults = noOfAdults;
		this.noOfChild = noOfChild;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public int getNoOfAdults() {
		return noOfAdults;
	}

	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public int getNoOfChild() {
		return noOfChild;
	}

	public void setNoOfChild(int noOfChild) {
		this.noOfChild = noOfChild;
	}

	@Override
	public String toString() {
		return "Guest [fullName=" + fullName + ", age=" + age + ", email=" + email + ", contactNo=" + contactNo
				+ ", noOfAdults=" + noOfAdults + ", noOfChild=" + noOfChild + "]";
	}
	
}

