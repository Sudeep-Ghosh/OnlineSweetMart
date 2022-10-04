package com.onlinesweetmart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product")
public class Product {
	@Id
	@SequenceGenerator(
			name = "product_sequence",
			sequenceName = "product_sequence",
			allocationSize = 5
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "product_sequence"
			)
	private Integer productId;
	private String name;
	private String photoPath;
	private Double price;
	private String description;
	
	@Builder.Default
	private Boolean available = true;
	
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
}







