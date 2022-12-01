package com.ideas2it.productmanagement.model;

import java.util.List;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@SQLDelete(sql = "UPDATE Dealer SET is_deleted = true WHERE id=?", check = ResultCheckStyle.COUNT)
@Where(clause = "is_deleted = false")
@Entity
public class Dealer extends BaseModel {

	private String username;
	private String password;
	private String role; 
	
	@Column(name = "company")
	private String company;
	@Column(name = "location")
	private String location;

	@JsonIgnore
	@OneToMany(targetEntity = Product.class, fetch = FetchType.LAZY, mappedBy = "dealer")
	private List<Product> products;

	public Dealer() {

	}

	@Override
	public String toString() {
		return "Dealer [company=" + company + ", location=" + location + ", products=" + products + "]";
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
