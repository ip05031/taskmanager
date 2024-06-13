package com.task.dev.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	@Bean
	SecurityFilterChain filterChain( HttpSecurity http , SecurityManager authManager) throws Exception{
		return http
				.csrf().disable()
				.authorizeHttpRequests()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.build();
				
		
	}
	
	
	
}
