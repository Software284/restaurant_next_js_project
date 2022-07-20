package com.lamichhane.restaurant.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lamichhane.restaurant.security.entity.RoleEntity;



	
@Repository
public interface RoleEntityDAO extends JpaRepository<RoleEntity,Integer>{

}
