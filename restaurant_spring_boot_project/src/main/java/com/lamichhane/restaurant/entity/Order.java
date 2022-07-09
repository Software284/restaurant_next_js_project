package com.lamichhane.restaurant.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


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
	
	private CartProduct[] cartproduct;
	
	@Column(name="totalprice")
	private double totalPrice;
	
	private Address address;
	
	@Column(name="gender")
	private String gender;
	
	
	public Order() {
	}


	public Order(int orderId, CartProduct[] cartproduct, double totalPrice, Address address, String gender) {
		super();
		this.id = orderId;
		this.cartproduct = cartproduct;
		this.totalPrice = totalPrice;
		this.address = address;
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + id + ", cartproduct=" + Arrays.toString(cartproduct) + ", totalPrice="
				+ totalPrice + ", address=" + address + ", gender=" + gender + "]";
	}


	public int getOrderId() {
		return id;
	}


	public void setOrderId(int orderId) {
		this.id = orderId;
	}


	public CartProduct[] getCartproduct() {
		return cartproduct;
	}


	public void setCartproduct(CartProduct[] cartproduct) {
		this.cartproduct = cartproduct;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	
	
	
	
}
