package com.lamichhane.restaurant.model;

import java.util.List;

import com.lamichhane.restaurant.entity.CartProduct;
import com.lamichhane.restaurant.entity.Customer;

public class  OrderDemo {
	
	private List<CartProduct> ingredients;
	private int totalprice;
	private Customer customer;
	
	
	public OrderDemo() {
	}


	public OrderDemo(List<CartProduct> ingredients, int totalprice, Customer customer) {
		this.ingredients = ingredients;
		this.totalprice = totalprice;
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "OrderDemo [ingredients=" + ingredients + ", totalprice=" + totalprice + ", customer=" + customer + "]";
	}


	public List<CartProduct> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<CartProduct> ingredients) {
		this.ingredients = ingredients;
	}


	public int getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
