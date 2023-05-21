package com.practice.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.practice.service.MyUserDetailsService;

import jakarta.annotation.security.PermitAll;


@Configuration
@EnableWebSecurity
public class Mysecurity{
	@Autowired
	MyUserDetailsService muds;
	
	@Bean
	public SecurityFilterChain fc(HttpSecurity http) throws Exception {
			http
	        .authorizeHttpRequests()
	        .requestMatchers("/home/**").hasRole("NORMAL")
	        .anyRequest().authenticated()
	        .and()
	        .httpBasic()
	        .and()
	        .csrf().disable();
	    http.authenticationProvider(daoprovider());
	    return http.build();
	}
	
//	@Bean
//	public AuthenticationManager am(AuthenticationConfiguration authcon) throws Exception {
//		return authcon.getAuthenticationManager();
//		
//	}
	public DaoAuthenticationProvider daoprovider() {
		DaoAuthenticationProvider dap=new DaoAuthenticationProvider();
		dap.setUserDetailsService(muds);
		dap.setPasswordEncoder(passwordEncode());
		return dap;
	}
	
//	 @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//            .username("lokesh")
//            .password("lokesh")
//            .roles("NORMAL")
//            .build();
//        
//        return new InMemoryUserDetailsManager(user);
//    }
	 
	 @Bean
	 public PasswordEncoder passwordEncode() {
		 return new BCryptPasswordEncoder(10);
	 }
}
