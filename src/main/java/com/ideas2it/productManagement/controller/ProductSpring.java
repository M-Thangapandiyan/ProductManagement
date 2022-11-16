package com.ideas2it.productManagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas2it.productManagement.model.Product;
import com.ideas2it.productManagement.service.DealerService;
import com.ideas2it.productManagement.service.ManufacturerService;
import com.ideas2it.productManagement.service.impl.DealerServiceImpl;
import com.ideas2it.productManagement.service.impl.ManufacturerServiceImpl;
import com.ideas2it.productManagement.service.impl.ProductServiceImpl;
import com.ideas2it.productManagement.util.DateUtil;
import com.ideas2it.productManagement.util.exception.ProductManagementException;

@Controller
public class ProductSpring {
	ManufacturerService manufacturerService = new ManufacturerServiceImpl();
	DealerService dealerService = new DealerServiceImpl();
	
	@RequestMapping("/createProduct")
	public String create(Model model) {
		try {
			model.addAttribute("dealers", dealerService.getDealers());
			model.addAttribute("manufacturers", manufacturerService.getManufacturers());
		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		model.addAttribute("references", new Product());
		return "createProduct";
	}

	@RequestMapping( value = "/InsertProduct", method = RequestMethod.POST)
	public String createDealer(@ModelAttribute("references") Product product, @RequestParam int manufacturerId, 
			@RequestParam(value = "date", required = false) String date, @RequestParam int dealerId,  Model model) {
		try {
			if (null != date)
			product.setDateOfManufacture(DateUtil.getDate(date));
			product.setDealer(dealerService.getDealerById(dealerId));
			product.setManufacturer(manufacturerService.getManufacturerById(manufacturerId));
			model.addAttribute("product", new ProductServiceImpl().createProduct(product));
		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		return "createProduct";
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)
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
	public String displayProductById(@RequestParam(value = "id", required = false) Integer id, Model model,
			HttpServletRequest request) {
		String action = request.getServletPath();
		try {
			if (null != id) {
				model.addAttribute("references", new ProductServiceImpl().getProductById(id));
			}

		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		if (action.equals("/getProduct")) {
			return "createProduct";

		} else {
			return "displayProduct";
		}
	}
	
	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam(value = "id", required = false) Integer id, Model model) {
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
	
}
