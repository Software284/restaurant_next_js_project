package com.lamichhane.restaurant.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamichhane.restaurant.dao.UserRoleEntityDAO;
import com.lamichhane.restaurant.exception.classes.UserRoleEntityNotFoundException;
import com.lamichhane.restaurant.security.entity.UserRoleEntity;



@Service
public class UserRoleEntityServiceImpl implements UserRoleEntityService{
	
	@Autowired
	private UserRoleEntityDAO userRoleEntityDAO;

	
	@Override
	@Transactional
	public List<UserRoleEntity> getAllUserRoleEntity() {
		
		return userRoleEntityDAO.findAll();
	}

	@Override
	@Transactional
	public void saveUserRoleEntity(UserRoleEntity theUserRoleEntity) {
		userRoleEntityDAO.save(theUserRoleEntity);
	}

	@Override
	@Transactional
	public UserRoleEntity getUserRoleEntity(int theId) {
		Optional<UserRoleEntity> user_role_entity = userRoleEntityDAO.findById(theId);
		if(user_role_entity.isEmpty()) {
			throw new UserRoleEntityNotFoundException("UserRole Entity Not Found With Id-"+theId);
		}
		return user_role_entity.get();
		
	}

	@Override
	@Transactional
	public void deleteUserRoleEntity(int id) {
		userRoleEntityDAO.deleteById(id);
	}
	
}
