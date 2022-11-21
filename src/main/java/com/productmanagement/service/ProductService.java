package com.productmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productmanagement.dao.Dao;
import com.productmanagement.entity.Product;

@Service
public class ProductService {

	@Autowired
	private Dao repositery;

	public Product saveProduct(Product product) {
		return repositery.save(product);
	}
}
