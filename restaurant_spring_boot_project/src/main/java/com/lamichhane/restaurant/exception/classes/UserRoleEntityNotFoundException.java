package com.lamichhane.restaurant.exception.classes;



public class UserRoleEntityNotFoundException extends RuntimeException {

	public UserRoleEntityNotFoundException() {
	}

	public UserRoleEntityNotFoundException(String message) {
		super(message);
	}

	public UserRoleEntityNotFoundException(Throwable cause) {
		super(cause);
	}

	public UserRoleEntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserRoleEntityNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
