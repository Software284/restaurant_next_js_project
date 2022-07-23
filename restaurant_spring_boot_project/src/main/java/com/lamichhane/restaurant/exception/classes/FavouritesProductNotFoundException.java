package com.lamichhane.restaurant.exception.classes;



public class FavouritesProductNotFoundException extends RuntimeException {

	public FavouritesProductNotFoundException() {
	}

	public FavouritesProductNotFoundException(String message) {
		super(message);
	}

	public FavouritesProductNotFoundException(Throwable cause) {
		super(cause);
	}

	public FavouritesProductNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FavouritesProductNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
