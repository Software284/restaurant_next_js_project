package com.lamichhane.restaurant.security.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lamichhane.restaurant.security.entity.UserEntity;
import com.lamichhane.restaurant.security.entity.UserRoleEntity;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRoleEntity, Integer> {

    UserEntity findByUserEntity(UserEntity userEntity);
}
