package com.ideas2it.productmanagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

	@Autowired
	UserDetailsService userDetailsService;

	AuthenticationManager authenticationManager;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		authenticationManager = authenticationManagerBuilder.build();

		http.httpBasic().and().csrf().disable().authorizeHttpRequests()
				.requestMatchers("/getDealers", "/getDealer/{id}", "/updateDealer/{id}", "/deleteDealer/{id}",
						"/addDealer")
				.hasAnyAuthority("dealer")

				.requestMatchers("/getManufacturers", "/getManufacturer/{id}", "/addManufacturer",
						"/deleteManufacturer/{id}", "/updateManufacturer", "/deleteProduct/{id}")
				.hasAuthority("manufacturer")

				.requestMatchers("/getProducts", "/getProduct/{id}", "/addProduct", "/updateProduct/{id}",
						"/searchProduct/{value}", "/getProductBeetweenDate/{startDate}/{endDate}")

				.hasAnyAuthority("client").anyRequest().permitAll()

				.and().formLogin().defaultSuccessUrl("/", true) // login

				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and() // logout

				.authenticationManager(authenticationManager).sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
		return http.build();
	}
}
