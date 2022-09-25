package com.onlinesweetmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinesweetmart.entity.OrderBill;

@Repository
public interface OrderBillRepository extends JpaRepository<OrderBill, Integer> {

}
