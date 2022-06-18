package com.lamichhane.restaurant.security.classes;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lamichhane.restaurant.security.entity.User;
import com.lamichhane.restaurant.security.entity.UserService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user = userService.getUserByUsername(username);
		if(user != null) {
			return user;
		}
		else {
			throw new UsernameNotFoundException(username+" does not exist");
	
		}
		
	}

}
