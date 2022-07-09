package com.lamichhane.restaurant.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lamichhane.restaurant.entity.Address;


	
@Repository
public interface AddressDAO extends JpaRepository<Address,Integer>{

}
