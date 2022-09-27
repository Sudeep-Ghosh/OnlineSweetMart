package com.onlinesweetmart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;


@Entity @Data
public class SweetItem {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int orderItemId;
	
	@OneToOne
	private Product product;
	
	@ManyToOne
	private SweetOrder sweetOrder;

}
