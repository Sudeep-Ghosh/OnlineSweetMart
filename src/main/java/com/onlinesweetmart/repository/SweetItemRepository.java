package com.onlinesweetmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinesweetmart.entity.SweetItem;

@Repository
public interface SweetItemRepository extends JpaRepository<SweetItem, Integer>{

}
