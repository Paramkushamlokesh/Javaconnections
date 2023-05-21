package com.practice.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.model.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee,String>{
	Employee findByUsername(String username);
}
