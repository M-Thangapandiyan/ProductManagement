package com.ideas2it.productmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.productmanagement.dao.ManufacturerDao;
import com.ideas2it.productmanagement.model.Manufacturer;
import com.ideas2it.productmanagement.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	ManufacturerDao repositery;

	public Manufacturer saveManufacturer(Manufacturer manufacturer) {
		return repositery.save(manufacturer);
	}

	public List<Manufacturer> getManufacturers() {
		return repositery.findAll();
	}

	public Manufacturer getManufacturerById(int id) {
		return repositery.getById(id);
	}

	public String deleteManufacturer(int id) {
		Manufacturer manufacturer = repositery.findById(id).orElse(null);
		repositery.delete(manufacturer);
		return "removed" + id;
	}

	public Manufacturer updateManufacturer(Manufacturer manufacturer, int id) {
		Manufacturer manufacturer1 = repositery.findById(id).orElse(null);
		if (null != manufacturer1) {
			manufacturer1.setBrand(manufacturer.getBrand());
			manufacturer1.setPlace(manufacturer.getPlace());
		}
		return repositery.save(manufacturer1);
	}

}
