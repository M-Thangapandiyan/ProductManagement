package com.ideas2it.productmanagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SQLDelete(sql = "UPDATE Manufacturer SET is_deleted = true WHERE id=?", check = ResultCheckStyle.COUNT)
@Where(clause = "is_deleted = false")
@Entity
public class Manufacturer extends BaseModel {
	@Column(name = "brand")
	private String brand;
	@Column(name = "place")
	private String place;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")

	private List<Product> products;

	public Manufacturer() {
	}

	public Manufacturer(String brand, String place) {
		this.brand = brand;
		this.place = place;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;

	}

	@Override
	public String toString() {
		return "Manufacturer [brand=" + brand + ", place=" + place + ", products=" + products + ", getId()=" + getId()
				+ ", getCreatedAt()=" + getCreatedAt() + ", getUpdatedAt()=" + getUpdatedAt() + ", isDeleted()="
				+ isDeleted() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
