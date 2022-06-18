package com.lamichhane.restaurant.security.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lamichhane.restaurant.security.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,String> {
	
	UserEntity findByUsername(String username);
	
	
}
