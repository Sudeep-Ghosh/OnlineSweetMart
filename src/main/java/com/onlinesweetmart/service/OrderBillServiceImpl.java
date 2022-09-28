package com.onlinesweetmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.OrderBill;
import com.onlinesweetmart.exception.IdNotFoundException;
import com.onlinesweetmart.repository.OrderBillRepository;




@Service
public class OrderBillServiceImpl implements OrderBillService {
	
	@Autowired
	OrderBillRepository orderBillRepository;
	
	/*
	 * @Auther : Sudeep Ghosh
	 * @Description : this is used to add an order bill
	 * @Param : it takes orderBill as a parameter
	 * @Return : it returns order bill
	 * @Date Created : 24 Sept 2022
	 */

	@Override
	public OrderBill addOrderBill(OrderBill orderBill) {
		// TODO Auto-generated method stub
		return orderBillRepository.save(orderBill);
	}

	/*
	 * @Auther : Sudeep Ghosh
	 * @Description : this is used to update an order bill
	 * @Param : it takes orderBill as a parameter
	 * @Return : it returns order bill
	 * @Date Created : 24 Sept 2022
	 */
	
	@Override
	public OrderBill updateOrderBill(OrderBill orderBill) {
		// TODO Auto-generated method stub
		OrderBill existingOrderBill = new OrderBill();
		if(orderBillRepository.existsById(orderBill.getOrderBillId())) {
		existingOrderBill.setCreatedDate(orderBill.getCreatedDate());
		existingOrderBill.setTotalCost(orderBill.getTotalCost());
		
		return orderBillRepository.save(existingOrderBill);
		}
		else {
			throw new IdNotFoundException("The given Id is not present");
		}
	}

	/*
	 * @Auther : Sudeep Ghosh
	 * @Description : this is used to cancel an order bill
	 * @Param : it takes orderBill as a parameter
	 * @Return : it returns order bill
	 * @Date Created : 24 Sept 2022
	 */
	
	@Override
	public OrderBill cancelOrderBill(int orderBillId) {
		// TODO Auto-generated method stub
		OrderBill orderBill;
		if(orderBillRepository.existsById(orderBillId)) {
			orderBill = orderBillRepository.findById(orderBillId).get();
			orderBillRepository.deleteById(orderBillId);
			return orderBill;
		}
		else {
			throw new IdNotFoundException("No order bill found with the given orderBillId");
		}
	}

	/*
	 * @Auther : Sudeep Ghosh
	 * @Description : this is used to view an order bill
	 * @Param : it takes orderBill as a parameter
	 * @Return : it returns order bill list
	 * @Date Created : 24 Sept 2022
	 */
	
	@Override
	public List<OrderBill> showAllOrderBills() {
		// TODO Auto-generated method stub
		List<OrderBill> bill = orderBillRepository.findAll();
		if(bill.isEmpty())
		{
			throw new CustomException("No order bill found");
		}
		return bill;
	}

	/*
	 * @Auther : Sudeep Ghosh
	 * @Description : this is used to add an order bill
	 * @Param : it takes orderBill id as a parameter
	 * @Return : it returns order bill
	 * @Date Created : 24 Sept 2022
	 */

	@Override
	public OrderBill showOrderBillById(int orderBillId) {
		// TODO Auto-generated method stub
		Optional<OrderBill> orderBill = orderBillRepository.findById(orderBillId);
		if (orderBill.isPresent()) {
			return orderBill.get();
		} else {
			throw new IdNotFoundException("The given order bill id: " + orderBillId + " is not present");
		}

	}
}
