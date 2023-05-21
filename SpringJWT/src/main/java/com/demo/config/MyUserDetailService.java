package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.model.User;
import com.demo.services.UserServiced;

@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	UserServiced us;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=us.findUserbyName(username);
		if(user==null) throw new UsernameNotFoundException("User not found");
		return new MyUserDetails(user);
	}

}
