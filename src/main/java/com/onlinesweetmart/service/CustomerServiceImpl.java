package com.onlinesweetmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.Customer;
import com.onlinesweetmart.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	/*
	 * @Auther : Deepali Kosta
	 * @Description : this is used to add,update,cancel 
	 * or view customer
	 * @Param : it takes customer as a parameter
	 * @Return : it returns customer
	 * @Date Created : 24 Sept 2022
	 * 
	 */

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer existingCustomer = customerRepository.findById(customer.getUserId()).orElse(null);
		existingCustomer.setUsername(customer.getUsername());
		existingCustomer.setSweetItems(customer.getSweetItems());
		existingCustomer.setSweetOrders(customer.getSweetOrders());
		existingCustomer.setCart(customer.getCart());
		return customerRepository.save(existingCustomer);
	}

	@Override
	public void cancelCustomer(int customerId) {
		// TODO Auto-generated method stub
		Optional<Customer> customer =	customerRepository.findById(customerId);
		if(customer.isPresent())
		{
			customerRepository.deleteById(customerId);
		}
	}

	@Override
	public List<Customer> showAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer showAllcustomers(int customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId).get();
	}

}
