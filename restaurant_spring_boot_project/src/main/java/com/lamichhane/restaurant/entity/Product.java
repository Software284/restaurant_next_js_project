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
	
	
	@Column(name="currentprice")
	private double currentprice;
	
	@Column(name="previousprice")
	private double previousprice;
	
	@Column(name="pictureurl")
	private String pictureurl;
	
	
	
	public Product() {
	}



	public Product(String name, double price, double previousprice, String pictureurl) {
		this.name = name;
		this.currentprice = price;
		this.previousprice = previousprice;
		this.pictureurl = pictureurl;
	}
	
	



	public double getCurrentprice() {
		return currentprice;
	}



	public void setCurrentprice(double currentprice) {
		this.currentprice = currentprice;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}





	public double getPreviousprice() {
		return previousprice;
	}



	public void setPreviousprice(double previousprice) {
		this.previousprice = previousprice;
	}



	public String getPictureurl() {
		return pictureurl;
	}



	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}



	public int getId() {
		return id;
	}
	
	
	
	




	
	
	
	
	
	
}
