package com.lamichhane.restaurant.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lamichhane.restaurant.entity.Customer;;


	
@Repository
public interface CustomerDAO extends JpaRepository<Customer,Integer>{

}
