package com.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "customerId")
public class Customer extends User{
	
	
	private String name;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	List<Property> list=new ArrayList<>();
	
	
	
	public Customer(){
		
	}
	public Customer(String username, String password, String name) {
		super(username, password);
		this.name = name;
	}

	public Customer(String username, String password) {
		super(username, password);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Property> getList() {
		return list;
	}
	public void setList(List<Property> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
		
	
	
}
