package com.spandiar.rest.jersey.ASampleRest.exception;

public class AuthenticationFailureException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthenticationFailureException() {
		// TODO Auto-generated constructor stub
	}
	
	public AuthenticationFailureException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
