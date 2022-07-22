package com.lamichhane.restaurant.controller;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

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

import com.auth0.jwt.JWT;
import com.lamichhane.restaurant.security.entity.UserEntity;
import com.lamichhane.restaurant.security.entity.UserRoleEntity;
import com.lamichhane.restaurant.service.UserEntityService;
import com.lamichhane.restaurant.success.classes.StandardRestSuccessResponse;
@RestController
@RequestMapping("/restaurant")
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
	
	
	@PostMapping("/register")
	public ResponseEntity<UserEntity> saveUserEntity(@RequestBody UserEntity userEntity) {
		
		userEntity.setEnabled("Y");
		Set<UserRoleEntity> user_role_entity = new HashSet<>();
		UserRoleEntity ent = new UserRoleEntity();
		ent.setRole("ROLE_USER");
		user_role_entity.add(ent);
		
		System.out.println("Real="+user_role_entity);
		
		
		
		for(UserRoleEntity e : user_role_entity){
			userEntity.add(e);
			
		}
		
		
		StandardRestSuccessResponse res = new StandardRestSuccessResponse();
		res.setMessage("User  Created Successfully");
		res.setStatus("success");
		res.setTimeStamp(System.currentTimeMillis());
		
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
