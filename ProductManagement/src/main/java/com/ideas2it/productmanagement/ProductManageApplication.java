package com.ideas2it.productmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

 @SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) 
public class ProductManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductManageApplication.class, args);
	}

}
