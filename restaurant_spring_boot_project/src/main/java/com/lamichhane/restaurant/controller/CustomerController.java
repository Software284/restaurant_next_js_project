package com.lamichhane.restaurant.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.lamichhane.restaurant.entity.Customer;
import com.lamichhane.restaurant.service.CustomerService;
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	/* Product API request processing */
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/customer/{customerId}")
	public Customer getAddress(@PathVariable int customerId) {
		Customer cust = customerService.getCustomer(customerId);
		return cust;
	}
	
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveAddress(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return new ResponseEntity<>(customer,HttpStatus.CREATED);
	}
	
	@PutMapping("/customer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/customer/{customerId}")
	public String deleteCusomter(@PathVariable int customerId) {
		Customer customer = customerService.getCustomer(customerId);
		customerService.deleteCustomer(customerId);
		
		return "Deleted Customer  id is : "+customerId;
	}

}
