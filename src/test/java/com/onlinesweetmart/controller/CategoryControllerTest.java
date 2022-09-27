package com.onlinesweetmart.controller;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.onlinesweetmart.entity.Category;
import com.onlinesweetmart.service.CategoryService;

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CategoryService categoryService;

	private Category category;

	@BeforeEach
	void categoryControllerTestSetup() {
		category = Category.builder().categoryId(1).name("Regular Sweets").build();
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the addCategory post Controller using mocked data
	 * 
	 * @Param : it takes no parameter
	 * 
	 * @Return : it does not return anything
	 * 
	 * @Date Created : 27 Sept 2022
	 * 
	 */
	@Test
	@DisplayName("Test Category Controller module for addCategory controller")
	public void addCategoryControllerTestCase() throws Exception {
		Category inputCategory = Category.builder().name("Regular Sweets").build();

		Mockito.when(categoryService.addCategory(inputCategory)).thenReturn(category);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/category").contentType(MediaType.APPLICATION_JSON)
				.content("{\n" + "\t\"categoryName\":\"Regular Sweets\"\n" + "}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the showAllCategories get Controller using mocked
	 * data
	 * 
	 * @Param : it takes no parameter
	 * 
	 * @Return : it does not return anything
	 * 
	 * @Date Created : 27 Sept 2022
	 * 
	 */
	@Test
	@DisplayName("Test Category Controller module for showAllCategories controller")
	public void showAllCategoriesControllerTestCase() throws Exception {
		Mockito.when(categoryService.showAllCategories()).thenReturn(Collections.singletonList(category));

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/category").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the cancelCategory delete Controller using mocked
	 * data
	 * 
	 * @Param : it takes no parameter
	 * 
	 * @Return : it does not return anything
	 * 
	 * @Date Created : 27 Sept 2022
	 * 
	 */
	@Test
	@DisplayName("Test Category Controller module for cancelCategory controller")
	public void cancelCategoryControllerTestCase() throws Exception {
		Mockito.when(categoryService.cancelCategory(1)).thenReturn(category);

		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/category/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the updateCategory put Controller using mocked data
	 * 
	 * @Param : it takes no parameter
	 * 
	 * @Return : it does not return anything
	 * 
	 * @Date Created : 27 Sept 2022
	 * 
	 */
	@Test
	@DisplayName("Test Category Controller module for updateCategory controller")
	public void updateCategoryControllerTestCase() throws Exception {
		Category inputCategory = Category.builder().categoryId(1).name("Bangali Sweets").build();

		Category outputCategory = Category.builder().categoryId(1).name("Bangali Sweets").build();

		Mockito.when(categoryService.updateCategory(inputCategory)).thenReturn(outputCategory);

		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/category/").contentType(MediaType.APPLICATION_JSON)
				.content("{\n" + "\t\"categoryId\":\"1\",\n" + "\t\"name\":\"Bangali Sweets\"\n" + "}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
