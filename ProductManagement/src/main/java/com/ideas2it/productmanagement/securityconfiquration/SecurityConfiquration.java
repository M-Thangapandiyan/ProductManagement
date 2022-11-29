package com.ideas2it.productmanagement.securityconfiquration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiquration {

	@Bean
	public InMemoryUserDetailsManager UserDetailsManager(PasswordEncoder passwordEncoder) {
		UserDetails manufacturer = User.withUsername("name1").password(passwordEncoder.encode("pass")).roles("demo").build();
		UserDetails dealer = User.withUsername("name").password(passwordEncoder.encode("pass")).roles("demoOne").build();
		return new InMemoryUserDetailsManager(manufacturer,dealer);
	}

	@SuppressWarnings("deprecation")
	@Bean
	public SecurityFilterChain confiqure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
			    .requestMatchers(HttpMethod.GET, "/getDealers").hasRole("demoOne")
			    .requestMatchers(HttpMethod.GET, "/getManufacturers").hasRole("demo")
			    .and()
			    .httpBasic();
			return http.build();	
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return encoder; 
	}
}
	/*}

	@Bean
	public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails user = User.withUsername("user").password(passwordEncoder.encode("p")).roles("USER").build();

		UserDetails admin = User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user, admin);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
		return http.build();
	}
*/
	

//@SuppressWarnings("deprecation")
//public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//	http.csrf().disable().authorizeRequests().requestMatchers(HttpMethod.GET, "/getDealers").permitAll()
//			.requestMatchers("/getmanufacturers").permitAll().requestMatchers(HttpMethod.GET, "/getManufacturer/**")
//			.authenticated().and().httpBasic();
//	return http.build();
//
//}


	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Bean public SecurityFilterChain confiqure(HttpSecurity http) throws
	 * Exception { //return http.csrf(csrf ->
	 * csrf.disable()).authorizeRequests(authu -> {
	 * http.authorizeRequests().requestMatchers(HttpMethod.GET,
	 * "/getDealers").hasRole("r"); return http.build();
	 * 
	 * // authu.requestMatchers("/").permitAll();
	 * //authu.requestMatchers(HttpMethod.GET, "/getDealers").hasRole("r");
	 * //authu.requestMatchers(HttpMethod.GET, "/getManufacturers").hasRole("ro");
	 * // authu.requestMatchers(HttpMethod.POST, "/getManufacturers").hasRole("r");
	 * //}).httpBasic(Customizer.withDefaults()).build(); }
	 */
