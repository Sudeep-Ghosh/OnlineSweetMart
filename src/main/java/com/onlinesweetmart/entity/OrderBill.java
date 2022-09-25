package com.onlinesweetmart.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order_bill")
public class OrderBill {
	@Id
	private int orderBillId;
	private LocalDate localDate;
	private float totalCost;
	//private List<SweetOrder> listSweetOrder;
}
