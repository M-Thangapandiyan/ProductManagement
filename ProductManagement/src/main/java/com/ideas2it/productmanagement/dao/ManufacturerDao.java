package com.ideas2it.productmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.productmanagement.model.Manufacturer;

public interface ManufacturerDao extends JpaRepository<Manufacturer, Integer> {

}
