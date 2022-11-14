package com.ideas2it.productManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas2it.productManagement.model.Dealer;
import com.ideas2it.productManagement.service.impl.DealerServiceImpl;
import com.ideas2it.productManagement.util.exception.ProductManagementException;

@Controller
public class DealerSpring {

	@RequestMapping("/createDealer")
	public String create(Model model) {
		model.addAttribute("references", new Dealer());
		return "createDealer";
	}

	@RequestMapping("/InsertDealer")
	public String createDealer(@ModelAttribute("references") Dealer dealer, Model model) {
		try {
			model.addAttribute("reference", new DealerServiceImpl().createDealer(dealer));
		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		return "createDealer";
	}

	@RequestMapping("/deleteDealer")
	public String deleteDealer(@RequestParam(value = "id", required =false) Integer id, Model model) {
		try {
			if (null != id) {
			if (new DealerServiceImpl().removeDealerById(id)) 
			    model.addAttribute("found", "deleted successfully");
			}
		} catch (ProductManagementException e) {
		
			e.printStackTrace();
		}
		return "deleteDealer";
	}
	
	/*
	 * @RequestMapping("/Dealer") public String displayDealer(@RequestParam(value =
	 * "id", required =false) Integer id, Model model) { }
	 */
}
