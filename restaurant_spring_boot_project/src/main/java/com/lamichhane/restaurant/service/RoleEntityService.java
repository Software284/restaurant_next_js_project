package com.lamichhane.restaurant.service;
import java.util.List;

import com.lamichhane.restaurant.entity.Address;
import com.lamichhane.restaurant.security.entity.RoleEntity;

public interface RoleEntityService {

	public List<RoleEntity> getAllRoleEntity();
	   
	public void saveRoleEntity(RoleEntity theRoleEntity);

	public RoleEntity getRoleEntity(int id);

	public void deleteRoleEntity(int id);
}
