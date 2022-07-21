package com.lamichhane.restaurant.security.entity;



import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.lamichhane.restaurant.security.dao.AuthoritiesRepository;
import com.lamichhane.restaurant.security.dao.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private AuthoritiesRepository authoritiesRepository;

   
	

//	private User user = null;
	public UserService() {
//		user = new User("mahesh","$2a$12$gpf7xoaToIIxcwtq89RkzO.E.GGZNgjlWXvMMZcTXZIzYAAO1oZL2",true);
	}
	
	public User getUserByUsername(String username) {
//		System.out.println("Hello Iam Here");
		UserEntity userEntity = userRepository.findByUsername(username);
//		System.out.println("Hello Iam There");
		
		
		if(userEntity != null) {
			return createUserFromUserEntity(userEntity);
		}
		else {
			return null;
		}
	}

	private User createUserFromUserEntity(UserEntity ue) {
		boolean x;
		if(ue.getEnabled().equals('Y')) {
			x = false;
		}
		else {
			x= true;
		}
		User user = new User(ue.getUsername(), ue.getPassword(),x);

        // Fetch authorities from authorities table
        Stream<Stream<String>> streamStreamAuths = ue.getUserRoleEntities().stream()
                .map(ur -> {
                    Set<AuthoritiesEntity> authoritiesEntities = authoritiesRepository.findByRole(ur.getRole());
                    return authoritiesEntities.stream().map(ae -> ae.getAuthority());
                });

        // Flatten the stream of stream to get the set of authorities
        Set<String> authorities = streamStreamAuths.flatMap(authStream -> authStream)
                .collect(Collectors.toSet());

        // Now add the Role (from the User_Role table) as authorities because UserDetails does not
        // support adding Role separately as it does not have any setRole(String... roles)
        ue.getUserRoleEntities().stream().forEach(ur-> authorities.add(ur.getRole()));

        // Set all authorities for the User
        user.setAuthorities(authorities.stream()
                    .map(a -> new SimpleGrantedAuthority(a))
                    .collect(Collectors.toSet()));
        
//      System.out.println(user);
//      System.out.println(ue.getUserRoleEntities());
//      System.out.println(authorities);

        return user;
	}
}
