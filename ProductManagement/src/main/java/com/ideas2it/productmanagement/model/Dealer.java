package com.ideas2it.productmanagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SQLDelete(sql = "UPDATE Dealer SET is_deleted = true WHERE id=?", check = ResultCheckStyle.COUNT)
@Where(clause = "is_deleted = false")
@Entity
public class Dealer extends BaseModel {

	@Column(name = "company", columnDefinition = "varchar(255)")
	private String company;
	@Column(name = "location", columnDefinition = "varchar(255)")
	private String location;

	@JsonIgnore
	@OneToMany(targetEntity = Product.class,fetch = FetchType.LAZY, mappedBy = "dealer")
	private List<Product> products;

	public Dealer() {

	}

	public Dealer(String company, String location) {
		this.company = company;
		this.location = location;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
