package com.lamichhane.restaurant.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamichhane.restaurant.dao.CartProductDAO;
import com.lamichhane.restaurant.entity.CartProduct;
import com.lamichhane.restaurant.exception.classes.AddressNotFoundException;
import com.lamichhane.restaurant.exception.classes.CartProductNotFoundException;



@Service
public class CartProductServiceImpl implements CartProductService{
	
	@Autowired
	private CartProductDAO cartProductDAO;

	
	@Override
	@Transactional
	public List<CartProduct> getAllCartProduct() {
		
		return cartProductDAO.findAll();
	}

	@Override
	@Transactional
	public void saveCartProduct(CartProduct theCartProduct) {
		cartProductDAO.save(theCartProduct);
	}

	@Override
	@Transactional
	public CartProduct getCartProduct(int theId) {
		Optional<CartProduct> cartproduct = cartProductDAO.findById(theId);
		if(cartproduct.isEmpty()) {
			throw new AddressNotFoundException("CartProduct Not Found With Id-"+theId);
		}
		return cartproduct.get();
		
	}

	@Override
	@Transactional
	public void deleteCartProduct(int id) {
		cartProductDAO.deleteById(id);
	}

	
	
}
