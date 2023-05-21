package com.boot.test;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
;

@Controller
public class Demo {
	
	
	@RequestMapping("/abc")
	public String getS() {
		return "NewFile.html";
	}
	
	
}
