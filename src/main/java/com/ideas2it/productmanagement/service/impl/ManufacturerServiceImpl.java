package com.ideas2it.productmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.productmanagement.dao.ManufacturerDao;
import com.ideas2it.productmanagement.model.Manufacturer;
import com.ideas2it.productmanagement.service.ManufacturerService;
import com.ideas2it.productmanagement.util.customexception.ProductNotFoundException;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	ManufacturerDao repository;

	public Manufacturer saveManufacturer(Manufacturer manufacturer) throws ProductNotFoundException {
		Manufacturer manufacturerOne = repository.save(manufacturer);
		if (null != manufacturerOne) {
			return manufacturerOne;
		} else {
			throw new ProductNotFoundException("Dealer values are null, can not be stored");
		}

	}

	public List<Manufacturer> getManufacturers() throws ProductNotFoundException {

		List<Manufacturer> manufacturers = repository.findAll();
		if (null != manufacturers && !manufacturers.isEmpty()) {
			return manufacturers;
		} else {
			throw new ProductNotFoundException("Dealers not found with id");
		}
	}

	public Manufacturer getManufacturerById(int id) throws ProductNotFoundException {

		Manufacturer manufacturerOne = repository.findById(id).orElse(null);
		if (null != manufacturerOne) {
			return manufacturerOne;
		} else {
			throw new ProductNotFoundException("Dealer not found id : " + id);
		}
	}

	public String deleteManufacturer(int id) throws ProductNotFoundException {
		Manufacturer manufacturer = repository.findById(id).orElse(null);
		if (null != manufacturer) {
			repository.delete(manufacturer);
			return "removed" + id;
		} else {
			throw new ProductNotFoundException("Dealer not found with id : " + id);
		}
	}

	public Manufacturer updateManufacturer(Manufacturer manufacturer, int id) throws ProductNotFoundException {
		Manufacturer manufacturer1 = repository.findById(id).orElse(null);
		if (null != manufacturer1) {
			manufacturer1.setBrand(manufacturer.getBrand());
			manufacturer1.setPlace(manufacturer.getPlace());
			return repository.save(manufacturer1);
		} else {
			throw new ProductNotFoundException("Dealer not found with id : " + id);
		}

	}
}
