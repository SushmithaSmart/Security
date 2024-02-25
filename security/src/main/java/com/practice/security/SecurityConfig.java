package com.practice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig  {
	
	//authentication
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		 UserDetails admin = User.withUsername("sushmi")
				 .password(encoder.encode("pwd"))
				 .roles("ADMIN")
				 .build();
		 UserDetails user = User.withUsername("sachi")
				 .password(encoder.encode("pwd"))
				 .roles("USER")
				 .build();
		 return new InMemoryUserDetailsManager(admin, user);
	}
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        return http.csrf().disable()
	        		.authorizeHttpRequests().requestMatchers("/saveuser").authenticated()
	        		.and()
	        		.authorizeHttpRequests().requestMatchers("/getall").authenticated()
	        		.and()
	        		.authorizeHttpRequests().requestMatchers("/say").authenticated()
	        		.and().formLogin().and().build();
	    }
}
