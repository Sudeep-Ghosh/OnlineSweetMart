package com.onlinesweetmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinesweetmart.entity.Product;
import com.onlinesweetmart.exception.EmptyProductListException;
import com.onlinesweetmart.exception.IdNotFoundException;
import com.onlinesweetmart.exception.ProductNotFoundException;
import com.onlinesweetmart.service.ProductService;

@RestController
@RequestMapping(value = "/api/v1")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	 
	@PostMapping(value = "/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		Product fetchResultProduct = productService.addProduct(product);
		
		return new ResponseEntity<Product>(fetchResultProduct, HttpStatus.OK);
	}
	
	@PutMapping(value = "/product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws IdNotFoundException{
		Product fetchUpdatedResultProduct = productService.updateProduct(product);
		
		return new ResponseEntity<Product>(fetchUpdatedResultProduct, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/product/{id}")
	public ResponseEntity<Product> cancelProduct(@PathVariable(name = "id") 
												Integer productId) throws IdNotFoundException{
		Product fetchCanceledResultProduct = productService.cancelProduct(productId);
		
		return new ResponseEntity<Product>(fetchCanceledResultProduct, HttpStatus.OK);
	}
	
	@GetMapping(value = "/product/{id}")
	public ResponseEntity<Product> showAllProducts(@PathVariable(name = "id") 
														Integer productId) throws ProductNotFoundException{
		Product fetchAllResultProducts = productService.showAllProducts(productId);
		
		return new ResponseEntity<Product>(fetchAllResultProducts, HttpStatus.OK);
	}
	
	@GetMapping(value = "/product")
		public ResponseEntity<List<Product>> showAllProducts() throws EmptyProductListException{
			List<Product> fetchAllResultProducts = productService.showAllProducts();
			
			return new ResponseEntity<List<Product>>(fetchAllResultProducts, HttpStatus.OK);
		}	
}
