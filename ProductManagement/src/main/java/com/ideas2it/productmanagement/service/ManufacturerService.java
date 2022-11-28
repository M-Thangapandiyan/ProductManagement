package com.ideas2it.productmanagement.service;

import java.util.List;

import com.ideas2it.productmanagement.model.Manufacturer;
import com.ideas2it.productmanagement.util.customexception.ProductNotFoundException;

public interface ManufacturerService {

	public Manufacturer saveManufacturer(Manufacturer manufacturer) throws ProductNotFoundException;

	public List<Manufacturer> getManufacturers() throws ProductNotFoundException;

	/**
	 * It is used to get product details by Id
	 *
	 * @param ManufacturerId - an Manufacturer id to be checked
	 * @return - true if the Manufacturer id contain false if the Manufacturer id contain
	 */
	public Manufacturer getManufacturerById(int id) throws ProductNotFoundException;

	public String deleteManufacturer(int id)throws ProductNotFoundException;

	public Manufacturer updateManufacturer(Manufacturer manufacturer, int id)throws ProductNotFoundException;
}
