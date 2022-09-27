package com.onlinesweetmart.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
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
@AllArgsConstructor
@NoArgsConstructor@Data
@Table(name="Customer")
public class Customer {
	
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
    
    @Column(name="UserName")
    private String userName;
    
	@OneToMany
	@JoinColumn
	private Set<SweetOrder> sweetOrders;
	
	@OneToMany
	@JoinColumn
	private List<SweetItem> sweetItems;
	
	@OneToOne
	private Cart cart;
	
}
