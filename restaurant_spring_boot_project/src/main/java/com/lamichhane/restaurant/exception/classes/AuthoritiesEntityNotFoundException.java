package com.lamichhane.restaurant.exception.classes;



public class AuthoritiesEntityNotFoundException extends RuntimeException {

	public AuthoritiesEntityNotFoundException() {
	}

	public AuthoritiesEntityNotFoundException(String message) {
		super(message);
	}

	public AuthoritiesEntityNotFoundException(Throwable cause) {
		super(cause);
	}

	public AuthoritiesEntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthoritiesEntityNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
