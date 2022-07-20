package com.lamichhane.restaurant.service;
import java.util.List;

import com.lamichhane.restaurant.security.entity.UserEntity;

public interface UserEntityService {

	public List<UserEntity> getAllUserEntity();
	   
	public void saveUserEntity(UserEntity theUserEntity);

	public UserEntity getUserEntity(String name);

	public void deleteUserEntity(String name);
}
