package com.ideas2it.productManagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas2it.productManagement.model.Product;
import com.ideas2it.productManagement.service.impl.DealerServiceImpl;
import com.ideas2it.productManagement.service.impl.ProductServiceImpl;
import com.ideas2it.productManagement.util.exception.ProductManagementException;

@Controller
public class ProductSpring {
	@RequestMapping("/createProduct")
	public String create(Model model) {
		model.addAttribute("references", new Product());
		return "createProduct";
	}

	@RequestMapping("/InsertProduct")
	public String createDealer(@ModelAttribute("references") Product product, Model model) {
		try {
			model.addAttribute("reference", new ProductServiceImpl().createProduct(product));
		} catch (ProductManagementException e) {

			e.printStackTrace();
		}
		return "createProduct";
	}
	
	@RequestMapping("/deleteProduct")
	public String deleteDealer(@RequestParam(value = "id", required = false) Integer id, Model model) {
		try {
			if (null != id) {
				if (new ProductServiceImpl().removeProductById(id))
					model.addAttribute("found", "deleted successfully");
			}
		} catch (ProductManagementException e) {

			e.printStackTrace();
		}
		return "deleteProduct";
	}

	@RequestMapping("/getProducts")
	public String displayDealer(Model model) {
		try {
			model.addAttribute("products", new ProductServiceImpl().getProducts());
		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		return "getProducts";
	}

	@RequestMapping(value = { "/displayProduct", "/getProduct" })
	public String displayDealerById(@RequestParam(value = "id", required = false) Integer id, Model model,
			HttpServletRequest request) {
		String action = request.getServletPath();
		try {
			if (null != id) {
				model.addAttribute("references", new ProductServiceImpl().getProductById(id));
			}

		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		if (action.equals("/getProductr")) {
			return "createProduct";

		} else {
			return "displayProduct";
		}
	}
}
