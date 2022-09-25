package com.onlinesweetmart.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @AllArgsConstructor@NoArgsConstructor@Data
public class Customer {
	
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
    
    @Column(length = 10,nullable = false)
    private String username;
    
	@OneToMany
	private Set<SweetOrder> sweetOrders;
	
	@OneToMany
	private List<SweetItem> sweetItems;
	
	@OneToOne
	private Cart cart;
	
}
