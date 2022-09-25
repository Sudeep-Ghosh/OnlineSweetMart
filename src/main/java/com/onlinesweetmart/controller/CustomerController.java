package com.onlinesweetmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinesweetmart.entity.Customer;
import com.onlinesweetmart.service.CustomerService;

@RestController
@RequestMapping(value ="/onlineSweetMart/")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value="customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		customerService.addCustomer(customer);
		return null;
		
	}
	
	@PutMapping(value="customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		customerService.updateCustomer(customer);
		return null;
		
	}
	
	@DeleteMapping(value="customer/{customerId}")
	public ResponseEntity<Customer> cancelCustomer(@PathVariable int customerId){
		customerService.cancelCustomer(customerId);
		return null;
		
	}
	
	@GetMapping(value="customer")
	public ResponseEntity<List<Customer>> showAllCustomers(){
		customerService.showAllCustomers();
		return null;
		
	}
	
	@GetMapping(value="customer/{customerId}")
	public ResponseEntity<Customer> showAllCustomers(@PathVariable int customerId){
		customerService.showAllcustomers(customerId);
		return null;
		
	}

}
