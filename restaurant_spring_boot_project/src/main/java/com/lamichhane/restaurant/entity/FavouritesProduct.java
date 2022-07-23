package com.lamichhane.restaurant.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="food_favouritesproduct")
public class FavouritesProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_favouritesproduct_id_seq")
	@SequenceGenerator(name = "food_favouritesproduct_id_seq", 
	                   sequenceName = "food_favouritesproduct_seq",
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
	
	@Column(name="username")
	private String username;
	
	
	public FavouritesProduct() {
	}


	public FavouritesProduct(String name, int price, int quantity, String image, String username) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
		this.username = username;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getId() {
		return id;
	}	
	
}
