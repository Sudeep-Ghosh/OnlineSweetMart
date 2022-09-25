package com.onlinesweetmart.service;

import java.util.List;

import com.onlinesweetmart.entity.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public void cancelCustomer(int customerId);
	
	public List<Customer> showAllCustomers();

	public Customer showAllcustomers(int customerId);
	
	

}
