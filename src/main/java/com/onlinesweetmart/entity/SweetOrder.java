package com.onlinesweetmart.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity @Data
public class SweetOrder {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sweetOrderId;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private Customer customer;
	
	@OneToMany
	@JoinColumn
	private List<SweetItem> listItems;
	
	private LocalDate createdDate;

	//private Map<Product, Long> groupedProducts;
	

}
