package com.lamichhane.restaurant.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamichhane.restaurant.dao.CustomerDAO;
import com.lamichhane.restaurant.entity.Customer;
import com.lamichhane.restaurant.exception.classes.CustomerNotFoundException;


@Service
class CustomerServiceImpl implements CustomerService{
   
	@Autowired
	CustomerDAO customerDAO;

	
	@Override
	@Transactional
	public List<Customer> getAllCustomer() {
		return customerDAO.findAll();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.save(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		Optional<Customer> cust = customerDAO.findById(theId);
		if(cust.isEmpty()) {
			throw new CustomerNotFoundException("Customer Not Found With Id-"+theId);
		}
		return cust.get();
		
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteById(id);
	}
	
}
