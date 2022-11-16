package com.ideas2it.productManagement.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas2it.productManagement.model.Manufacturer;
import com.ideas2it.productManagement.service.impl.ManufacturerServiceImpl;
import com.ideas2it.productManagement.service.impl.ProductServiceImpl;
import com.ideas2it.productManagement.util.exception.ProductManagementException;

public class ManufacturerSpring {
	@RequestMapping("/createManufacturer")
	public String create(Model model) {
		model.addAttribute("references", new Manufacturer());
		return "createManufacturer";
	}

	@RequestMapping(value = "/InsertManufacturer", method = RequestMethod.POST)
	public String createManufacturer(@ModelAttribute("references") Manufacturer manufacturer, Model model) {
		try {
			model.addAttribute("reference", new ManufacturerServiceImpl().createManufacturer(manufacturer));
		} catch (ProductManagementException e) {
			
			e.printStackTrace();
		}
		return "createManufactuer";
	}
	
	@RequestMapping("/deleteManufacturer")
	public String deleteManufacturer(@RequestParam(value = "id", required = false) Integer id, Model model) {
		try {
			if (null != id) {
				if (new ManufacturerServiceImpl().removeManufacturerById(id))
					model.addAttribute("found", "deleted successfully");
			}
		} catch (ProductManagementException e) {

			e.printStackTrace();
		}
		return "deleteManufacturer";
	}
}
