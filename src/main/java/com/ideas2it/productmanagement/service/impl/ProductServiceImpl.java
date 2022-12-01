package com.ideas2it.productmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.productmanagement.dao.ProductDao;
import com.ideas2it.productmanagement.model.Product;
import com.ideas2it.productmanagement.service.DealerService;
import com.ideas2it.productmanagement.service.ManufacturerService;
import com.ideas2it.productmanagement.service.ProductService;
import com.ideas2it.productmanagement.util.DateUtil;
import com.ideas2it.productmanagement.util.customexception.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao repository;

	@Autowired
	ManufacturerService manufacturerService;

	@Autowired
	DealerService dealerService;

	public String productCode() {
		int value = 0;
		long id = repository.countById(value);
		return "PRO00-" + ++id;
	}

	public Product saveProduct(Product product) throws ProductNotFoundException {
		product.setCode(productCode());
		Product product1 = repository.save(product);
		if(product1 != null) {
			return product1;
		} else {
			throw new ProductNotFoundException("Product details are null, can not stored");	
		}
	}

	public List<Product> getProducts() throws ProductNotFoundException {
		List<Product> products = repository.findAll();
		if (!products.isEmpty() && products != null) {
			return products;
		} else {
			throw new ProductNotFoundException("Product details are null,can not to stored");
		}
	}

	public Product getProductById(int id) throws ProductNotFoundException {

		Product product = repository.findById(id).orElse(null);
		if (null != product) {
			return product;
		} else {
			throw new ProductNotFoundException("Produt not found with id :" + id);
		}
	}

	public String deleteProduct(int id) throws ProductNotFoundException {
		Product product = getProductById(id);
		if (null != product) {
			repository.delete(product);
			return "removed " + id;
		} else {
			throw new ProductNotFoundException("Product not found with id :" + id);
		}
	}

	public Product updateProduct(Product product, int id) throws ProductNotFoundException {
		Product product1 = repository.findById(id).orElse(null);
		if (product != null) {
			product1.setName(product.getName());
			product1.setPrice(product.getPrice());
			product1.setColour(product.getColour());
			product1.setDateOfManufacture(product.getDateOfManufacture());
			product1.setManufacturer(product.getManufacturer());
			product1.setDealer(product.getDealer());
			return repository.save(product1);
		} else {
			throw new ProductNotFoundException("Product not found with id :" + id);
		}
	}

	public List<Product> searchProduct(String keyword) throws ProductNotFoundException {
		List<Product> products = repository.searchProduct(keyword);
		if (!products.isEmpty() && products != null) {
			return products;
		} else {
			throw new ProductNotFoundException("Product not found with :" + keyword);
		}
	}

	public List<Product> findProductByDate(String startDate, String endDate) throws ProductNotFoundException {
		List<Product> products = null;
		products = repository.findByDateOfManufactureBetween(DateUtil.getDate(startDate), DateUtil.getDate(endDate));
		if (!products.isEmpty() && products != null) {
			return products;
		} else {
			throw new ProductNotFoundException("Product not found this" + startDate + "to" + endDate);
		}

	}

	public List<Product> getProductByIds(List<Integer> ids) throws ProductNotFoundException {
		List<Product> products = repository.findByIdIn(ids);
		if (!products.isEmpty() && products != null) {
			return products;
		} else {
			throw new ProductNotFoundException("Dealers not found with ids:" + ids);
		}
	}
}
