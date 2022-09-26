package com.onlinesweetmart.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;


@Entity @Data
public class SweetItem {
	
	@Id
	private int orderItemId;
	
	private Product product;
	
	@ManyToOne
	private SweetOrder sweetOrder;

}
