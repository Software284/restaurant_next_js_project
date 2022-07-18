package com.lamichhane.restaurant.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="food_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_order_id_seq")
	@SequenceGenerator(name = "food_order_id_seq", 
	                   sequenceName = "food_order_seq",
	                   allocationSize = 1) 
	@Column(name="id")
	private int id;
	
	@OneToMany(mappedBy="order",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonManagedReference
	private List<CartProduct> cartdata;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@Column(name="totalprice")
	private double totalprice;
	
	
	
	
	
	public Order() {
	}




	public Order(List<CartProduct> cartdata, Customer customer, double totalprice, List<CartProduct> ingredients) {
		this.cartdata = cartdata;
		this.customer = customer;
		this.totalprice = totalprice;
	}





	public List<CartProduct> getCartdata() {
		return cartdata;
	}




	public void setCartdata(List<CartProduct> cartdata) {
		this.cartdata = cartdata;
	}




	public Customer getCustomer() {
		return customer;
	}




	public void setCustomer(Customer customer) {
		this.customer = customer;
	}




	public double getTotalprice() {
		return totalprice;
	}




	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}





	public int getId() {
		return id;
	}
	
	
	public void add(CartProduct tempCartProduct) {
		if(cartdata == null) {
			cartdata = new ArrayList<>();
			
		}
		cartdata.add(tempCartProduct);
		tempCartProduct.setMyOrder(this);
	}
	
	
	
	
	
	
	
	




	
	
	



}
