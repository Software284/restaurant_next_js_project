package com.lamichhane.restaurant.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lamichhane.restaurant.entity.FavouritesProduct;


	
@Repository
public interface FavouritesProductDAO extends JpaRepository<FavouritesProduct,Integer>{
	List<FavouritesProduct> findByUsername(String name);
}
