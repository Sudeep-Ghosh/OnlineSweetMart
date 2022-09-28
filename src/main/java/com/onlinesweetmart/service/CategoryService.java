package com.onlinesweetmart.service;

import java.util.List;

import com.onlinesweetmart.entity.Category;
import com.onlinesweetmart.exception.EmptyCategoryListException;
import com.onlinesweetmart.exception.IdNotFoundException;

public interface CategoryService {

	public Category addCategory(Category category);

	public Category updateCategory(Category category) throws IdNotFoundException;

	public Category cancelCategory(Integer categoryId) throws IdNotFoundException;

	public List<Category> showAllCategories() throws EmptyCategoryListException;

}
