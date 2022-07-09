package com.lamichhane.restaurant.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamichhane.restaurant.dao.AddressDAO;
import com.lamichhane.restaurant.entity.Address;
import com.lamichhane.restaurant.exception.classes.AddressNotFoundException;



@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressDAO addressDAO;

	
	@Override
	@Transactional
	public List<Address> getAllAddress() {
		
		return addressDAO.findAll();
	}

	@Override
	@Transactional
	public void saveAddress(Address theAddress) {
		addressDAO.save(theAddress);
	}

	@Override
	@Transactional
	public Address getAddress(int theId) {
		Optional<Address> address = addressDAO.findById(theId);
		if(address.isEmpty()) {
			throw new AddressNotFoundException("Address Not Found With Id-"+theId);
		}
		return address.get();
		
	}

	@Override
	@Transactional
	public void deleteAddress(int id) {
		addressDAO.deleteById(id);
	}
	
}
