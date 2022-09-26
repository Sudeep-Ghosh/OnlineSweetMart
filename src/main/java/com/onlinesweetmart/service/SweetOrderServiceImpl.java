package com.onlinesweetmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.SweetOrder;
import com.onlinesweetmart.exception.CustomException;
import com.onlinesweetmart.repository.SweetOrderRepository;

	/*
	 *  @author: Ayush Patel
	 *  @classDescription: Implementation class of SweetOrderService interface
	 *  @createdDate: 24 September 2022
	 */

@Service
public class SweetOrderServiceImpl implements SweetOrderService {

	@Autowired
	private SweetOrderRepository sweetOrderRepository;
	
	/**
	 * method: addSweetOrder() -This method will add SweetOrder in its repository
	 * @param: It will take SweetOrder object as a parameter
	 * @return: It will return persisted entity in database
	 * 
	 */
	@Override
	public SweetOrder addSweetOrder(SweetOrder sweetOrder) {
		
		return sweetOrderRepository.save(sweetOrder);
	}
	
	/**
	 * method: updateSweetOrder() - This method will update SweetOrder in its repository
	 * @param: It will take SweetOrder object as a parameter
	 * @return: It will return updated entity in a database
	 * 
	 */
	
	@Override
	public SweetOrder updateSweetOrder(SweetOrder sweetOrder) {
		SweetOrder sweetOrder2 = new SweetOrder();
		if (sweetOrderRepository.existsById(sweetOrder.getSweetOrderId())) {
			sweetOrder2.setCreatedDate(sweetOrder.getCreatedDate());
			sweetOrder2.setListItems(sweetOrder.getListItems());
			
			return sweetOrder2;
		} else {
			throw new CustomException("sweet order not found");
		}
		
	}
	
	/**
	 * method: cancelSweetOrder() - this method will delete SweetOrder from its database
	 * @param: It will take integer value as a parameter
	 * @return: It will return deleted SweetOrder object from a database
	 * 
	 */
	
	@Override
	public SweetOrder cancelSweetOrder(int sweetOrderId) {
		SweetOrder sweetOrder = new SweetOrder();
		if (sweetOrderRepository.existsById(sweetOrderId)) {
			sweetOrder = sweetOrderRepository.findById(sweetOrderId).get();
			sweetOrderRepository.deleteById(sweetOrderId);
		} else {
			throw new CustomException("sweet order not found");
		}
		return sweetOrder;
	}
	
	/**
	 * method: showAllSweetOrders() - This method will show all SweetOrder present in its customer O
	 * @param: It will not take any parameter
	 * @return: It will return list of entities present in a SweetOrder database
	 * 
	 */
	@Override
	public List<SweetOrder> showAllSweetOrders() {
		List<SweetOrder> listSweetOrders = sweetOrderRepository.findAll();
		if(listSweetOrders.isEmpty()) {
			throw new CustomException("list of sweet order is empty" );
		}
		return listSweetOrders;
	}
	
	/**
	 * method: calculateTotalCost() - This method will calculate total cost of SweetOrder
	 * @param: It will take integer value as a parameter
	 * @return: It will return deleted SweetOrder object from a database
	 * 
	 */
	
	@Override
	public double calculateTotalCost(int sweetOrderId) {
		
		/*
		 * calculateTotalCost(int): this method may depend upon Product Class for calculating
		 *  price of Sweet Order
		 *  
		 *  Note:- This method is not complete now 
		 */
		
		List<SweetOrder> listSweetOrders = showAllSweetOrders();
		for(SweetOrder sweetOrder: listSweetOrders) {
			/*
			 * Product product = new Product();
			 * product.getPrice;
			 */
		}
		return 0;
	}

}
