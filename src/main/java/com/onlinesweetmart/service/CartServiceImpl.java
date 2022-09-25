package com.onlinesweetmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.Cart;
import com.onlinesweetmart.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartRepository cartRepository;
	
	/*
	 * @Author : ishika
	 * @description : this is used to add new cart
	 * @Param : It takes cart as a parameter
	 * @Return : It returns cart
	 * @CreatedDate: 24 september 2022
	 * 
	 */
	

	@Override
	public Cart addCart(Cart cart) {
		
		return cartRepository.save(cart);
	}
	
	
	
	
	@Override
	public List<Cart> showAllCarts(){
		
		return (List<Cart>) cartRepository.findAll();
	}
	
	
	
	
	
	@Override
	public Cart updateCart(Cart cart) {
		
		Cart existingCart = cartRepository.findById(cart.getCartId()).orElse(null);
		existingCart.setGrandTotal(cart.getGrandTotal());
		existingCart.setProductCount(cart.getProductCount());
		existingCart.setTotal(cart.getTotal());
		return cartRepository.save(existingCart);
	}
	
	
	
	
	@Override
	public void cancelCart(int cartId) {
		
		Optional<Cart> cart = cartRepository.findById(cartId);
		if(cart.isPresent()) 
		{
			cartRepository.deleteById(cartId);
		}
	}
	
	


	@Override
	public Cart showCartsById(int cartId) {
		// TODO Auto-generated method stub
		return cartRepository.findById(cartId).get();
	}

}
