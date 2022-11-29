package com.ideas2it.productmanagement.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ideas2it.productmanagement.dto.ProductDto;
import com.ideas2it.productmanagement.model.Product;

@Component
public class ProductConvertor {

	public ProductDto entityToDto(Product product) {
		ModelMapper mapper = new ModelMapper();
		ProductDto p = mapper.map(product, ProductDto.class);

		return p;
	}

	public List<ProductDto> entityDto1(List<Product> product) {
		List<ProductDto> s = new ArrayList<ProductDto>();
		for (Product d : product) {
			s.add(entityToDto(d));
		}
		return s;
	}

	public Product dtoToEntity(ProductDto productDto) {
		ModelMapper mapper = new ModelMapper();
		Product product = mapper.map(productDto, Product.class);
		return product;

	}
}
