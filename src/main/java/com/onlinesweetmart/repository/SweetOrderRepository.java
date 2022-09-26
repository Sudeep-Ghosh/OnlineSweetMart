package com.onlinesweetmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinesweetmart.entity.SweetOrder;

@Repository
public interface SweetOrderRepository extends JpaRepository<SweetOrder, Integer> {

}
