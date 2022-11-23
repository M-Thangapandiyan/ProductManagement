package com.ideas2it.productmanagement.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.productmanagement.dao.ProductDao;
import com.ideas2it.productmanagement.model.Product;
import com.ideas2it.productmanagement.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao repositery;

	public String productCode() {
		int value = 0;
		long id = repositery.countById(value);
		return "PRO00-" + ++id;
	}

	public Product saveProduct(Product product) {

		product.setCode(productCode());
		return repositery.save(product);
	}

	public List<Product> getProducts() {
		return repositery.findAll();
	}

	public Product getProductById(int id) {

		return repositery.findById(id).orElse(null);
	}

	public String deleteProduct(int id) {
		Product product = repositery.findById(id).orElse(null);

		repositery.delete(product);
		return "removed" + id;
	}

	public Product updateProduct(Product product, int id) {
		Product product1 = repositery.findById(id).orElse(null);
		if (null != product1) {
			product1.setName(product1.getName());
			product1.setPrice(product1.getPrice());
			product1.setColour(product1.getColour());
			product1.setDateOfManufacture(product1.getDateOfManufacture());
		}
		return repositery.save(product1);
	}
}
