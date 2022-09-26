package com.onlinesweetmart.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity @Data
public class SweetItem {
	
	@Id
	private int orderItemId;
	
	private Product product;
	
	@ManyToOne
	private SweetOrder sweetOrder;

}
