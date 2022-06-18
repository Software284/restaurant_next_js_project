package com.lamichhane.restaurant.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamichhane.restaurant.dao.ProductDAO;
import com.lamichhane.restaurant.entity.Product;
import com.lamichhane.restaurant.exception.classes.ProductNotFoundException;



@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;

	
	@Override
	@Transactional
	public List<Product> getAllProduct() {
		
		return productDAO.findAll();
	}

	@Override
	@Transactional
	public void saveProduct(Product theProduct) {
		productDAO.save(theProduct);
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {
		Optional<Product> product = productDAO.findById(theId);
		if(product.isEmpty()) {
			throw new ProductNotFoundException("Product Not Found With Id-"+theId);
		}
		return product.get();
		
	}

	@Override
	@Transactional
	public void deleteProduct(int id) {
		productDAO.deleteById(id);
	}
	
}
