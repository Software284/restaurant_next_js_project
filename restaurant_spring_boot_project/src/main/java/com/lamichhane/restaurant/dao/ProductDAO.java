package com.lamichhane.restaurant.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lamichhane.restaurant.entity.Product;


	
@Repository
public interface ProductDAO extends JpaRepository<Product,Integer>{

}
