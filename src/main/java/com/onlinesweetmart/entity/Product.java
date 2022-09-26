package com.onlinesweetmart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	@OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "categoryId"
    )
	private Category category;
	
}






