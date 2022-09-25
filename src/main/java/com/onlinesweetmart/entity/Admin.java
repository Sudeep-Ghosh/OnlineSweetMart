package com.onlinesweetmart.entity;

import java.util.Locale.Category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	
	@OneToOne
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="user")
	private User user;
	
	@OneToOne
	private Product product;
	
	@OneToOne
	private Category category;
	
	@OneToOne
	private Cart cart;
	
	private SweetItem item;
	
	
	
}
