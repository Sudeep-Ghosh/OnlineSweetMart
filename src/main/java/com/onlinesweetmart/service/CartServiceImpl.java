package com.onlinesweetmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.Cart;
import com.onlinesweetmart.exception.IdNotFoundException;
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
	
	
	/*
	 * @Author : ishika
	 * @description : this is used to show all the carts
	 * @Param : It takes cart as a parameter
	 * @Return : It returns lsit of carts
	 * @CreatedDate: 24 september 2022
	 * 
	 */
	
	
	@Override
	public List<Cart> showAllCarts(){
		
		return (List<Cart>) cartRepository.findAll();
	}
	
	
	/*
	 * @Author : ishika
	 * @description : this is used to update a cart
	 * @Param : It takes cart as a parameter
	 * @Return : It returns the updated cart
	 * @CreatedDate: 24 september 2022
	 * 
	 */
	
	
	@Override
	public Cart updateCart(Cart cart) {
		
		Cart existingCart = cartRepository.findById(cart.getCartId()).orElse(null);
		existingCart.setGrandTotal(cart.getGrandTotal());
		existingCart.setProductCount(cart.getProductCount());
		existingCart.setTotal(cart.getTotal());
		return cartRepository.save(existingCart);
	}
	
	
	/*
	 * @Author : ishika
	 * @description : this is used to cancel a cart
	 * @Param : It takes cartId as a parameter
	 * @Return : It returns canceled cart
	 * @CreatedDate: 24 september 2022
	 * 
	 */
	
	
	@Override
	public Cart cancelCart(int cartId) {
		
		Cart cart;
		if(cartRepository.existsById(cartId))
		{
			cart = cartRepository.findById(cartId).get();
			cartRepository.deleteById(cartId);
			return cart;
		}
		else {
			throw new IdNotFoundException("Cart not found of given Id") ; 
		}
	}
	
	
	/*
	 * @Author : ishika
	 * @description : this is used to show cart of given id
	 * @Param : It takes cartId as a parameter
	 * @Return : It returns cart with the given id
	 * @CreatedDate: 24 september 2022
	 * 
	 */

	@Override
	public Cart showCartsById(int cartId) {
		// TODO Auto-generated method stub
		return cartRepository.findById(cartId).get();
	}

}
