package com.ideas2it.productmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.productmanagement.model.Dealer;

public interface DealerDao extends JpaRepository<Dealer, Integer> {

}
