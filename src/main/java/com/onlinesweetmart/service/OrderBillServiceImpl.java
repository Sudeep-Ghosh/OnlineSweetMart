package com.onlinesweetmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.OrderBill;
import com.onlinesweetmart.repository.OrderBillRepository;




@Service
public class OrderBillServiceImpl implements OrderBillService {
	
	@Autowired
	OrderBillRepository orderBillRepository;
	
	/*
	 * @Auther : Sudeep Ghosh
	 * @Description : this is used to add,update,cancel 
	 * or view an order bill
	 * @Param : it takes orderBill as a parameter
	 * @Return : it returns order bill
	 * @Date Created : 24 Sept 2022
	 * 
	 */

	@Override
	public OrderBill addOrderBill(OrderBill orderBill) {
		// TODO Auto-generated method stub
		return orderBillRepository.save(orderBill);
	}

	@Override
	public OrderBill updateOrderBill(OrderBill orderBill) {
		// TODO Auto-generated method stub
		OrderBill existingOrderBill = orderBillRepository.findById(orderBill.getOrderBillId()).orElse(null);
		existingOrderBill.setLocalDate(orderBill.getLocalDate());
		existingOrderBill.setTotalCost(orderBill.getTotalCost());
		return orderBillRepository.save(existingOrderBill);
	}

	@Override
	public void cancelOrderBill(int orderBillId) {
		// TODO Auto-generated method stub
		Optional<OrderBill> orderBill =	orderBillRepository.findById(orderBillId);
		if(orderBill.isPresent())
		{
		orderBillRepository.deleteById(orderBillId);
		}
	}

	@Override
	public List<OrderBill> showAllOrderBills() {
		// TODO Auto-generated method stub
		return (List<OrderBill>) orderBillRepository.findAll();
	}


	@Override
	public OrderBill showOrderBillById(int orderBillId) {
		// TODO Auto-generated method stub
		return orderBillRepository.findById(orderBillId).get();
	}

}
