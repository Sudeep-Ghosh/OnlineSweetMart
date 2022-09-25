package com.onlinesweetmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinesweetmart.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
