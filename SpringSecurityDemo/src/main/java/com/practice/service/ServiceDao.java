package com.practice.service;


import java.util.List;

import com.practice.model.Employee;


public interface ServiceDao {
	public Employee RegisterEmp(Employee e);
	public Employee updateEMp(Employee e);
	public Employee deleteEmp(String username);
	public List<Employee> findbydepart(String str);
}
