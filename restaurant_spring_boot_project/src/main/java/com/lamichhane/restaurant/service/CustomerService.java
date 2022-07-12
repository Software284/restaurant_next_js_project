package com.lamichhane.restaurant.service;
import java.util.List;

import com.lamichhane.restaurant.entity.Address;
import com.lamichhane.restaurant.entity.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomer();
	   
	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
