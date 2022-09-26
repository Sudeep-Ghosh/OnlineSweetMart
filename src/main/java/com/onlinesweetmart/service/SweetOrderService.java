package com.onlinesweetmart.service;

import java.util.List;

import com.onlinesweetmart.entity.SweetOrder;

public interface SweetOrderService {

	public SweetOrder addSweetOrder(SweetOrder sweetOrder);
	
	public SweetOrder updateSweetOrder(SweetOrder sweetOrder);
	
	public SweetOrder cancelSweetOrder(int sweetOrderId);
	
	public List<SweetOrder> showAllSweetOrders();
	
	public double calculateTotalCost(int sweetOrderId);
}
