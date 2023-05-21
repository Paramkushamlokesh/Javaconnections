package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Owner;
import com.practice.service.OwnerService;

import jakarta.validation.Valid;

@RestController
public class HelperController {
	@Autowired 
	OwnerService os;
	
	
	@PostMapping("/register")
	public ResponseEntity<Owner> register(@Valid @RequestBody Owner owner){
		return new ResponseEntity<Owner>(os.save(owner),HttpStatus.CREATED);
	}
	
	@GetMapping("/welcome")
	public ResponseEntity<Owner> register(Authentication auth){
		return new ResponseEntity<Owner>(os.findOwnerbyusername(auth.getName()),HttpStatus.OK);
	}
	@GetMapping("/list")
	public ResponseEntity<List<Owner>> list(Authentication auth){
		return new ResponseEntity<List<Owner>>(os.findAllOwners(),HttpStatus.OK);
	}
	@GetMapping("/welcome/{id}")
	public ResponseEntity<Owner> findone(Authentication auth,@PathVariable Integer id){
		return new ResponseEntity<Owner>(os.findOwnerbyid(id),HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public ResponseEntity<String> login(Authentication auth){
		try {
			return new ResponseEntity<String>("hello "+auth.getName(),HttpStatus.OK);
		}
		catch(Exception exc) {
			throw new RuntimeException(exc.getMessage());
		}
	}
	
}
