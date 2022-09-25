package com.onlinesweetmart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String adminId;
	private String password;
	
	
	//@OnetoOne
	//private Customer customer;
	
	//@OnetoOne
	//@JoinColumn(name="user")
	//private User user;
	
	//@OnetoOne
	//private Product product;
	
	//@OnetoOne
	//private Category category;
	
	//@OnetoOne
	//private Cart cart;
	
	//private SweetItem item;
	
	
	
}
