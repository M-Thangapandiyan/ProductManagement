package com.ideas2it.productmanagement.service;

import java.util.List;

import com.ideas2it.productmanagement.model.Manufacturer;

public interface ManufacturerService {

	public Manufacturer saveManufacturer(Manufacturer manufacturer);

	public List<Manufacturer> getManufacturers();

	/**
	 * It is used to get product details by Id
	 *
	 * @param ManufacturerId - an Manufacturer id to be checked
	 * @return - true if the Manufacturer id contain false if the Manufacturer id contain
	 */
	public Manufacturer getManufacturerById(int id);

	public String deleteManufacturer(int id);

	public Manufacturer updateManufacturer(Manufacturer manufacturer, int id);
}
