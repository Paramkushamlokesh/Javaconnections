package com.practice.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Employee {
	@Id
	String username;
	@JsonIgnore
	String password;
	String department;
	String role;
	
	
	public Employee(String username, String password, String department, String role) {
		this.username = username;
		this.password = password;
		this.department = department;
		this.role = role;
	}


	public Employee() {
		
	}


	@Override
	public String toString() {
		return "username=" + username + ", password=" + password + ", department=" + department + ", role="+ role + "\n";
	}
	
	
}
