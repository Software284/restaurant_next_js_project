package com.lamichhane.restaurant.exception.classes;



public class RoleEntityNotFoundException extends RuntimeException {

	public RoleEntityNotFoundException() {
	}

	public RoleEntityNotFoundException(String message) {
		super(message);
	}

	public RoleEntityNotFoundException(Throwable cause) {
		super(cause);
	}

	public RoleEntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RoleEntityNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
