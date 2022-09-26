package com.onlinesweetmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinesweetmart.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{



}
