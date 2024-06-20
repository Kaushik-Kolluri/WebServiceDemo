package com.kaushik.training.webservicedemo.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND) // if a user is not found we are making it to display 404 not found page.
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(message);
	}
	
	
}
