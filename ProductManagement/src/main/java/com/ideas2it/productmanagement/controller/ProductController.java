package com.ideas2it.productmanagement.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PutMapping("/updateProduct/{id}")
	public Product updateProduct(@RequestBody Product Product, @PathVariable("id") int id) {
		return service.updateProduct(Product, id);
	}

	@GetMapping("/search/{value}")
	public List<Product> searchProducts(@PathVariable("value") String value) {
		return service.searchProduct(value);
	}

	@GetMapping("/getDate/{startDate}/{endDate}")
	public List<Product> findProductBetweenDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		return service.findProduct(startDate, endDate);
	}

	@GetMapping("/getproductByIds/{ids}")
	public List<Product> getProducts(@PathVariable("ids") String id) {
		List<Integer> ids = new ArrayList<>();
        for (String a: Arrays.asList(id.split(","))) {
        	ids.add(Integer.parseInt(a));
        }
		return service.getProductByIds(ids);
	}
}
