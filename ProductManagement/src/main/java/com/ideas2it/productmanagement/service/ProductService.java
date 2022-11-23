package com.ideas2it.productmanagement.service;

import java.util.List;

import com.ideas2it.productmanagement.model.Product;

public interface ProductService {

	public String productCode();

	public Product saveProduct(Product product);

	public List<Product> getProducts();

	/**
	 * It is used to get product details by Id
	 *
	 * @param ProductId - an Product id to be checked
	 * @return - true if the Product id contain false if the Product id contain
	 */
	public Product getProductById(int id);

	public String deleteProduct(int id);

	public Product updateProduct(Product product, int id);

}
