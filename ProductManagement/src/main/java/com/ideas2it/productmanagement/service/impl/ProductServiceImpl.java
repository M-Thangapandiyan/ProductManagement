package com.ideas2it.productmanagement.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.productmanagement.dao.ProductDao;
import com.ideas2it.productmanagement.model.Dealer;
import com.ideas2it.productmanagement.model.Manufacturer;
import com.ideas2it.productmanagement.model.Product;
import com.ideas2it.productmanagement.service.DealerService;
import com.ideas2it.productmanagement.service.ManufacturerService;
import com.ideas2it.productmanagement.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao repositery;

	@Autowired
	ManufacturerService manufacturerService;
	@Autowired
	DealerService dealerService;

	public String productCode() {
		int value = 0;
		long id = repositery.countById(value);
		return "PRO00-" + ++id;
	}

	public Product saveProduct(Product product) {

		/*
		 * Manufacturer manufacturer = product.getManufacturer(); Dealer dealer =
		 * product.getDealer();
		 * product.setManufacturer(manufacturerService.getManufacturerById(manufacturer.
		 * getId())); product.setDealer(dealerService.getDealerById(dealer.getId()));
		 */
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
		Product product = getProductById(id);
		repositery.delete(product);
		return "removed " + id;
	}

	public Product updateProduct(Product product, int id) {
		Product product1 = repositery.findById(id).orElse(null);
		/*
		 * Product product1 = getProductById(id); Manufacturer manufacturer =
		 * product1.getManufacturer(); Dealer dealer = product1.getDealer(); if (null !=
		 * dealer) { product.getDealer().setCreatedAt(dealer.getCreatedAt()); } if (null
		 * != manufacturer) {
		 * product.getManufacturer().setCreatedAt(manufacturer.getCreatedAt()); }
		 */
		if (null != product1) {
			product1.setName(product.getName());
			product1.setPrice(product.getPrice());
			product1.setColour(product.getColour());
			product1.setDateOfManufacture(product.getDateOfManufacture());
			product1.setManufacturer(product.getManufacturer());
			product1.setDealer(product.getDealer());
		}
		return repositery.save(product1);
	}

	public List<Product> searchProduct(String keyword) {
		List<Product> products = repositery.searchProduct(keyword);
		return products;
	}
}
