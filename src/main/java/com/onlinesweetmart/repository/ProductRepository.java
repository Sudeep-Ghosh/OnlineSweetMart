package com.onlinesweetmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinesweetmart.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
}
