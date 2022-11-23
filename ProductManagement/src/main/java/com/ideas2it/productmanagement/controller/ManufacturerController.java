package com.ideas2it.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.productmanagement.model.Manufacturer;
import com.ideas2it.productmanagement.service.ManufacturerService;

	@RestController
	public class ManufacturerController {

		@Autowired
		ManufacturerService service;

		@PostMapping("/addManufacturer")
		public Manufacturer addManufacturer(@RequestBody Manufacturer Manufacturer) {
			return service.saveManufacturer(Manufacturer);
		}

		@GetMapping("/getManufacturers")
		public List<Manufacturer> findAllManufacturer() {
			return service.getManufacturers();
		}

		@GetMapping("/getManufacturer/{id}")
		public Manufacturer findManufacturer(@PathVariable("id") int id) {
			return service.getManufacturerById(id);
		}

		@DeleteMapping("/deleteManufacturer/{id}")
		public String deleteManufacturer(@PathVariable int id) {
			return service.deleteManufacturer(id);
		}

		@PostMapping("/updateManufacturer/{id}")
		public Manufacturer updateManufacturer(@RequestBody Manufacturer Manufacturer, @PathVariable("id") int id) {
			return service.updateManufacturer(Manufacturer,id);

		}
}
