package com.onlinesweetmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinesweetmart.entity.OrderBill;
import com.onlinesweetmart.service.OrderBillService;

@RestController
@RequestMapping(value="/api/v1")
public class OrderBillController {
	
	@Autowired
	OrderBillService orderBillService;
	
	@PostMapping(value="orderbill")
	ResponseEntity<OrderBill> addOrderBill(@RequestBody OrderBill orderBill){
		
		OrderBill orderBill2 = orderBillService.addOrderBill(orderBill);
		
		return new ResponseEntity<OrderBill>(orderBill2, HttpStatus.OK);
	}
	
	@PutMapping(value="orderbill")
	ResponseEntity<OrderBill> updateOrderBill(@RequestBody OrderBill orderBill){
		
		OrderBill orderBill3 = orderBillService.updateOrderBill(orderBill);
		return new ResponseEntity<OrderBill>(orderBill3, HttpStatus.OK);
	}
	
	@DeleteMapping(value="orderbill/{id}")
	ResponseEntity<OrderBill> cancelOrderbill(@PathVariable int id){
		
		orderBillService.cancelOrderBill(id);
		
		return new ResponseEntity<OrderBill>(HttpStatus.OK);
	}
	
	@GetMapping(value="orderbill")
	ResponseEntity <List<OrderBill>> showAllOrderBills(){
		
		List<OrderBill> orderBills = orderBillService.showAllOrderBills();
		
		return new ResponseEntity<List<OrderBill>>(orderBills, HttpStatus.OK);
	}
	
	@GetMapping(value="orderbill/{id}")
	ResponseEntity<OrderBill> showOrderBillById(@PathVariable int id){
		
		OrderBill orderBill4 = orderBillService.showOrderBillById(id);
		
		return new ResponseEntity<OrderBill>(orderBill4, HttpStatus.OK);
	}

}
