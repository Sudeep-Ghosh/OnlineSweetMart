package com.onlinesweetmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.Cart;
import com.onlinesweetmart.exception.CartNotFoundException;
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
		
		List<Cart> listCart = cartRepository.findAll();
		if(listCart.isEmpty()) {
			throw new CartNotFoundException("no cart is found");
		}
		return listCart;
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
		
		Cart existingCart = new Cart();
		if(cartRepository.existsById(cart.getCartId())) {
			existingCart.setCartId(cart.getCartId());
		existingCart.setGrandTotal(cart.getGrandTotal());
		existingCart.setListProduct(cart.getListProduct());
		existingCart.setProductCount(cart.getProductCount());
		existingCart.setTotal(cart.getTotal());
		
		return cartRepository.save(existingCart);
		}
		else {
			throw new IdNotFoundException("The given Id is not present");
		}
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
		Optional<Cart> cart = cartRepository.findById(cartId);
		if (cart.isPresent()) {
			return cart.get();
		} else {
			throw new IdNotFoundException("The given order bill id: " + cartId + " is not present");
		}
	}

}
