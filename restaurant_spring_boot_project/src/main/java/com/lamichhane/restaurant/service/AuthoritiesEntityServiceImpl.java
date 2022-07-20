package com.lamichhane.restaurant.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamichhane.restaurant.dao.AuthoritiesEntityDAO;
import com.lamichhane.restaurant.exception.classes.AuthoritiesEntityNotFoundException;
import com.lamichhane.restaurant.security.entity.AuthoritiesEntity;



@Service
public class AuthoritiesEntityServiceImpl implements AuthoritiesEntityService{
	
	@Autowired
	private AuthoritiesEntityDAO authoritiesEntityDAO;

	
	@Override
	@Transactional
	public List<AuthoritiesEntity> getAllAuthoritiesEntity() {
		
		return authoritiesEntityDAO.findAll();
	}

	@Override
	@Transactional
	public void saveAuthoritiesEntity(AuthoritiesEntity theAuthoritiesEntity) {
		authoritiesEntityDAO.save(theAuthoritiesEntity);
	}

	@Override
	@Transactional
	public AuthoritiesEntity getAuthoritiesEntity(int theId) {
		Optional<AuthoritiesEntity> auth_entity = authoritiesEntityDAO.findById(theId);
		if(auth_entity.isEmpty()) {
			throw new AuthoritiesEntityNotFoundException("Authorities Entity  Not Found With Id-"+theId);
		}
		return auth_entity.get();
		
	}

	@Override
	@Transactional
	public void deleteAuthoritiesEntity(int id) {
		authoritiesEntityDAO.deleteById(id);
	}
	
}
