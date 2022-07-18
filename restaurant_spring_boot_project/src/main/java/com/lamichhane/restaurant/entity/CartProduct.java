package com.lamichhane.restaurant.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="food_cartproduct")
public class CartProduct {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_cartproduct_id_seq")
	@SequenceGenerator(name = "food_cartproduct_id_seq", 
	                   sequenceName = "food_cartproduct_seq",
	                   allocationSize = 1) 
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private int price;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="image")
	private String image;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="cart_id")
	@JsonBackReference
    private Order order;
	
	
	public CartProduct() {
	}


	public CartProduct(String name, int price, int quantity, String image) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}
	
	



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	public void setMyOrder(Order order) {
		this.order = order;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public int getId() {
		return id;
	}
	
	



	
	
}
