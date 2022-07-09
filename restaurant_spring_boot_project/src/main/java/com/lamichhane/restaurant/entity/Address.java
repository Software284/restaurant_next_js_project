package com.lamichhane.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
	
	public Address() {
		
	}
	public Address(String street, int zipcode, String country) {
		this.street = street;
		this.zipcode = zipcode;
		this.district = country;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", zipcode=" + zipcode + ", district=" + district + "]";
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
	public String getCountry() {
		return district;
	}
	public void setCountry(String country) {
		this.district = country;
	}
	public int getId() {
		return id;
	}
	
	
	
	
	
	

}
