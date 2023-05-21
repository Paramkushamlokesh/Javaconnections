package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.service.ServiceDao;

import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	ServiceDao sd;
	
	@GetMapping("/home")
	public String getaome() {
		StringBuilder sb=new StringBuilder();
		 sd.findbydepart("CSE").forEach(e->sb.append(e+"\n"));
		 return sb.toString();
	}

}
