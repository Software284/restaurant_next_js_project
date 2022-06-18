package com.lamichhane.restaurant.security.entity;



import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRoleEntity {

    @Column(name = "User_Role_Id")
    @Id
    private Integer userRoleId;
    
    @Column(name = "Role")
    private String role;
    
    @ManyToOne(fetch = FetchType.EAGER,
    cascade = {CascadeType.PERSIST,CascadeType.MERGE,
    CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "Username", nullable = false)
    private UserEntity userEntity;


    
    
    public UserRoleEntity() {
    }

	public UserRoleEntity(Integer userRoleId, String role) {
		
		this.userRoleId = userRoleId;
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRoleEntity [userRoleId=" + userRoleId + ", role=" + role + "]";
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
    
    
    
    
    
    
}
