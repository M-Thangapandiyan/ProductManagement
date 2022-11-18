package com.ideas2it.productManagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.ideas2it.productManagement.model.Dealer;
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
	ProductServiceImpl productServiceImpl = new ProductServiceImpl();

	/*
	 * @RequestMapping("/createProduct") public String create(Model model) {
	 * model.addAttribute("references", new Product()); return "createProduct"; }
	 */

	/*
	 * @RequestMapping(value = "/InsertProduct", method = RequestMethod.POST) public
	 * String createProduct(@ModelAttribute("references") Product product, Model
	 * model) { try { model.addAttribute("reference",
	 * productServiceImpl.createProduct(product));
	 * 
	 * } catch (ProductManagementException e) { e.printStackTrace(); } return
	 * "createProduct"; }
	 */

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

	@RequestMapping(value = "/InsertProduct", method = RequestMethod.POST)
	public String createDealer(@ModelAttribute("references") Product product,
			@RequestParam(value = "manufacturerId", required = false) Integer manufacturerId,

			@RequestParam(value = "date", required = false) String date,

			@RequestParam(value = "dealerId", required = false) Integer dealerId, Model model) {
		try {

			System.out.println(product);
			if (null != date)
				product.setDateOfManufacture(DateUtil.getDate(date));
			if (null != manufacturerId && null != dealerId) {
				product.setDealer(dealerService.getDealerById(dealerId));
				product.setManufacturer(manufacturerService.getManufacturerById(manufacturerId));
			}
			if (0 != product.getId()) {
				if (productServiceImpl.updateProductById(product)) {
					model.addAttribute("reference", "updated successfully");
				}
			} else

			{
				model.addAttribute("reference", productServiceImpl.createProduct(product));
			}
			return "createProduct";
		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/getProducts")
	public String displayProducts(Model model) {
		try {
			model.addAttribute("products", productServiceImpl.getProducts());
		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		return "getProducts";
	}

	@RequestMapping(value = { "/displayProduct", "/updateProduct" })
	public String displayProductById(@RequestParam(value = "id", required = false) Integer id, Model model,
			HttpServletRequest request) {
		String action = request.getServletPath();
		try {
			if (null != id) {
				model.addAttribute("references", productServiceImpl.getProductById(id));
			}
			if (action.equals("/updateProduct")) {
				model.addAttribute("dealers", dealerService.getDealers());
				model.addAttribute("manufacturers", manufacturerService.getManufacturers());
				return "createProduct";

			} else {
				return "displayProduct";
			}
		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		return "";
	}

	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam(value = "id", required = false) Integer id, Model model) {
		try {
			if (null != id) {
				if (productServiceImpl.removeProductById(id))
					model.addAttribute("found", "deleted successfully");
			}
		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		return "deleteProduct";
	}

	@RequestMapping("/searchProduct")
	public String searchProduct(@RequestParam(value = "letter", required = false) String letter, Model model) {
		try {
			model.addAttribute("search", productServiceImpl.searchProduct(letter));
		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		return "searchProduct";
	}

	@RequestMapping("/getProductBetweenDate")
	public String getProductRangeValues(@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate, Model model) {
		try {
			model.addAttribute("reference",
					productServiceImpl.getProductBetweenDate(DateUtil.getDate(startDate), DateUtil.getDate(endDate)));
		} catch (ProductManagementException e) {

			e.printStackTrace();
		}

		return "getProductBetweenDate";
	}

	@RequestMapping("/displayMultipleProduct")
	public String displayMultiple(WebRequest webRequest, Model model) {
		String[] ids = webRequest.getParameterValues("ids");
		try {
			model.addAttribute("reference", productServiceImpl.getProductByIds(ids));

		} catch (ProductManagementException e) {

			e.printStackTrace();
		}

		return "displayMultipleProduct";
	}

}
