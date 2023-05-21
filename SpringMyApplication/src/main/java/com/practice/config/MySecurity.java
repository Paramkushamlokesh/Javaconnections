package com.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.practice.model.Role;



@Configuration
@EnableWebSecurity
public class MySecurity {
	@Bean
	public SecurityFilterChain mySecurityFilterChain(HttpSecurity http)throws Exception{
		http
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
        	.csrf().disable()
        	.authorizeHttpRequests()
        	.requestMatchers(HttpMethod.POST,"/register").permitAll()
        	.requestMatchers(HttpMethod.GET,"/list").hasAuthority("ROLE_ADMIN")
        	.anyRequest()
        	.authenticated()
        	.and()
        	.addFilterAfter(new JWTTokenGenerater(), BasicAuthenticationFilter.class)
        	.addFilterBefore(new JWTTokenValidater(), BasicAuthenticationFilter.class)
        	.httpBasic();
		
    return http.build();
	}
	@Bean
	public PasswordEncoder myPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
