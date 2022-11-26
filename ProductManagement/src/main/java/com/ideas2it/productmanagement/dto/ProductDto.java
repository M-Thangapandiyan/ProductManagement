package com.ideas2it.productmanagement.dto;

import java.util.Date;

import com.ideas2it.productmanagement.model.Dealer;
import com.ideas2it.productmanagement.model.Manufacturer;
import com.ideas2it.productmanagement.util.enumaration.Colour;

public class ProductDto {

	private int id;
	private String code;
	private String name;
	private Colour colour;
	private int price;
	private Date dateOfmanufacture;
	
	private DealerDto dealer;
	
	private ManufacturerDto manufacturer;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDateOfmanufacture() {
		return dateOfmanufacture;
	}

	public void setDateOfmanufacture(Date dateOfmanufacture) {
		this.dateOfmanufacture = dateOfmanufacture;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ManufacturerDto getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerDto manufacturer) {
		this.manufacturer = manufacturer;
	}

	public DealerDto getDealer() {
		return dealer;
	}

	public void setDealer(DealerDto dealer) {
		this.dealer = dealer;
	}

	

}
