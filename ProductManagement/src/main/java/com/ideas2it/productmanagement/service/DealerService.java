package com.ideas2it.productmanagement.service;

import java.util.List;

import com.ideas2it.productmanagement.model.Dealer;

public interface DealerService {

	public Dealer saveDealer(Dealer dealer);

	public List<Dealer> getDealers();

	/**
	 * It is used to get product details by Id
	 *
	 * @param dealerId - an dealer id to be checked
	 * @return - true if the dealer id contain false if the dealer id contain
	 */
	public Dealer getDealerById(int id);

	public String deleteDealer(int id);

	public Dealer updateDealer(Dealer dealer, int id);

}
