package com.onlinesweetmart.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.Category;
import com.onlinesweetmart.exception.IdNotFoundException;
import com.onlinesweetmart.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	/*
	 * @Author : Hasan Khan S
	 * @Description : this service is used to add a new category to the database
	 * @Param : it takes category as a parameter
	 * @Return : it returns the saved category
	 * @Date Created : 24 Sept 2022
	 * 
	 * */

	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	
	/*
	 * @Author : Hasan Khan S
	 * @Description : this service is used to update present category to the database
	 * @Param : it takes category as a parameter
	 * @Return : it returns the updated/saved category
	 * @Date Created : 24 Sept 2022
	 * 
	 * */

	@Override
	public Category updateCategory(Category category) throws IdNotFoundException {
		Category fetchCategory = categoryRepository.findById(category.getCategoryId()).get();

		if (Objects.nonNull(category.getCategoryId()) && !"".equalsIgnoreCase(category.getName())) {
			fetchCategory.setName(category.getName());
			categoryRepository.save(fetchCategory);
			return fetchCategory;
		}
		else {
			throw new IdNotFoundException("Category with category ID: "+category.getCategoryId()+" not available");
		}
	}
	
	
	/*
	 * @Author : Hasan Khan S
	 * @Description : this service is used to delete present category to the database, else throw exception
	 * @Param : it takes categoryId as a parameter
	 * @Return : it returns the deleted category
	 * @Date Created : 24 Sept 2022
	 * 
	 * */
	
	@Override
	public Category cancelCategory(Integer categoryId) throws IdNotFoundException {
		Optional<Category> fetchCategory = categoryRepository.findById(categoryId);
		
		if(fetchCategory.isPresent()) {
			Category tempCategory = fetchCategory.get();
			categoryRepository.deleteById(categoryId);
			return tempCategory;
		}else {
			throw new IdNotFoundException("Category with category ID: "+categoryId+" not available");
		}
	}

	
	/*
	 * @Author : Hasan Khan S
	 * @Description : this service is used to fetch all the present categories in the database
	 * @Param : it takes no parameter
	 * @Return : it returns the List<category>
	 * @Date Created : 24 Sept 2022
	 * 
	 * */
	
	@Override
	public List<Category> showAllCategories() {
		return categoryRepository.findAll();
	}

}
