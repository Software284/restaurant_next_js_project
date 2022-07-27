package com.lamichhane.restaurant.security.classes;



import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lamichhane.restaurant.security.entity.User;



public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	 
	 
	 private AuthenticationManager authenticationManager;
//	 private static String jwtSecret = System.getenv("jwtSecret");
	 
	 public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		 this.authenticationManager = authenticationManager;
	 }


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		User user = null;
		try {
			
			user = new ObjectMapper().readValue(request.getInputStream(),User.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
						user.getUsername(),user.getPassword(),new ArrayList<>()));
			
		}
		catch(BadCredentialsException e) {
			throw e;
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		User user = (User) authResult.getPrincipal();
		String token = JWT.create().withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + 3600000))
				.sign(HMAC512("secret".getBytes()));
		
		
		response.addHeader("Authorization","Bearer "+token);
		response.addHeader("expiresIn","3600000");
		StringTokenizer st = new StringTokenizer(user.getUsername(), "@");
	    String s2 = st.nextToken();
		response.addHeader("user", s2);
		
		
	}

	
	
	
}
