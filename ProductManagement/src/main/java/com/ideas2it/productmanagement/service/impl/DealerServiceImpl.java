package com.ideas2it.productmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.productmanagement.dao.DealerDao;
import com.ideas2it.productmanagement.model.Dealer;
import com.ideas2it.productmanagement.service.DealerService;
import com.ideas2it.productmanagement.util.customexception.ProductNotFoundException;

@Service
public class DealerServiceImpl implements DealerService {

	@Autowired
	DealerDao repository;

	public Dealer saveDealer(Dealer dealer) throws ProductNotFoundException {
		Dealer dealer1 = repository.save(dealer);
		if (dealer != null) {
			return dealer1;
		} else {
			throw new ProductNotFoundException("Dealer values are null, can not be stored");
		}
	}

	public List<Dealer> getDealers() throws ProductNotFoundException {
		List<Dealer> dealers = repository.findAll();
		if (dealers != null && !dealers.isEmpty()) {
			return dealers;
		} else {
			throw new ProductNotFoundException("Dealers not found");
		}
	}

	public Dealer getDealerById(int id) throws ProductNotFoundException {
		Dealer dealer = repository.findById(id).orElse(null);
		if (dealer != null) {
			return dealer;
		} else {
			throw new ProductNotFoundException("Dealer not found with id : " + id);
		}
	}

	public String deleteDealer(int id) throws ProductNotFoundException {
		Dealer dealer = repository.findById(id).orElse(null);
		if (dealer != null) {
			repository.delete(dealer);
			return "removed" + id;
		} else {
			throw new ProductNotFoundException("Dealer not found with id : " + id);
		}
	}

	public Dealer updateDealer(Dealer dealer, int id) throws ProductNotFoundException {
		Dealer updatedealer = repository.findById(id).orElse(null);
		if (null != updatedealer) {
			updatedealer.setCompany(dealer.getCompany());
			updatedealer.setLocation(dealer.getLocation());
			return repository.save(dealer);
		} else {
			throw new ProductNotFoundException("Dealer not found with id : " + id);
		}
	}
}
