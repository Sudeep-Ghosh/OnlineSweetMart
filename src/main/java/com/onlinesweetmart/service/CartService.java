package com.onlinesweetmart.service;

import java.util.List;

import com.onlinesweetmart.entity.Cart;


public interface CartService {
	
	public Cart addCart(Cart cart);
	public Cart updateCart(Cart cart);
	public Cart cancelCart(int cartId);
	public List<Cart> showAllCarts();
	public Cart showCartsById(int cartId);

}
