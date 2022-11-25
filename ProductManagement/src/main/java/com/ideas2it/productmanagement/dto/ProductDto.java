package com.ideas2it.productmanagement.dto;

import java.util.Date;

import com.ideas2it.productmanagement.util.enumaration.Colour;

public class ProductDto {

	private String code;
	private String name;
	private Colour colour;
	private int price;
	private Date dateOfmanufacture;

	public ProductDto(String code, String name, Colour colour, int price, Date dateOfmanufacture) {

		this.code = code;
		this.name = name;
		this.colour = colour;
		this.price = price;
		this.dateOfmanufacture = dateOfmanufacture;
	}

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

}
