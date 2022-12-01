package com.ideas2it.productmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.productmanagement.model.User;

public interface UserDao extends JpaRepository<User, String> {

	User findByUsername(String username);
}