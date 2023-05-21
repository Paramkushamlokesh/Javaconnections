package com.demo.controller;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.services.UserServiced;

import jakarta.validation.Valid;

@RestController
public class HelperController {
	
	@Autowired
	UserServiced us;
		
		@PostMapping("/register")
		public ResponseEntity<User> registerUser(@Valid @RequestBody User user){
			return new ResponseEntity<User>(us.save(user),HttpStatus.CREATED);
		}
		@GetMapping("/heelo/login")
		public ResponseEntity<String> registerUser(Authentication auth){
			//System.out.println(auth);
			try {
				return new ResponseEntity<String>("hello login cred"+auth.getName(),HttpStatus.OK);
			}
			catch(Exception exc) {
				throw new RuntimeException(exc.getMessage());
			}
		}
		@GetMapping("/welcome")
		public ResponseEntity<String> registerser(Authentication auth){
			
			try {
				return new ResponseEntity<String>("hello "+auth.getName(),HttpStatus.OK);
			}
			catch(Exception exc) {
				throw new RuntimeException(exc.getMessage());
			}
			
		}
}
