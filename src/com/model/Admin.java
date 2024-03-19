package com.model;

import java.time.LocalDate;

public class Admin {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String address;
	private String username;
	private String password;
	private String role;
	private LocalDate joiningdate;
	
	public Admin() {

	}
	
	public Admin(String firstName, String lastName, String email,String phoneNumber, String address, String username,
			String password, String role,LocalDate joiningdate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email=email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.username = username;
		this.password = password;
        this.role=role;
        this.joiningdate=joiningdate;
}
	
	public Admin(int id, String firstName, String lastName, String email, String phoneNumber, String address,
			String username, String password,String role,LocalDate joiningdate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email=email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.username = username;
		this.password = password;
		this.role = role;
		this.joiningdate=joiningdate;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
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
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role= role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getJoiningDate()
	{
		return joiningdate;
	}
	public LocalDate setJoiningDate(LocalDate joiningdate)
	{
		return this.joiningdate=joiningdate;
	}

	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", username=" + username + ", password="
				+ password + ", role=" + role +", joining_date="+joiningdate+ "]";
	}


}