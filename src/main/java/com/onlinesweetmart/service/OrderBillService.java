package com.onlinesweetmart.service;

import java.util.List;

import com.onlinesweetmart.entity.OrderBill;

public interface OrderBillService {
	OrderBill addOrderBill(OrderBill orderBill);
	OrderBill updateOrderBill(OrderBill orderBill);
	void cancelOrderBill(int orderBillId);
	List<OrderBill> showAllOrderBills();
	OrderBill showOrderBillById (int orderBillId);
}
