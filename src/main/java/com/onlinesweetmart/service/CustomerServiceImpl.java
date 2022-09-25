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
	private CustomerRepository customerRepository;

	/*
	 * @Author : Deepali Kosta
	 * @Description : This is used to add customer
	 * @Param : It takes customer as a parameter
	 * @Return : It returns customer
	 * @Date Created : 24 Sept 2022
	 */
	@Override
	public Customer addCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}
	
	/*
	 * @Author : Deepali Kosta
	 * @Description : This is used to update customer
	 * @Param : It takes customer as a parameter
	 * @Return : It returns customer
	 * @Date Created : 24 Sept 2022 
	 */
	@Override
	public Customer updateCustomer(Customer customer) {
		
		Customer existingCustomer = customerRepository.findById(customer.getUserId()).orElse(null);
		existingCustomer.setUserName(customer.getUserName());
//		existingCustomer.setSweetItems(customer.getSweetItems());
//		existingCustomer.setSweetOrders(customer.getSweetOrders());
//		existingCustomer.setCart(customer.getCart());
		return customerRepository.save(existingCustomer);
	}
	
	/*
	 * @Author : Deepali Kosta
	 * @Description : This is used to delete customer
	 * @Param : It takes customer id as a parameter
	 * @Return : It returns nothing
	 * @Date Created : 24 Sept 2022
	 */
	@Override
	public void cancelCustomer(long customerId) {
		
		Optional<Customer> customer =customerRepository.findById(customerId);
		if(customer.isPresent())
		{
			customerRepository.deleteById(customerId);
		}
	}
	
	/*
	 * @Author : Deepali Kosta
	 * @Description : This is used to view all customers
	 * @Param : It takes customer as a parameter
	 * @Return : It returns customer list
	 * @Date Created : 24 Sept 2022
	 * 
	 */
	@Override
	public List<Customer> showAllCustomers() {
		
		return customerRepository.findAll();
	}
	
	/*
	 * @Author : Deepali Kosta
	 * @Description : This is used to view customer
	 * @Param : It takes customer id as a parameter
	 * @Return : It returns customer 
	 * @Date Created : 24 Sept 2022
	 * 
	 */
	@Override
	public Customer showAllcustomers(long customerId) {
		
		return customerRepository.findById(customerId).get();
	}

}



