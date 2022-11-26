package com.ideas2it.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.productmanagement.converter.ManufacturerConvertor;
import com.ideas2it.productmanagement.dto.ManufacturerDto;
import com.ideas2it.productmanagement.model.Manufacturer;
import com.ideas2it.productmanagement.model.Product;
import com.ideas2it.productmanagement.service.ManufacturerService;

@RestController
public class ManufacturerController {

	@Autowired
	ManufacturerService service;

	@Autowired
	ManufacturerConvertor convertor;

	@PostMapping("/addManufacturer")
	public ManufacturerDto addManufacturer(@RequestBody ManufacturerDto manufacturerDto) {
		Manufacturer manufacturer = service.saveManufacturer(convertor.dtoToEntity(manufacturerDto));
		return convertor.entityToDto(manufacturer);
	}

	@GetMapping("/getManufacturers")
	public List<ManufacturerDto> findAllManufacturer() {
		List<Manufacturer> manufacturers = service.getManufacturers();
		return convertor.entityToDto1(manufacturers); 
	}

	@GetMapping("/getManufacturer/{id}")
	public ManufacturerDto findManufacturer(@PathVariable("id") int id) {
		Manufacturer manufacturer =  service.getManufacturerById(id);
		return convertor.entityToDto(manufacturer);
	}

	@DeleteMapping("/deleteManufacturer/{id}")
	public String deleteManufacturer(@PathVariable int id) {
		return service.deleteManufacturer(id);
	}

	@PutMapping("/updateManufacturer/{id}")
	public ManufacturerDto updateManufacturer(@RequestBody ManufacturerDto manufacturerDto, @PathVariable("id") int id) {
		 Manufacturer manufacturer = service.updateManufacturer(convertor.dtoToEntity(manufacturerDto), id);
		return convertor.entityToDto(manufacturer);

	}
}
