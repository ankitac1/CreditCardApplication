package com.cg.exceptions;

public class UserIdNotFoundException extends RuntimeException {
	
	public UserIdNotFoundException(String message) {
		super(message);
	}
}
