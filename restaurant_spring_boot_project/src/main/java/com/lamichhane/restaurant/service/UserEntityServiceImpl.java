package com.lamichhane.restaurant.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamichhane.restaurant.dao.UserEntityDAO;
import com.lamichhane.restaurant.exception.classes.UserEntityNotFoundException;
import com.lamichhane.restaurant.security.entity.UserEntity;



@Service
public class UserEntityServiceImpl implements UserEntityService{
	
	@Autowired
	private UserEntityDAO userEntityDAO;

	
	@Override
	@Transactional
	public List<UserEntity> getAllUserEntity() {
		
		return userEntityDAO.findAll();
	}

	@Override
	@Transactional
	public void saveUserEntity(UserEntity theUserEntity) {
		userEntityDAO.save(theUserEntity);
	}

	@Override
	@Transactional
	public UserEntity getUserEntity(String name) {
		Optional<UserEntity> userentity = userEntityDAO.findById(name);
		if(userentity.isEmpty()) {
			throw new UserEntityNotFoundException("User Entity Not Found With name-"+name);
		}
		return userentity.get();
		
	}

	@Override
	@Transactional
	public void deleteUserEntity(String name) {
		userEntityDAO.deleteById(name);
	}
	
}
