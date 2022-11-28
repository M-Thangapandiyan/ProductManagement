package com.ideas2it.productmanagement.service;

import java.util.List;

import com.ideas2it.productmanagement.model.Dealer;
import com.ideas2it.productmanagement.util.customexception.ProductNotFoundException;

public interface DealerService {

	/**
	 * This method used to save the product details given by user
	 *
	 * @param dealer - an dealer to be checked
	 * @return - dealer object if the dealer details saved
	 * @throws ProductNotFoundException 
	 */
	public Dealer saveDealer(Dealer dealer)  throws ProductNotFoundException;

	/**
	 * This method used to get all the product details 
	 *
	 * @return - dealer object if the dealer details there
	 * @throws ProductNotFoundException 
	 */
	public List<Dealer> getDealers() throws ProductNotFoundException;

	/**
	 * It is used to get product details by Id
	 *
	 * @param dealerId - an dealer id to be checked
	 * @return - true if the dealer id contain false if the dealer id contain
	 * @throws ProductNotFoundException 
	 */
	public Dealer getDealerById(int id) throws ProductNotFoundException;
	
	/**
	 * This method used to delete product details by Id
	 *
	 * @param dealerId - an dealer id to be checked
	 * @return - the dealer id deleted message
	 * @throws ProductNotFoundException 
	 */
	public String deleteDealer(int id) throws ProductNotFoundException;

	/**
	 * This method used to update product details by Id
	 *
	 * @param dealer object and dealerId - an dealer id to be checked 
	 * @return - dealer object if the dealer details updated 
	 * @throws ProductNotFoundException 
	 */
	public Dealer updateDealer(Dealer dealer, int id)throws ProductNotFoundException;

}
