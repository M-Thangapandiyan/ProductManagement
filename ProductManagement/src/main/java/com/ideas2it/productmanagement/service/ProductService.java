package com.ideas2it.productmanagement.service;

import java.util.List;

import com.ideas2it.productmanagement.model.Product;
import com.ideas2it.productmanagement.util.customexception.ProductNotFoundException;

public interface ProductService {

	public String productCode();

	public Product saveProduct(Product product) throws ProductNotFoundException;

	public List<Product> getProducts() throws ProductNotFoundException;

	/**
	 * It is used to get product details by Id
	 *
	 * @param ProductId - an Product id to be checked
	 * @return - true if the Product id contain false if the Product id contain
	 */
	public Product getProductById(int id) throws ProductNotFoundException;
	
	public List<Product> getProductByIds(List<Integer> ids) throws ProductNotFoundException;

	public String deleteProduct(int id) throws ProductNotFoundException;

	public Product updateProduct(Product product, int id) throws ProductNotFoundException;

	public List<Product> searchProduct(String name) throws ProductNotFoundException;
	
	public List<Product> findProductByDate(String startDate, String endDate) throws ProductNotFoundException;
}
