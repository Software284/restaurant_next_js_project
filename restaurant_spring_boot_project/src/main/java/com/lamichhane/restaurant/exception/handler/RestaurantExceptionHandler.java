package com.lamichhane.restaurant.exception.handler;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lamichhane.restaurant.exception.classes.AddressNotFoundException;
import com.lamichhane.restaurant.exception.classes.AuthoritiesEntityNotFoundException;
import com.lamichhane.restaurant.exception.classes.CartProductNotFoundException;
import com.lamichhane.restaurant.exception.classes.CustomerNotFoundException;
import com.lamichhane.restaurant.exception.classes.FavouritesProductNotFoundException;
import com.lamichhane.restaurant.exception.classes.OrderNotFoundException;
import com.lamichhane.restaurant.exception.classes.ProductNotFoundException;
import com.lamichhane.restaurant.exception.classes.RoleEntityNotFoundException;
import com.lamichhane.restaurant.exception.classes.StandardRestErrorResponse;
import com.lamichhane.restaurant.exception.classes.UserEntityNotFoundException;
import com.lamichhane.restaurant.exception.classes.UserRoleEntityNotFoundException;




@ControllerAdvice
public class RestaurantExceptionHandler  {
		
		
			// Add an exception handler for ProductNotFoundException
			@ExceptionHandler
			public ResponseEntity<StandardRestErrorResponse> handleException(ProductNotFoundException exc) {
	
				StandardRestErrorResponse error = new StandardRestErrorResponse(
													HttpStatus.NOT_FOUND.value(),
													exc.getMessage(),
													System.currentTimeMillis());
				
				
				return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
			}
			
			// Add an exception handler for AddressNotFoundException
						@ExceptionHandler
						public ResponseEntity<StandardRestErrorResponse> handleException(AddressNotFoundException exc) {
				
							StandardRestErrorResponse error = new StandardRestErrorResponse(
																HttpStatus.NOT_FOUND.value(),
																exc.getMessage(),
																System.currentTimeMillis());
							
							
							return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
						}
						
						// Add an exception handler for CartProductNotFoundException
						@ExceptionHandler
						public ResponseEntity<StandardRestErrorResponse> handleException(CartProductNotFoundException exc) {
				
							StandardRestErrorResponse error = new StandardRestErrorResponse(
																HttpStatus.NOT_FOUND.value(),
																exc.getMessage(),
																System.currentTimeMillis());
							
							
							return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
						}
						// Add an exception handler for ProductNotFoundException
						@ExceptionHandler
						public ResponseEntity<StandardRestErrorResponse> handleException(OrderNotFoundException exc) {
				
							StandardRestErrorResponse error = new StandardRestErrorResponse(
																HttpStatus.NOT_FOUND.value(),
																exc.getMessage(),
																System.currentTimeMillis());
							
							
							return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
						}
						
						// Add an exception handler for CustomerNotFoundException
						@ExceptionHandler
						public ResponseEntity<StandardRestErrorResponse> handleException(CustomerNotFoundException exc) {
				
							StandardRestErrorResponse error = new StandardRestErrorResponse(
																HttpStatus.NOT_FOUND.value(),
																exc.getMessage(),
																System.currentTimeMillis());
							
							
							return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
						}
						
						// Add an exception handler for UserEntityNotFoundException
						@ExceptionHandler
						public ResponseEntity<StandardRestErrorResponse> handleException(UserEntityNotFoundException exc) {
				
							StandardRestErrorResponse error = new StandardRestErrorResponse(
																HttpStatus.NOT_FOUND.value(),
																exc.getMessage(),
																System.currentTimeMillis());
							
							
							return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
						}
						
						// Add an exception handler for AuthoritiesEntiyNotFoundException
						@ExceptionHandler
						public ResponseEntity<StandardRestErrorResponse> handleException(AuthoritiesEntityNotFoundException exc) {
				
							StandardRestErrorResponse error = new StandardRestErrorResponse(
																HttpStatus.NOT_FOUND.value(),
																exc.getMessage(),
																System.currentTimeMillis());
							
							
							return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
						}
						
						// Add an exception handler for RoleEntityFoundException
						@ExceptionHandler
						public ResponseEntity<StandardRestErrorResponse> handleException(RoleEntityNotFoundException exc) {
				
							StandardRestErrorResponse error = new StandardRestErrorResponse(
																HttpStatus.NOT_FOUND.value(),
																exc.getMessage(),
																System.currentTimeMillis());
							
							
							return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
						}
						
						// Add an exception handler for UserRoleEntityNotFoundException
						@ExceptionHandler
						public ResponseEntity<StandardRestErrorResponse> handleException(UserRoleEntityNotFoundException exc) {
				
							StandardRestErrorResponse error = new StandardRestErrorResponse(
																HttpStatus.NOT_FOUND.value(),
																exc.getMessage(),
																System.currentTimeMillis());
							
							
							return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
						}
						
						// Add an exception handler for UserRoleEntityNotFoundException
						@ExceptionHandler
						public ResponseEntity<StandardRestErrorResponse> handleException(FavouritesProductNotFoundException exc) {
				
							StandardRestErrorResponse error = new StandardRestErrorResponse(
																HttpStatus.NOT_FOUND.value(),
																exc.getMessage(),
																System.currentTimeMillis());
							
							
							return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
						}
			
			// Add another exception handler ... to catch any exception (catch all)

			@ExceptionHandler
			public ResponseEntity<StandardRestErrorResponse> handleException(Exception exc) {
				
				// create CustomerErrorResponse
				
				StandardRestErrorResponse error = new StandardRestErrorResponse(
													HttpStatus.BAD_REQUEST.value(),
													exc.getMessage(),
													System.currentTimeMillis());
				
				// return ResponseEntity
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}


		
		
}
