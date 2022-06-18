package com.lamichhane.restaurant.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lamichhane.restaurant.entity.Product;
import com.lamichhane.restaurant.service.ProductService;


@RestController
@RequestMapping("/restaurant")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	/* Product API request processing */
	
	@GetMapping("/product")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}
	
	@GetMapping("/product/{productId}")
	public Product getProduct(@PathVariable int productId) {
		Product product = productService.getProduct(productId);
		return product;
	}
	
	
	@PostMapping("/product")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		return new ResponseEntity<>(product,HttpStatus.CREATED);
	}
	
	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		return product;
	}
	
	@DeleteMapping("/product/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		Product product = productService.getProduct(productId);
		productService.deleteProduct(productId);
		
		return "Deleted Product  id is : "+productId;
	}

}
