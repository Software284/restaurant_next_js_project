package com.lamichhane.restaurant.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lamichhane.restaurant.security.entity.UserEntity;


	
@Repository
public interface UserEntityDAO extends JpaRepository<UserEntity,String>{

}
