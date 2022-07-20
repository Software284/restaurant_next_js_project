package com.lamichhane.restaurant.security.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class AuthoritiesEntity {

    @Column(name = "Authority_Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorities_id_seq")
	@SequenceGenerator(name = "authorities_id_seq", 
	                   sequenceName = "authorities_seq",
	                  allocationSize = 1) 
    @Id
    private Integer authorityId;
    


    @Column(name = "Authority")
    private String authority;
    
    @Column(name="Role")
    private String role;
    

   

    public AuthoritiesEntity() {
    }



	public AuthoritiesEntity(Integer authorityId, String authority, String role) {
		
		this.authorityId = authorityId;
		this.authority = authority;
		this.role = role;
	}



	@Override
	public String toString() {
		return "AuthoritiesEntity [authorityId=" + authorityId + ", authority=" + authority + ", role=" + role + "]";
	}



	public Integer getAuthorityId() {
		return authorityId;
	}



	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}



	public String getAuthority() {
		return authority;
	}



	public void setAuthority(String authority) {
		this.authority = authority;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}
    
}
