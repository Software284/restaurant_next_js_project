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
import com.lamichhane.restaurant.security.entity.RoleEntity;
import com.lamichhane.restaurant.service.RoleEntityService;


@RestController
@RequestMapping("/restaurant")
public class RoleEntityController {
	
	@Autowired
	private RoleEntityService roleEntityService;
	
	/* Role API request processing */
	
	@GetMapping("/role")
	public List<RoleEntity> getAllRoleEntity() {
		return roleEntityService.getAllRoleEntity();
	}
	
	@GetMapping("/role/{roleId}")
	public RoleEntity getRoleEntity(@PathVariable int roleEntityId) {
		RoleEntity role = roleEntityService.getRoleEntity(roleEntityId);
		return role;
	}
	
	
	@PostMapping("/role")
	public ResponseEntity<RoleEntity> saveRoleEntity(@RequestBody RoleEntity roleEntity) {
		roleEntityService.saveRoleEntity(roleEntity);
		return new ResponseEntity<>(roleEntity,HttpStatus.CREATED);
	}
	
	@PutMapping("/role")
	public RoleEntity updateRoleEntity(@RequestBody RoleEntity roleEntity) {
		roleEntityService.saveRoleEntity(roleEntity);
		return roleEntity;
	}
	
	@DeleteMapping("/role/{roleId}")
	public String deleteRoleEntity(@PathVariable int roleEntity) {
		RoleEntity role_entity = roleEntityService.getRoleEntity(roleEntity);
		roleEntityService.deleteRoleEntity(roleEntity);
		
		return "Deleted Role  id is : "+roleEntity;
	}

}
