package com.cg.exceptions;

public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException(String str)
	{
		super(str);
	}

}
