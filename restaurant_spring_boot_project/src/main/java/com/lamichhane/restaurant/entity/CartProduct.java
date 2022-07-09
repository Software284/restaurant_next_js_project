package com.lamichhane.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	private double price;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="image")
	private String image;
	
	
	public CartProduct() {
	}
	
	
	
	public CartProduct(int id, String name, double price, int quantity, String image) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}
	@Override
	public String toString() {
		return "CartProduct [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", image="
				+ image + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public void setPrice(double price) {
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
	
	
	
	
}
