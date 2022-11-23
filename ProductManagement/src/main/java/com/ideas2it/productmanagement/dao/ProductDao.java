package com.ideas2it.productmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ideas2it.productmanagement.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	@Query("select count(id) from Product")
	long countById(int id);
	
}
