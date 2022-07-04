package com.lamichhane.restaurant.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="food_product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_product_id_seq")
	@SequenceGenerator(name = "food_product_id_seq", 
	                   sequenceName = "food_product_seq",
	                   allocationSize = 1) 
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="img")
	private String img;
	
	
	@Column(name="ratings")
	private int ratings ;
	
	
	@Column(name="price")
	private double price;
	
	
	
	public Product() {
	}



	public Product(String name, String img, int ratings, double price) {
		this.name = name;
		this.img = img;
		this.ratings = ratings;
		this.price = price;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public int getRatings() {
		return ratings;
	}



	public void setRatings(int ratings) {
		this.ratings = ratings;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getId() {
		return id;
	}
	
	

	


	
	
	
	




	
	
	
	
	
	
}
