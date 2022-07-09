package com.lamichhane.restaurant.dao;

import com.lamichhane.restaurant.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductDAO extends JpaRepository<CartProduct,Integer> {

}
