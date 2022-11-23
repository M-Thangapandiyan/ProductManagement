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
		/*
		 * Dealer ed = repositery.findById(id).orElse(null); if(null != ed ) {
		 * ed.setDeleted(true); } repositery.save(ed);
		 * 
		 */
		Dealer ed = repositery.findById(id).orElse(null);
		repositery.delete(ed);
		return "removed" + id;
	}

	public Dealer updateDealer(Dealer dealer,int id) {
		Dealer ed = repositery.findById(id).orElse(null);
		if (null != ed) {
		    ed.setCompany(dealer.getCompany());
		    ed.setLocation(dealer.getLocation());
		}    
		return repositery.save(ed);
	}
}
