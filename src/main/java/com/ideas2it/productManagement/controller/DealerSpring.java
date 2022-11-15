package com.ideas2it.productManagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ideas2it.productManagement.model.Dealer;
import com.ideas2it.productManagement.service.DealerService;
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
			if (0 != dealer.getId()) {
				if (new DealerServiceImpl().updateDealerById(dealer)) {
					model.addAttribute("reference", "updated successfully");
				}

			} else {
				model.addAttribute("reference", new DealerServiceImpl().createDealer(dealer));
			}

		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		return "createDealer";
	}

	@RequestMapping("/deleteDealer")
	public String deleteDealer(@RequestParam(value = "id", required = false) Integer id, Model model) {
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

	@RequestMapping("/getDealers")
	public String displayDealer(Model model) {
		try {
			model.addAttribute("dealers", new DealerServiceImpl().getDealers());
		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		return "getDealers";
	}

	@RequestMapping(value = { "/displayDealer", "/getDealer" })
	public String displayDealerById(@RequestParam(value = "id", required = false) Integer id, Model model,
			HttpServletRequest request) {
		String action = request.getServletPath();
		try {
			if (null != id) {
				model.addAttribute("references", new DealerServiceImpl().getDealerById(id));
			}

		} catch (ProductManagementException e) {
			e.printStackTrace();
		}
		if (action.equals("/getDealer")) {
			return "createDealer";

		} else {
			return "displayDealer";
		}
	}
}
