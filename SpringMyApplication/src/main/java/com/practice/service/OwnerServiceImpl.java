package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.model.Owner;
import com.practice.repository.OwnerRepo;

@Service
public class OwnerServiceImpl implements OwnerService {
	
	@Autowired
	OwnerRepo or;
	@Autowired
	PasswordEncoder pe;
	
	@Override
	public Owner save(Owner owner) {
		owner.setPassword(pe.encode(owner.getPassword()));
		return or.save(owner);
	}

	@Override
	public Owner findOwnerbyid(Integer id) {
		return or.findById(id).orElseThrow(()->new RuntimeException("Owner not found"));
	}

	@Override
	public List<Owner> findAllOwners() {
		List<Owner> li=or.findAll();
		if(li.isEmpty()) throw new RuntimeException("no owner found");
		return li;
	}

	@Override
	public Owner findOwnerbyusername(String username) {
		Owner o=or.findByUsername(username);
		if(o==null) throw new RuntimeException("no record found with "+username);
		return o;
	}

}
