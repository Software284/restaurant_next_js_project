package com.lamichhane.restaurant.service;
import java.util.List;

import com.lamichhane.restaurant.entity.Address;
import com.lamichhane.restaurant.entity.Product;

public interface AddressService {

	public List<Address> getAllAddress();
	   
	public void saveAddress(Address theAddress);

	public Address getAddress(int id);

	public void deleteAddress(int id);
}
