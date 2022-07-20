package com.lamichhane.restaurant.service;
import java.util.List;

import com.lamichhane.restaurant.entity.Address;
import com.lamichhane.restaurant.security.entity.AuthoritiesEntity;

public interface AuthoritiesEntityService {

	public List<AuthoritiesEntity> getAllAuthoritiesEntity();
	   
	public void saveAuthoritiesEntity(AuthoritiesEntity theAuthoritiesEntity);

	public AuthoritiesEntity getAuthoritiesEntity(int id);

	public void deleteAuthoritiesEntity(int id);
}
