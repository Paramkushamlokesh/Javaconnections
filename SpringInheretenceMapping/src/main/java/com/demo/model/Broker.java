package com.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "BrokerId")
public class Broker extends User{
	
	private String name;
	
	 @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	List<Property> list=new ArrayList<>();
	
	public Broker() {
		
	}

	public Broker(String username, String password) {
		super(username, password);
	}

	public Broker(String username, String password, String name) {
		super(username, password);
		this.name = name;
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
		return "Broker [name=" + name + ", id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	

}
