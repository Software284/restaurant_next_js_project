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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lamichhane.restaurant.entity.Address;
import com.lamichhane.restaurant.entity.Product;
import com.lamichhane.restaurant.service.AddressService;


@RestController
@RequestMapping("/restaurant")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	/* Product API request processing */
	
	@GetMapping("/address")
	public List<Address> getAllAddress() {
		return addressService.getAllAddress();
	}
	
	@GetMapping("/address/{addressId}")
	public Address getAddress(@PathVariable int addressId) {
		Address address = addressService.getAddress(addressId);
		return address;
	}
	
	
	@PostMapping("/address")
	public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
		addressService.saveAddress(address);
		return new ResponseEntity<>(address,HttpStatus.CREATED);
	}
	
	@PutMapping("/address")
	public Address updateAddress(@RequestBody Address address) {
		addressService.saveAddress(address);
		return address;
	}
	
	@DeleteMapping("/address/{addressId}")
	public String deleteAddress(@PathVariable int addressId) {
		Address address = addressService.getAddress(addressId);
		addressService.deleteAddress(addressId);
		
		return "Deleted Address  id is : "+addressId;
	}

}
