package com.ideas2it.productmanagement.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ideas2it.productmanagement.converter.ProductConvertor;
import com.ideas2it.productmanagement.dto.ProductDto;
import com.ideas2it.productmanagement.model.Product;
import com.ideas2it.productmanagement.service.ProductService;
import com.ideas2it.productmanagement.util.customexception.ProductNotFoundException;

@RestController
public class ProductController {

	@Autowired
	ProductService service;

	@Autowired
	ProductConvertor convertor;
	
	@GetMapping("/")
	public String demo() {
		return "hi yaar";
	}

	@PostMapping("/addProduct")
	public ProductDto addProduct(@RequestBody ProductDto productDto) throws ProductNotFoundException {
		Product product = service.saveProduct(convertor.dtoToEntity(productDto));
		return convertor.entityToDto(product);
	}

	@GetMapping("/getProducts")
	public List<ProductDto> findAllProduct() throws ProductNotFoundException {
		List<Product> product = service.getProducts();
		return convertor.entityDto1(product);
	}

	@GetMapping("/getProduct/{id}")
	public ProductDto findProduct(@PathVariable("id") int id) throws ProductNotFoundException {
		Product product = service.getProductById(id);
		return convertor.entityToDto(product);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) throws ProductNotFoundException {
		return service.deleteProduct(id);
	}

	@PutMapping("/updateProduct/{id}")
	public ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable("id") int id)
			throws ProductNotFoundException {
		Product product = service.updateProduct(convertor.dtoToEntity(productDto), id);
		return convertor.entityToDto(product);
	}

	@GetMapping("/searchProduct/{value}")
	public List<ProductDto> searchProducts(@PathVariable("value") String value) throws ProductNotFoundException {
		List<Product> products = service.searchProduct(value);
		return convertor.entityDto1(products);
	}

	@GetMapping("/getDateBeetweenProduct/{startDate}/{endDate}")
	public List<ProductDto> findProductBetweenDate(@PathVariable("startDate") String startDate,
			@PathVariable("endDate") String endDate) {
		List<Product> products = null;
		try {
			products = service.findProductByDate(startDate, endDate);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return convertor.entityDto1(products);
	}

	@GetMapping("/getproductByIds/{ids}")
	public List<ProductDto> getProducts(@PathVariable("ids") String id) throws ProductNotFoundException {
		List<Integer> ids = new ArrayList<>();
		for (String array : Arrays.asList(id.split(","))) {
			ids.add(Integer.parseInt(array));
		}
		List<Product> products = service.getProductByIds(ids);
		return convertor.entityDto1(products);
	}
}
