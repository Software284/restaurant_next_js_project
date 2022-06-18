package com.lamichhane.restaurant.service;





import java.util.List;

import com.lamichhane.restaurant.entity.Product;

public interface ProductService {

	public List<Product> getAllProduct();
	   
	public void saveProduct(Product theProduct);

	public Product getProduct(int id);

	public void deleteProduct(int id);
}
