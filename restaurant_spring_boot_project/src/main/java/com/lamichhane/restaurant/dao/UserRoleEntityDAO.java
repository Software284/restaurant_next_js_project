package com.lamichhane.restaurant.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lamichhane.restaurant.security.entity.UserRoleEntity;


	
@Repository
public interface UserRoleEntityDAO extends JpaRepository<UserRoleEntity,Integer>{

}
