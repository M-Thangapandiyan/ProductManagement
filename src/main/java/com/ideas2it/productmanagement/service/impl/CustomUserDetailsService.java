package com.ideas2it.productmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ideas2it.productmanagement.dao.UserDao;
import com.ideas2it.productmanagement.model.User;
import com.ideas2it.productmanagement.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService, UserService {

	@Autowired
	UserDao repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("user not found" + username);
		}
		return user;
	}

	public User save(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setUsername(encoder.encode(user.getUsername()));
		return repository.save(user);
	}

}
