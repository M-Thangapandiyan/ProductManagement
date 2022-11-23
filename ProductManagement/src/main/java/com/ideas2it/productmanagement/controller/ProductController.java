package com.ideas2it.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.productmanagement.model.Product;
import com.ideas2it.productmanagement.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product Product) {
		return service.saveProduct(Product);

	}

	@GetMapping("/getProducts")
	public List<Product> findAllProduct() {
		return service.getProducts();
	}

	@GetMapping("/getProduct/{id}")
	public Product findProduct(@PathVariable("id") int id) {
		return service.getProductById(id);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}

	@PostMapping("/updateProduct/{id}")
	public Product updateProduct(@RequestBody Product Product, @PathVariable("id") int id) {
		return service.updateProduct(Product, id);
	}
}
