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

import com.onlinesweetmart.entity.Customer;
import com.onlinesweetmart.service.CustomerService;

@RestController
@RequestMapping(value ="/api/v1")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value="customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
	Customer addedCustomer = customerService.addCustomer(customer);
	 return new ResponseEntity<Customer>(addedCustomer, HttpStatus.OK);
		
	}
	
	@PutMapping(value="customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		Customer updatedCustomer =customerService.updateCustomer(customer);
		 return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="customer/{customerId}")
	public ResponseEntity<Customer> cancelCustomer(@PathVariable long customerId){
		customerService.cancelCustomer(customerId);
		 return new ResponseEntity<Customer>(HttpStatus.OK);	
	}
	
	@GetMapping(value="customer")
	public ResponseEntity<List<Customer>> showAllCustomers(){
	List<Customer> customerList=customerService.showAllCustomers();
		 return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
		
	}
	
	@GetMapping(value="customer/{customerId}")
	public ResponseEntity<Customer> showAllCustomers(@PathVariable long customerId){
		Customer customer=customerService.showAllcustomers(customerId);
		 return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}



