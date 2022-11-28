package com.ideas2it.productmanagement.securityconfiquration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiquration  {

	protected void confiqure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable();
	}
	
	@Bean
	public BCryptPasswordEncoder encodepassword() {
		return new BCryptPasswordEncoder();	
	}
}
