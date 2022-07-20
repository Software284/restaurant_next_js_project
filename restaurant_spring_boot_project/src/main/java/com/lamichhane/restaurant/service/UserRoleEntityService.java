package com.lamichhane.restaurant.service;
import java.util.List;

import com.lamichhane.restaurant.entity.Address;
import com.lamichhane.restaurant.security.entity.UserRoleEntity;

public interface UserRoleEntityService {

	public List<UserRoleEntity> getAllUserRoleEntity();
	   
	public void saveUserRoleEntity(UserRoleEntity theUserRoleEntity);

	public UserRoleEntity getUserRoleEntity(int id);

	public void deleteUserRoleEntity(int id);
}
