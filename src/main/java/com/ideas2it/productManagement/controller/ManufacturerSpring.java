package com.ideas2it.productManagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas2it.productManagement.model.Manufacturer;
import com.ideas2it.productManagement.service.impl.ManufacturerServiceImpl;
import com.ideas2it.productManagement.util.exception.ProductManagementException;

@Controller
public class ManufacturerSpring {
	
	ManufacturerServiceImpl manufacturerServiceImpl = new ManufacturerServiceImpl();
	
	@RequestMapping("/createManufacturer")
	public String create(Model model) {
		model.addAttribute("references", new Manufacturer());
		return "createManufacturer";
	}

	@RequestMapping(value = "/InsertManufacturer", method = RequestMethod.POST)
	public String createManufacturer(@ModelAttribute("references") Manufacturer manufacturer, Model model) {
		try {
			if (0 != manufacturer.getId()) {
				if (manufacturerServiceImpl .updateManufacturerById(manufacturer)) {
					model.addAttribute("reference", "updated successfully");
				}
			} else {
				model.addAttribute("reference", manufacturerServiceImpl.createManufacturer(manufacturer));
			}
		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		return "createManufacturer";
	}
	
	@RequestMapping("/deleteManufacturer")
	public String deleteManufacturer(@RequestParam(value = "id", required = false) Integer id, Model model) {
		try {
			if (null != id) {
				if (manufacturerServiceImpl.removeManufacturerById(id))
					model.addAttribute("found", "deleted successfully");
			}
		} catch (ProductManagementException e) {

			e.printStackTrace();
		}
		return "deleteManufacturer";
	}
	
	@RequestMapping("/getManufacturers")
	public String displayManufacturers(Model model) {
		try {
			System.out.println(manufacturerServiceImpl.getManufacturers());
			model.addAttribute("manufacturers", manufacturerServiceImpl.getManufacturers());
		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		return "getManufacturers";
	}
	
	@RequestMapping(value = { "/displayManufacturer", "/updateManufacturer" })
	public String displayManufacturerById(@RequestParam(value = "id", required = false) Integer id,
			Model model, HttpServletRequest request) {
		String action = request.getServletPath();
		try {
			if (null != id) {
				model.addAttribute("references", manufacturerServiceImpl.getManufacturerById(id));
			}
		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		if (action.equals("/updateManufacturer")) {
			return "createManufacturer";
		} else {
			return "displayManufacturer";
		}
	}
}
