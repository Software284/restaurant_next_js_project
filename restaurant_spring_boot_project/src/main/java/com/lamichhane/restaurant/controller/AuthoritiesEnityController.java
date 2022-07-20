package com.lamichhane.restaurant.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lamichhane.restaurant.entity.Address;
import com.lamichhane.restaurant.security.entity.AuthoritiesEntity;
import com.lamichhane.restaurant.service.AuthoritiesEntityService;


@RestController
@RequestMapping("/restaurant")
public class AuthoritiesEnityController {
	
	@Autowired
	private AuthoritiesEntityService authoritiesEntityService;
	
	/* Product API request processing */
	
	@GetMapping("/authorities")
	public List<AuthoritiesEntity> getAllAuthoritiesEntity() {
		return authoritiesEntityService.getAllAuthoritiesEntity();
	}
	
	@GetMapping("/authorities/{authoritiesId}")
	public AuthoritiesEntity getAuthoritiesEntity(@PathVariable int authoritiesId) {
		AuthoritiesEntity authorities = authoritiesEntityService.getAuthoritiesEntity(authoritiesId);
		return authorities;
	}
	
	
	@PostMapping("/authorities")
	public ResponseEntity<AuthoritiesEntity> saveAuthoritiesEntity(@RequestBody AuthoritiesEntity authoritiesEntity) {
		authoritiesEntityService.saveAuthoritiesEntity(authoritiesEntity);
		return new ResponseEntity<>(authoritiesEntity,HttpStatus.CREATED);
	}
	
	@PutMapping("/authorities")
	public AuthoritiesEntity updateAuthoritiesEntity(@RequestBody AuthoritiesEntity authoritiesEntity) {
		authoritiesEntityService.saveAuthoritiesEntity(authoritiesEntity);
		return authoritiesEntity;
	}
	
	@DeleteMapping("/authorities/{authoritiesId}")
	public String deleteAuthoritiesEntity(@PathVariable int authoritiesId) {
		AuthoritiesEntity auth_entity = authoritiesEntityService.getAuthoritiesEntity(authoritiesId);
		authoritiesEntityService.deleteAuthoritiesEntity(authoritiesId);
		
		return "Deleted Authorities  id is : "+authoritiesId;
	}

}
