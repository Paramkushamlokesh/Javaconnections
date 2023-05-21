package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.repository.UserRepo;


@Service
public class UserServicedImpl implements UserServiced {
	
	@Autowired
	UserRepo ur;
	@Autowired
	PasswordEncoder pe;

	@Override
	public User save(User user) {
		user.setPassword(pe.encode(user.getPassword()));
		return ur.save(user);
	}

	@Override
	public User findUserbyName(String name) {
		return ur.findByUsername(name);
	}

	@Override
	public User findUserbyId(Integer id) {
		return ur.findById(id).get();
	}

}
