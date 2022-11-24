package com.ideas2it.productmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ideas2it.productmanagement.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	@Query("select count(id) from Product")
	long countById(int id);

	@Query("SELECT p FROM Product p WHERE CONCAT(p.name, ' ', p.colour) LIKE %:keyword%")
	List<Product> searchProduct(@Param("keyword") String value);

}
