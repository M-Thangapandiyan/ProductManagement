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

import com.ideas2it.productmanagement.converter.DealerConvertor;
import com.ideas2it.productmanagement.dto.DealerDto;
import com.ideas2it.productmanagement.model.Dealer;
import com.ideas2it.productmanagement.service.DealerService;
import com.ideas2it.productmanagement.util.customexception.ProductNotFoundException;

@RestController
public class DealerController {

	@Autowired
	DealerService service;

	@Autowired
	DealerConvertor convertor;

	@PostMapping("/addDealer")
	public DealerDto addDealer(@RequestBody DealerDto dealerDto) throws ProductNotFoundException {
		Dealer dealer = service.saveDealer(convertor.dtoToEntity(dealerDto));
		return convertor.entityToDto(dealer);
	}

	@GetMapping("/getDealers")
	public List<DealerDto> findAllDealer() throws ProductNotFoundException {
		List<Dealer> findAll = service.getDealers();
		return convertor.entityToDto1(findAll);
	}

	@GetMapping("/getDealer/{id}")
	public DealerDto findDealer(@PathVariable("id") int id) throws ProductNotFoundException {
		Dealer dealer = service.getDealerById(id);
		return convertor.entityToDto(dealer);
	}

	@DeleteMapping("/deleteDealer/{id}")
	public String deleteDealer(@PathVariable int id) throws ProductNotFoundException {
		return service.deleteDealer(id);
	}

	@PutMapping("/updateDealer/{id}")
	public DealerDto updateDealer(@RequestBody DealerDto dealerDto, @PathVariable("id") int id)
			throws ProductNotFoundException {
		Dealer dealer = service.updateDealer(convertor.dtoToEntity(dealerDto), id);
		return convertor.entityToDto(dealer);
	}
}
