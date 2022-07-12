package com.lamichhane.restaurant.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="food_customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_customer_id_seq")
	@SequenceGenerator(name = "food_customer_id_seq", 
	                   sequenceName = "food_customer_seq",
	                   allocationSize = 1) 
	@Column(name="id")
	private int id;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="gender")
	private String gender;
	
	@OneToOne(mappedBy="customer",cascade = CascadeType.ALL)
	private Order order;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address")
	private Address address;
	

	
	
	
	public Customer() {
		
	}





	public Customer(String name, String email, String gender, Order order, Address address) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.order = order;
		this.address = address;
	}









	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getGender() {
		return gender;
	}





	public void setGender(String gender) {
		this.gender = gender;
	}





	public Order getOrder() {
		return order;
	}





	public void setOrder(Order order) {
		this.order = order;
	}





	public Address getAddress() {
		return address;
	}





	public void setAddress(Address address) {
		this.address = address;
	}





	public int getId() {
		return id;
	}
	
	


	
	
	



	
}
