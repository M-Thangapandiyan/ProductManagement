package com.ideas2it.productmanagement.model;

import java.util.Date;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ideas2it.productmanagement.util.DateUtil;
import com.ideas2it.productmanagement.util.enumaration.Colour;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@SQLDelete(sql = "UPDATE Product SET is_deleted = 1 WHERE id=?")
@Where(clause = "is_deleted = false")
@Entity
public class Product extends BaseModel {

	@Column(name = "product_code")
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "colour")

	@Enumerated(EnumType.STRING)
	private Colour colour;

	@Column(name = "price", columnDefinition = "int")
	private int price;

	@Column(name = "date_of_manufacture")
	private Date dateOfManufacture;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "manufacture_id", columnDefinition = "int")
	private Manufacturer manufacturer;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "dealer_id", columnDefinition = "int")
	private Dealer dealer;

	private String username;
	private String password;

	public Product() {
	}

	public Product(String code, String name, int price, Colour colour, Date dateOfManufacture) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.colour = colour;
		this.dateOfManufacture = dateOfManufacture;
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

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	public int getLifeTime(Date dateOfManufacture) {
		return DateUtil.find(dateOfManufacture, DateUtil.currentDate);
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
