package com.lamichhane.restaurant.security.entity;




import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRoleEntity {

    @Column(name = "User_Role_Id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_entity_id_seq")
	@SequenceGenerator(name = "user_entity_id_seq", 
	                   sequenceName = "user_role_seq",
	                  allocationSize = 1) 
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

	public Integer getUserRoleId() {
		return userRoleId;
	}
	
	
	
	
	
    
    
    
    
    
    
}
