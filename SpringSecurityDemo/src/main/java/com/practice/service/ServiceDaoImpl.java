package com.practice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.model.Employee;
import com.practice.repositry.EmployeeRepo;

import jakarta.annotation.PostConstruct;

@Service
public class ServiceDaoImpl implements ServiceDao {
	
	@Autowired
	EmployeeRepo er;
	@Autowired
	PasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Employee RegisterEmp(Employee e) {
		return er.save(e);
	}

	@Override
	public Employee updateEMp(Employee e) {
		return er.save(e);
	}

	@Override
	public Employee deleteEmp(String username) {
		Optional<Employee> op=er.findById(username);
		if(op.isEmpty()) throw new RuntimeException("error ");
		Employee emp=op.get();
		er.delete(emp);
		return emp;
	}
	
	@PostConstruct
	public void Init() {
		er.save(new Employee("lokesh",bCryptPasswordEncoder.encode("123"),"Mechanical","ROLE_ADMIN"));
		er.save(new Employee("Anjali",bCryptPasswordEncoder.encode("321"),"Electrical","ROLE_NORMAL"));
		er.save(new Employee("Rakeshdsf",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakedsf",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakeszcxv",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Raxzcvcvx",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakesxzcvzxc",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakeszxxxz",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakxzvzddvz",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakzzdvdzv",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakdvzxv",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakesfdndbd",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Raksdvbdfbsaas",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakesdbsdbbjk",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakeshlkvnks",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakeshassnklack",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakeshsakmcas",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakeshasjcsaj",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakeshascashjkb",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakeshsjcsnj",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakeshsacsa",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Raksacknaskncesh",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rasacknkkesh",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rasckankakesh",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
		er.save(new Employee("Rakskcnaskesh",bCryptPasswordEncoder.encode("321"),"CSE","ROLE_NORMAL"));
	}

	@Override
	public List<Employee> findbydepart(String str) {
		
		Pageable p=PageRequest.of(1, 5,Sort.by("username"));
		return er.findAll(p).stream().filter(e->e.getDepartment().equals(str)).collect(Collectors.toList());
	
	}

}
