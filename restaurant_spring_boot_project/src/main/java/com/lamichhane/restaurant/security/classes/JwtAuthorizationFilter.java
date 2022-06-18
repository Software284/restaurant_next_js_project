package com.lamichhane.restaurant.security.classes;



import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    /*@Value("${bookws.security.jwt.token.secret}")
    String secret;*/

    private UserDetailsServiceImpl userDetailsService;

    private static String jwtSecret = System.getenv("jwtSecret");

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService) {
        super(authenticationManager);
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
        throws IOException, ServletException {

        // Getting the header from the request
        String authHeader = request.getHeader("Authorization");

        // Validate the Authorization header
        if(authHeader == null || authHeader.trim().length() == 0 ||
                !authHeader.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        // Auth Header is present and is in valid format
        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(authHeader);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String authHeader) {

        if(authHeader != null) {
            String userNameFromJwt = JWT.require(Algorithm.HMAC512("secret".getBytes()))
                                        .build()
                                        .verify(authHeader.replace("Bearer ", ""))
                                        .getSubject();

            if(userNameFromJwt != null) {
                // UserDetails userDetails = userDetailsService.loadUserByUsername(userNameFromJwt);
                return new UsernamePasswordAuthenticationToken(userNameFromJwt, null,
                        userDetailsService.loadUserByUsername(userNameFromJwt).getAuthorities());
            }
        }

        return null;
    }


}
