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

import com.onlinesweetmart.entity.Cart;
import com.onlinesweetmart.service.CartService;

@RestController
@RequestMapping("/api/v1")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping(value="cart")
	ResponseEntity<Cart> addCart(@RequestBody Cart cart)
	{
		Cart cart2 = cartService.addCart(cart);
		
		return new ResponseEntity<Cart>(cart2, HttpStatus.OK);
	}
	
	@GetMapping(value="cart")
	ResponseEntity<List<Cart>> showAllCart()
	{
		List<Cart> carts = cartService.showAllCarts();
		
		return new ResponseEntity<List<Cart>>(carts, HttpStatus.OK);
	}
	
	
	@PutMapping(value="cart")
	ResponseEntity<Cart> updateCart(@RequestBody Cart cart)
	{
		Cart updt = cartService.updateCart(cart);
		
		return new ResponseEntity<Cart>(updt, HttpStatus.OK);
	}
	
	@DeleteMapping(value="cart/{id}")
	ResponseEntity<String> cancelCart(@PathVariable int id)
	{
		cartService.cancelCart(id);
		
		return new ResponseEntity<String>("cart canceled", HttpStatus.OK);
	}
	




}
