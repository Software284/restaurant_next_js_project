package com.lamichhane.restaurant.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lamichhane.restaurant.security.entity.AuthoritiesEntity;



	
@Repository
public interface AuthoritiesEntityDAO extends JpaRepository<AuthoritiesEntity,Integer>{

}
