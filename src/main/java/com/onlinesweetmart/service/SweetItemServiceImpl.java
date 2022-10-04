package com.onlinesweetmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.SweetItem;
import com.onlinesweetmart.exception.SweetItemNotFoundException;
import com.onlinesweetmart.repository.SweetItemRepository;

/*
 * 		@author: Ayush Patel
 * 		@description: Implementation class of SweetItemService interface
 * 		@createdDate:28 September 2022
 */

@Service
public class SweetItemServiceImpl implements SweetItemService {

	@Autowired
	private SweetItemRepository sweetItemRepository;

	/**
	 * method: addSweetItem() -This method will add SweetItem in its repository
	 * 
	 * @param: It will take SweetItem object as a parameter
	 * @return: It will return persisted entity in database
	 * 
	 */
	@Override
	public SweetItem addSweetItem(SweetItem sweetItem) {

		return sweetItemRepository.save(sweetItem);
	}

	/**
	 * method: updateSweetItem() - This method will update SweetItem in its
	 * repository
	 * 
	 * @param: It will take SweetItem object as a parameter
	 * @return: It will return updated entity in a database
	 * 
	 */
	@Override
	public SweetItem updateSweetItem(SweetItem sweetItem) {

		if (sweetItemRepository.existsById(sweetItem.getOrderItemId())) {

			sweetItemRepository.save(sweetItem);

		}

		return sweetItem;
	}

	/**
	 * method: cancelSweetItem() - this method will delete SweetItem from its
	 * database
	 * 
	 * @param: It will take integer value as a parameter
	 * @return: It will return deleted SweetItem object from a database
	 * 
	 */
	@Override
	public SweetItem cancelSweetItem(int sweetItemId) {

		SweetItem sweetItem;

		if (sweetItemRepository.existsById(sweetItemId)) {
			sweetItem = sweetItemRepository.findById(sweetItemId).get();
			sweetItemRepository.deleteById(sweetItemId);
			return sweetItem;
		}

		else {
			throw new SweetItemNotFoundException("no sweet item with this id");
		}

	}

	/**
	 * method: showAllSweetItems() - This method will show all SweetItem present in
	 * user database
	 * 
	 * @param: It will not take any parameter
	 * @return: It will return list of entities present in a SweetItem database
	 * 
	 */
	@Override
	public List<SweetItem> showAllSweetItems() {

		List<SweetItem> listSweetItems = sweetItemRepository.findAll();
		if (listSweetItems.isEmpty()) {
			throw new SweetItemNotFoundException("no sweet item found");
		}
		return listSweetItems;
	}

}
