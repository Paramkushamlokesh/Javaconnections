package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> globalExp(Exception ex){
		return new ResponseEntity<String>(ex.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
	}
}
