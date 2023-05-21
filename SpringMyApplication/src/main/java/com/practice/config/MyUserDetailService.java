package com.practice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.model.Owner;
import com.practice.service.OwnerService;

@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	OwnerService os;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Owner o=os.findOwnerbyusername(username);
		if(o==null)throw new BadCredentialsException(username+" not found");
		return new MyUserDetails(o);
	}

}
