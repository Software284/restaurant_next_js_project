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

import com.lamichhane.restaurant.entity.CartProduct;
import com.lamichhane.restaurant.entity.Product;
import com.lamichhane.restaurant.service.CartProductService;


@RestController
@RequestMapping("/restaurant")
public class CartProductController {
	
	@Autowired
	private CartProductService cartProductService;
	
	/* Product API request processing */
	
	@GetMapping("/cartproduct")
	public List<CartProduct> getAllCartProduct() {
		return cartProductService.getAllCartProduct();
	}
	
	@GetMapping("/cartproduct/{cartproudctId}")
	public CartProduct getCartProduct(@PathVariable int cartproductId) {
		CartProduct cart_product = cartProductService.getCartProduct(cartproductId);
		return cart_product;
	}
	
	
	@PostMapping("/cartproduct")
	public ResponseEntity<CartProduct> saveCartProduct(@RequestBody CartProduct cartproduct) {
		cartProductService.saveCartProduct(cartproduct);
		return new ResponseEntity<>(cartproduct,HttpStatus.CREATED);
	}
	
	@PutMapping("/cartproduct")
	public CartProduct updateProduct(@RequestBody CartProduct cartproduct) {
		cartProductService.saveCartProduct(cartproduct);
		return cartproduct;
	}
	
	@DeleteMapping("/cartproduct/{cartproductId}")
	public String deleteCartProduct(@PathVariable int cartproductId) {
		CartProduct cart_product = cartProductService.getCartProduct(cartproductId);
		cartProductService.deleteCartProduct(cartproductId);
		
		return "Deleted Cart Product  Id is : "+cartproductId;
	}

}
