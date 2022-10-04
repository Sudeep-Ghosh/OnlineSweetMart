package com.onlinesweetmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.Customer;
import com.onlinesweetmart.exception.EmptyCustomerListException;
import com.onlinesweetmart.exception.IdNotFoundException;
import com.onlinesweetmart.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	/*
	 * @Author : Deepali Kosta
	 * 
	 * @Description : This is used to add customer
	 * 
	 * @Param : It takes customer as a parameter
	 * 
	 * @Return : It returns customer
	 * 
	 * @Date Created : 24 Sept 2022
	 */
	@Override
	public Customer addCustomer(Customer customer) {

		return customerRepository.save(customer);
	}

	/*
	 * @Author : Deepali Kosta
	 * 
	 * @Description : This is used to update customer
	 * 
	 * @Param : It takes customer as a parameter
	 * 
	 * @Return : It returns customer
	 * 
	 * @Date Created : 24 Sept 2022
	 */
	@Override
	public Customer updateCustomer(Customer customer) {

		Customer existingCustomer = customerRepository.findById(customer.getUserId()).orElse(null);
		if (existingCustomer == null) {
			throw new IdNotFoundException("Cutomer has not found to update details");
		} else {
			existingCustomer.setUserName(customer.getUserName());
			existingCustomer.setSweetOrders(customer.getSweetOrders());
			existingCustomer.setCart(customer.getCart());
			return customerRepository.save(existingCustomer);
		}
	}

	/*
	 * @Author : Deepali Kosta
	 * 
	 * @Description : This is used to delete customer
	 * 
	 * @Param : It takes customer id as a parameter
	 * 
	 * @Return : It returns nothing
	 * 
	 * @Date Created : 24 Sept 2022
	 */
	@Override
	public Customer cancelCustomer(long customerId) throws IdNotFoundException {

		Optional<Customer> customer = customerRepository.findById(customerId);
		if (customer.isPresent()) {
			Customer existingCustomer = customer.get();
			customerRepository.deleteById(customerId);
			return existingCustomer;
		} else {
			throw new IdNotFoundException("Cutomer Id " + customerId + " is not found to be delete");
		}
	}

	/*
	 * @Author : Deepali Kosta
	 * 
	 * @Description : This is used to view all customers
	 * 
	 * @Param : It takes customer as a parameter
	 * 
	 * @Return : It returns customer list
	 * 
	 * @Date Created : 24 Sept 2022
	 * 
	 */
	@Override
	public List<Customer> showAllCustomers() throws EmptyCustomerListException {
        List<Customer> customers=customerRepository.findAll();
        if(customers.isEmpty()) {
        	throw new EmptyCustomerListException("There is no customer to show");
        }
		return customers;
	}

	/*
	 * @Author : Deepali Kosta
	 * 
	 * @Description : This is used to view customer
	 * 
	 * @Param : It takes customer id as a parameter
	 * 
	 * @Return : It returns customer
	 * 
	 * @Date Created : 24 Sept 2022
	 * 
	 */
	@Override
	public Customer showAllcustomers(long customerId) {

		Optional<Customer> customer = customerRepository.findById(customerId);
		if (customer.isPresent()) {
			return customer.get();
		} else {
			throw new IdNotFoundException("Cutomer Id " + customerId + " is not present");
		}
	}

}
