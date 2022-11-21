package com.productmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productmanagement.entity.Product;

public interface Dao extends JpaRepository<Product,Integer>{

	

}
