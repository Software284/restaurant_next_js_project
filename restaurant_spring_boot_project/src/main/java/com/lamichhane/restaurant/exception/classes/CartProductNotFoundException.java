package com.lamichhane.restaurant.exception.classes;



public class CartProductNotFoundException extends RuntimeException {

	public CartProductNotFoundException() {
	}

	public CartProductNotFoundException(String message) {
		super(message);
	}

	public CartProductNotFoundException(Throwable cause) {
		super(cause);
	}

	public CartProductNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CartProductNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
