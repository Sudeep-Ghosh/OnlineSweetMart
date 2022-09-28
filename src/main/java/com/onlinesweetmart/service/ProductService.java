package com.onlinesweetmart.service;

import java.util.List;

import com.onlinesweetmart.entity.Product;
import com.onlinesweetmart.exception.EmptyProductListException;
import com.onlinesweetmart.exception.IdNotFoundException;
import com.onlinesweetmart.exception.ProductNotFoundException;

public interface ProductService {
	public Product addProduct(Product product);

	public Product updateProduct(Product product) throws IdNotFoundException;

	public Product cancelProduct(Integer productId) throws IdNotFoundException;

	public Product showAllProducts(Integer productId) throws ProductNotFoundException;

	public List<Product> showAllProducts() throws EmptyProductListException;
}
