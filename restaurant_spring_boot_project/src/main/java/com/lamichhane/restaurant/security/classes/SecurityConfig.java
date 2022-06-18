package com.lamichhane.restaurant.security.classes;



import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private UserDetailsServiceImpl userDetailsService;

	public SecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsServiceImpl userDetailsService) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors()
			.and()
			.csrf().disable().authorizeRequests()
			.antMatchers("/restaurant/**").permitAll()
//			.antMatchers("/v1/books/{bookId}").hasAuthority("USER")
//			.antMatchers("/v1/books/{bookId}").hasAnyAuthority("USER","ADMIN")
//			.antMatchers("/v1/books").hasAuthority("ADMIN")
//			.antMatchers("/v1/books/{bookId}").access("hasRole('USER') and hasAuthority('GET_BOOK')")
//			.antMatchers("/v1/books").access("hasRole('ADMIN') and hasAuthority('ADD_BOOK')")
//			.antMatchers("/v1/books/myinfo").access("hasRole('USER') and hasAuthority('GET_INFO')")
			.anyRequest().authenticated()
			.and()
//			.httpBasic()
//			.authenticationEntryPoint(authenticationEntryPoint);
			.addFilter(new JwtAuthenticationFilter(authenticationManager()))
			.addFilter(new JwtAuthorizationFilter(authenticationManager(),userDetailsService))
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

}
