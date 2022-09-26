package com.onlinesweetmart.service;

import java.util.List;

import com.onlinesweetmart.entity.OrderBill;

public interface OrderBillService {
	public OrderBill addOrderBill(OrderBill orderBill);
	public OrderBill updateOrderBill(OrderBill orderBill);
	public OrderBill cancelOrderBill(int orderBillId);
	public List<OrderBill> showAllOrderBills();
	public OrderBill showOrderBillById (int orderBillId);
}
