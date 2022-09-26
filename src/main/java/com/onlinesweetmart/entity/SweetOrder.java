package com.onlinesweetmart.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity @Data
public class SweetOrder {
	
	/*
	 * Class User, Map<Product,Long> are kept commented till further connectivity.
	 */
	
	@Id
	private int sweetOrderId;
	
	private User user;
	
	@OneToMany
	private List<SweetItem> listItems;
	
	private LocalDate createdDate;
	
	private Map<Product, Long> groupedProducts;
	

}
