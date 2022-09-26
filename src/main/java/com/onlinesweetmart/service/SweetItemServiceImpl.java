package com.onlinesweetmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.SweetItem;
import com.onlinesweetmart.exception.SweetItemNotFoundException;
import com.onlinesweetmart.repository.SweetItemRepository;

	/*
	 * 		@author: Ayush Patel
	 * 		@classDescription: Implementation class of SweetItemService interface
	 */

@Service
public class SweetItemServiceImpl implements SweetItemService {
	
	@Autowired
	private SweetItemRepository sweetItemRepository;
	
	@Override
	public SweetItem addSweetItem(SweetItem sweetItem) {
		
		return sweetItemRepository.save(sweetItem);
	}

	@Override
	public SweetItem updateSweetItem(SweetItem sweetItem) {
		
		SweetItem sweetItem2 = new SweetItem();
		
		if (sweetItemRepository.existsById(sweetItem.getOrderItemId())) {

			sweetItem2.setSweetOrder(sweetItem.getSweetOrder());
		}

		return sweetItem2;
	}

	@Override
	public SweetItem cancelSweetItem(int sweetItemId) {

		SweetItem sweetItem;
		
		if (sweetItemRepository.existsById(sweetItemId)) {
			sweetItem= sweetItemRepository.findById(sweetItemId).get();
			sweetItemRepository.deleteById(sweetItemId);
			return sweetItem;
		}

		else {
			throw new SweetItemNotFoundException("no sweet item with this id");
		}
		
		
	}

	@Override
	public List<SweetItem> showAllSweetItems() {
		
		List<SweetItem> listSweetItems = sweetItemRepository.findAll();
		if(listSweetItems.isEmpty()) {
			throw new SweetItemNotFoundException("no sweet item found" );
		}
		return listSweetItems;
	}

}
