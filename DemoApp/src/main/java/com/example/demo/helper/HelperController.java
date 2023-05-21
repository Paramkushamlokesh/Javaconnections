package com.example.demo.helper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelperController {
	
	@GetMapping("/hello")
	public String getMsg() {
		return "hello lokesh";
	}
}
