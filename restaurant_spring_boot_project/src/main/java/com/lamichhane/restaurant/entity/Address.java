package com.lamichhane.restaurant.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="food_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_address_id_seq")
	@SequenceGenerator(name = "food_address_id_seq", 
	                   sequenceName = "food_address_seq",
	                   allocationSize = 1) 
	@Column(name="id")
	private int id;
	
	
	@Column(name="street")
	private String street;
	
	@Column(name="zipcode")
	private int zipcode;
	
	@Column(name="district")
	private String district;
	
	@OneToOne(mappedBy="address",cascade=CascadeType.ALL)
	private Customer customer;
	
	
	
	
	
	public Address() {
		
	}





	public Address(String street, int zipcode, String district, Customer customer) {
		this.street = street;
		this.zipcode = zipcode;
		this.district = district;
		this.customer = customer;
	}





	public String getStreet() {
		return street;
	}





	public void setStreet(String street) {
		this.street = street;
	}





	public int getZipcode() {
		return zipcode;
	}





	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}





	public String getDistrict() {
		return district;
	}





	public void setDistrict(String district) {
		this.district = district;
	}





//	public Customer getCustomer() {
//		return customer;
//	}
//
//
//
//
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}





	public int getId() {
		return id;
	}
	
	



	
}


