package com.onlinesweetmart.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @AllArgsConstructor @NoArgsConstructor
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private double grandTotal;
	
	@OneToMany
	@JoinColumn
	private List<Product> listProduct;
	private int productCount;
	private double total;
	
	
	//@OneToOne
	//private Admin admin;
	
	@OneToOne
	private Customer customer;
	

	

}
