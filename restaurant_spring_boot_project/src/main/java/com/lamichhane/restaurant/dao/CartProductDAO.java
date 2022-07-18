package com.lamichhane.restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lamichhane.restaurant.entity.CartProduct;

@Repository
public interface CartProductDAO extends JpaRepository<CartProduct,Integer> {

}
