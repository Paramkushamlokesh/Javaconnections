package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Controller;

@Controller
@EnableWebSecurity
public class MySecurity {
//	@Autowired
//	UserDetailsService usd;
	
	
	@Bean
	public SecurityFilterChain mySecurityFillterChain(HttpSecurity http)throws Exception{
		http
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST, "/register").permitAll()
		.anyRequest().authenticated().and()
		.addFilterAfter(new JWTTokenGeneraterFillter(), BasicAuthenticationFilter.class)
		.addFilterBefore(new JWTTokenValidaterFillter(), BasicAuthenticationFilter.class)
		.formLogin()
		.and().httpBasic();

		return http.build();
	}
	
//	@Bean
//	public DaoAuthenticationProvider mydaoAuthenticationProvider() {
//		DaoAuthenticationProvider dap=new DaoAuthenticationProvider();
//		dap.setUserDetailsService(usd);
//		dap.setPasswordEncoder(myPasswordEncoder());
//		return dap;
//	}
	@Bean
	public PasswordEncoder myPasswordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
}
