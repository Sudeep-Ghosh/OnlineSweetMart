package com.onlinesweetmart.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private double grandTotal;
	private List<Product> listProduct;
	private int productCount;
	private double total;
	
	
	@OneToOne
	private Admin admin;
	
	@OneToOne
	private Customer customer;
	
	
	public Cart(double grandTotal, List<Product> listProduct, int cartId, int productCount, double total) {
		super();
		this.grandTotal = grandTotal;
		this.listProduct = listProduct;
		this.cartId = cartId;
		this.productCount = productCount;
		this.total = total;
	}


	public double getGrandTotal() {
		return grandTotal;
	}


	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}


	public List<Product> getListProduct() {
		return listProduct;
	}


	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public int getProductCount() {
		return productCount;
	}


	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	

}
