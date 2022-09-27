package com.onlinesweetmart.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.onlinesweetmart.entity.Category;
import com.onlinesweetmart.exception.IdNotFoundException;
import com.onlinesweetmart.repository.CategoryRepository;

@SpringBootTest
public class CategoryServiceTest {

	@Autowired
	private CategoryService categoryService;

	@MockBean
	private CategoryRepository categoryRepository;

	@BeforeEach
	void categoryInitializer() {
		Category category = Category.builder().name("Rasmalai").build();

		Mockito.when(categoryRepository.save(category)).thenReturn(category);
		Mockito.when(categoryRepository.findAll()).thenReturn(Collections.singletonList(category));
	}

	@BeforeEach
	void cancelCategoryInitializer() {
		Optional<Category> category = Optional.ofNullable(Category.builder().categoryId(1).name("Rasmalai").build());

		Mockito.when(categoryRepository.findById(category.get().getCategoryId())).thenReturn(category);
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the addCategory service using mocked data
	 * 
	 * @Param : it takes no parameter
	 * 
	 * @Return : it does not return anything
	 * 
	 * @Date Created : 27 Sept 2022
	 * 
	 */
	@Test
	@DisplayName("Test Category service addCategory based on valid Category data")
	public void addCategoryTestCase() {
		Category mockCategory = Category.builder().name("Rasmalai").build();
		Category fetchCategory = categoryService.addCategory(mockCategory);

		assertEquals(fetchCategory, mockCategory);
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the showAllCategories service using mocked data
	 * 
	 * @Param : it takes no parameter
	 * 
	 * @Return : it does not return anything
	 * 
	 * @Date Created : 27 Sept 2022
	 * 
	 */
	@Test
	@DisplayName("Test Category service showAllCategories fetched categories based on the service call")
	public void showAllCategoriesTestCase() {
		List<Category> fetchCategories = categoryService.showAllCategories();
		Category mockCategory = Category.builder().name("Rasmalai").build();

		assertEquals(fetchCategories, Collections.singletonList(mockCategory));
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the cancelCategory service using mocked data
	 * 
	 * @Param : it takes no parameter
	 * 
	 * @Return : it does not return anything
	 * 
	 * @Date Created : 27 Sept 2022
	 * 
	 */
	@Test
	@DisplayName("Test Category service cancelCategory based on the service call")
	public void cancelCategoryTestCase() throws IdNotFoundException {
		Category mockCategory = Category.builder().categoryId(1).name("Rasmalai").build();
		Category fetchCategory = categoryService.cancelCategory(mockCategory.getCategoryId());

		assertEquals(fetchCategory, mockCategory);
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the updateCategory service using mocked data
	 * 
	 * @Param : it takes no parameter
	 * 
	 * @Return : it does not return anything
	 * 
	 * @Date Created : 27 Sept 2022
	 * 
	 */
	@Test
	@DisplayName("Test Category service updateCategory service based on the service call")
	public void updateCategoryTestCase() throws IdNotFoundException {
		Category mockCategory = Category.builder().categoryId(1).name("Jalebi").build();
		Category fetchCategory = categoryService.updateCategory(mockCategory);

		assertEquals(fetchCategory, mockCategory);
	}

}
