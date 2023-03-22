package com.boot.test;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Demo {
	
	
	@RequestMapping("/abc")
	public String getS() {
		return "NewFile.html";
	}
	
	
}
