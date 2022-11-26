package com.ideas2it.productmanagement.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ideas2it.productmanagement.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	@Query("select count(id) from Product")
	long countById(int id);

	@Query("select p from Product p where p.name like %:keyword% or p.colour like %:keyword%")
	List<Product> searchProduct(@Param("keyword") String value);

	List<Product> findByDateOfManufactureBetween(Date startDate, Date endDate);

	List<Product> findByIdIn(List<Integer> ids);
}
