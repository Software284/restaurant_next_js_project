package com.lamichhane.restaurant.service;
import java.util.List;

import com.lamichhane.restaurant.entity.Address;
import com.lamichhane.restaurant.entity.CartProduct;

public interface CartProductService {

	public List<CartProduct> getAllCartProduct();
	   
	public void saveCartProduct(CartProduct theCartProduct);

	public CartProduct getCartProduct(int id);

	public void deleteCartProduct(int id);
}
