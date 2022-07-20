package com.lamichhane.restaurant.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamichhane.restaurant.dao.RoleEntityDAO;
import com.lamichhane.restaurant.exception.classes.RoleEntityNotFoundException;
import com.lamichhane.restaurant.security.entity.RoleEntity;



@Service
public class RoleEntityServiceImpl implements RoleEntityService{
	
	@Autowired
	private RoleEntityDAO roleEntityDAO;

	
	@Override
	@Transactional
	public List<RoleEntity> getAllRoleEntity() {
		
		return roleEntityDAO.findAll();
	}

	@Override
	@Transactional
	public void saveRoleEntity(RoleEntity theRoleEntity) {
		roleEntityDAO.save(theRoleEntity);
	}

	@Override
	@Transactional
	public RoleEntity getRoleEntity(int theroleEntity) {
		Optional<RoleEntity> role_entity = roleEntityDAO.findById(theroleEntity);
		if(role_entity.isEmpty()) {
			throw new RoleEntityNotFoundException("Role Entity Not Found With Id-"+theroleEntity);
		}
		return role_entity.get();
		
	}

	@Override
	@Transactional
	public void deleteRoleEntity(int id) {
		roleEntityDAO.deleteById(id);
	}
	
}
