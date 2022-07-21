package com.lamichhane.restaurant.security.entity;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
public class UserEntity {
	
	@Id
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Enabled")
	private String enabled;
	
	@OneToMany(mappedBy="userEntity",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JsonIgnoreProperties("userEntity")
	private Set<UserRoleEntity> userRoleEntities;
	
	
	
	
	
	
	public UserEntity() {
		
	}
	
	
	





	public UserEntity(String username, String password, String enabled) {
		
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	

	@Override
	public String toString() {
		return "UserEntity [username=" + username + ", password=" + password + ", enabled=" + enabled + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public Set<UserRoleEntity> getUserRoleEntities() {
		return userRoleEntities;
	}


	public void setUserRoleEntities(Set<UserRoleEntity> userRoleEntities) {
		this.userRoleEntities = userRoleEntities;
	}
	
	
	
	public void add(UserRoleEntity tempUserRoleEntity) {
		if(userRoleEntities == null) {
			userRoleEntities = new HashSet<>();
			
		}
		userRoleEntities.add(tempUserRoleEntity);
		tempUserRoleEntity.setUserEntity(this);
	}
	
	

	
}