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

import com.lamichhane.restaurant.entity.Address;
import com.lamichhane.restaurant.security.entity.UserEntity;
import com.lamichhane.restaurant.service.UserEntityService;
public class UserEntityController {
	
	@Autowired
	private UserEntityService userEntityService;
	
	/* UserEntity API request processing */
	
	@GetMapping("/user")
	public List<UserEntity> getAllUserEntity() {
		return userEntityService.getAllUserEntity();
	}
	
	@GetMapping("/user/{userId}")
	public UserEntity getUserEntity(@PathVariable String username) {
		UserEntity user_entity = userEntityService.getUserEntity(username);
		return user_entity;
	}
	
	
	@PostMapping("/user")
	public ResponseEntity<UserEntity> saveUserEntity(@RequestBody UserEntity userEntity) {
		userEntityService.saveUserEntity(userEntity);
		return new ResponseEntity<>(userEntity,HttpStatus.CREATED);
	}
	
	@PutMapping("/user")
	public UserEntity updateUserEntity(@RequestBody UserEntity userEntity) {
		userEntityService.saveUserEntity(userEntity);
		return userEntity;
	}
	
	@DeleteMapping("/user/{userId}")
	public String deleteUserEntity(@PathVariable String userEntityId) {
		UserEntity user_entity = userEntityService.getUserEntity(userEntityId);
		userEntityService.deleteUserEntity(userEntityId);
		
		return "Deleted UserEntity  name is : "+userEntityId;
	}

}
