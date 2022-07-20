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
import com.lamichhane.restaurant.security.entity.UserRoleEntity;
import com.lamichhane.restaurant.service.UserRoleEntityService;


@RestController
@RequestMapping("/restaurant")
public class UserRoleController {
	
	@Autowired
	private UserRoleEntityService userRoleEntityService;
	
	/* UserRole API request processing */
	
	@GetMapping("/user_role")
	public List<UserRoleEntity> getAllUserRoleEntity() {
		return userRoleEntityService.getAllUserRoleEntity();
	}
	
	@GetMapping("/user_role/{userroleId}")
	public UserRoleEntity getUserRole(@PathVariable int userRoleId) {
		UserRoleEntity user_role = userRoleEntityService.getUserRoleEntity(userRoleId);
		return user_role;
	}
	
	
	@PostMapping("/user_role")
	public ResponseEntity<UserRoleEntity> saveUserRoleEntity(@RequestBody UserRoleEntity userRoleEntity) {
		userRoleEntityService.saveUserRoleEntity(userRoleEntity);
		return new ResponseEntity<>(userRoleEntity,HttpStatus.CREATED);
	}
	
	@PutMapping("/user_role")
	public UserRoleEntity updateUserRoleEntity(@RequestBody UserRoleEntity userRoleEntity) {
		userRoleEntityService.saveUserRoleEntity(userRoleEntity);
		return userRoleEntity;
	}
	
	@DeleteMapping("/user_role/{userroleId}")
	public String deleteUserRoleEntity(@PathVariable int userRoleId) {
		UserRoleEntity user_role = userRoleEntityService.getUserRoleEntity(userRoleId);
		userRoleEntityService.deleteUserRoleEntity(userRoleId);
		
		return "Deleted User Role   id is : "+userRoleId;
	}

}
