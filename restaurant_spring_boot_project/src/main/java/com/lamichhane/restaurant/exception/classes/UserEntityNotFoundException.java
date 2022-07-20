package com.lamichhane.restaurant.exception.classes;



public class UserEntityNotFoundException extends RuntimeException {

	public UserEntityNotFoundException() {
	}

	public UserEntityNotFoundException(String message) {
		super(message);
	}

	public UserEntityNotFoundException(Throwable cause) {
		super(cause);
	}

	public UserEntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserEntityNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
