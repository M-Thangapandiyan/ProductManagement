package com.ideas2it.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.productmanagement.model.Dealer;
import com.ideas2it.productmanagement.service.DealerService;

@RestController
public class DealerController {

	@Autowired
	DealerService service;

	@PostMapping("/addDealer")
	public Dealer addDealer(@RequestBody Dealer dealer) {
		return service.saveDealer(dealer);

	}

	@GetMapping("/getDealers")
	public List<Dealer> findAllDealer() {
		return service.getDealers();
	}

	@GetMapping("/getDealer/{id}")
	public Dealer findDealer(@PathVariable("id") int id) {
		return service.getDealerById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteDealer(@PathVariable int id) {
		return service.deleteDealer(id);
	}

	@PostMapping("/updateDealer/{id}")
	public Dealer updateDealer(@RequestBody Dealer dealer, @PathVariable("id") int id) {
		return service.update(dealer,id);

	}
}
