package com.ideas2it.productmanagement.dto;

public class ManufacturerDto {

	private String brand;
	private String place;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public ManufacturerDto(String brand, String location) {
		this.brand = brand;
		this.place = location;
	}

	public String getLocation() {
		return place;
	}

	public void setLocation(String location) {
		this.place = location;
	}
}
