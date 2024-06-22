package com.kaushik.training.webservicedemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults; // careful with this import.

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//All requests must be authenticated.
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
		
		//If any request is not authenticated, display the basic logic form.
		http.httpBasic(withDefaults()); // from the static import, so we are not using the class name.
		
		//disable CSRF for POST and PUT requests.
		http.csrf().disable();
		
		
		return http.build();
	}

}
