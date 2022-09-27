package com.onlinesweetmart.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity @Data
public class SweetOrder {
	
	/*
	 * Class User, Map<Product,Long> are kept commented till further connectivity.
	 */
	
	@Id
	private int sweetOrderId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany
	@JoinColumn(name = "listItem_id")
	private List<SweetItem> listItems;
	
	private LocalDate createdDate;
	
	
	//private Map<Product, Long> groupedProducts;
	

}
