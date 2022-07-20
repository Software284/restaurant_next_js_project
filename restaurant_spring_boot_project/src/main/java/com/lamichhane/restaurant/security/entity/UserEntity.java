package com.lamichhane.restaurant.security.entity;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {
	
	@Id
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Enabled")
	private boolean enabled;
	
	@OneToMany(mappedBy="userEntity",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<UserRoleEntity> userRoleEntities;
	
	
	
	
	public UserEntity() {
		
	}
	
	
	





	public UserEntity(String username, String password, boolean enabled) {
		
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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}








	public Set<UserRoleEntity> getUserRoleEntities() {
		return userRoleEntities;
	}


	public void setUserRoleEntities(Set<UserRoleEntity> userRoleEntities) {
		this.userRoleEntities = userRoleEntities;
	}

	
}