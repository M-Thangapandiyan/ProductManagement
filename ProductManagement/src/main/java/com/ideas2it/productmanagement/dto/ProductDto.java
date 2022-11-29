package com.ideas2it.productmanagement.dto;

import java.util.Date;

import com.ideas2it.productmanagement.util.enumaration.Colour;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDto {

	private int id;
	private String code;
	
	@NotNull(message = "name should not be null")
	@NotBlank
	private String name;
	
	@NotNull(message = "colour should not be null")
	@NotBlank
	private Colour colour;
	
	@Min(100)
	@Max(100000)
	@NotNull(message = "price should not be 0 and minimum price 100 to maximum price 100000")
	@NotBlank
	private int price;
	
	@NotNull(message = "dateOfManufacturer should not be null")
	@NotBlank
	private Date dateOfmanufacture;
	
	@NotNull(message = "dealer should not be null")
	@NotBlank
	private DealerDto dealer;
	
	@NotNull(message = "manufacturer should not be null")
	@NotBlank
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
