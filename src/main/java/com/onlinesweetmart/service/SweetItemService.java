package com.onlinesweetmart.service;

import java.util.List;

import com.onlinesweetmart.entity.SweetItem;

public interface SweetItemService {

	public SweetItem addSweetItem(SweetItem sweetItem);
	
	public SweetItem updateSweetItem(SweetItem sweetItem);
	
	public SweetItem cancelSweetItem(int sweetItemId);
	
	public List<SweetItem> showAllSweetItems();
}
