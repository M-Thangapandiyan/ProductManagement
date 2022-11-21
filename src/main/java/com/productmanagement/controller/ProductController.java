package com.productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productmanagement.entity.Product;
import com.productmanagement.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		System.out.println(product);
		return productService.saveProduct(product);
	}
}
