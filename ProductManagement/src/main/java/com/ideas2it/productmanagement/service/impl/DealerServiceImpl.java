package com.ideas2it.productmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.productmanagement.dao.DealerDao;
import com.ideas2it.productmanagement.model.Dealer;
import com.ideas2it.productmanagement.service.DealerService;

@Service
public class DealerServiceImpl implements DealerService {
	
	@Autowired
	DealerDao repositery;

	public Dealer saveDealer(Dealer dealer) {
		return repositery.save(dealer);
	}

	public List<Dealer> getDealers() {
		return repositery.findAll();
	}

	public Dealer getDealerById(int id) {

		return repositery.getById(id);
	}

	public String deleteDealer(int id) {
		
		Dealer delete = repositery.findById(id).orElse(null);
		repositery.delete(delete);
		return "removed" + id;
	}

	public Dealer updateDealer(Dealer dealer,int id) {
		Dealer dealr = repositery.findById(id).orElse(null);
		if (null != dealr) {
		    dealr.setCompany(dealer.getCompany());
		    dealr.setLocation(dealer.getLocation());
		}    
		return repositery.save(dealr);
	}
}
