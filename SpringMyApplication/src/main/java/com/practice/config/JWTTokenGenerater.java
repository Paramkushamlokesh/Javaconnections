package com.practice.config;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTTokenGenerater extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
				SecretKey key=Keys.hmacShaKeyFor(Constant.KEY.getBytes());
				
				String jwt=Jwts.builder()
						.setIssuer("lokesh")
						.setSubject("JWT_TOKEN")
						.claim("username",auth.getName())
						.claim("authorities", pop(auth.getAuthorities()))
						.setIssuedAt(new Date())
						.setExpiration(new Date(new Date().getTime()+30000000))
						.signWith(key).compact();
				
				response.setHeader(Constant.JWT_HEADER, jwt);
		}
		filterChain.doFilter(request, response);
	}
	
	private String pop(Collection<? extends GrantedAuthority> set) {
		Set<String> stringSet=new HashSet<>();
		for(GrantedAuthority x:set) {
			stringSet.add(x.getAuthority());
			//System.out.println(x.getAuthority());
		}
		return String.join(",", stringSet);
	}

}
