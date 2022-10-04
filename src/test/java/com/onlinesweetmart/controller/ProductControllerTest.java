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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlinesweetmart.entity.Product;
import com.onlinesweetmart.exception.IdNotFoundException;
import com.onlinesweetmart.service.ProductService;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	private Product product;

	@BeforeEach
	void productControllerTestSetup() {
		//Category category = Category.builder().categoryId(1).name("Regular Sweets").build();
		product = Product.builder().productId(12).name("Barfi").photoPath("www.google.com").price(150.44)
				.description("best dessert").available(true).build();
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the addProduct post Controller using mocked data
	 * 
	 * @Param : it takes no parameter
	 * 
	 * @Return : it does not return anything
	 * 
	 * @Date Created : 27 Sept 2022
	 * 
	 */
	@Test
	@DisplayName("Test Product Controller module for addProduct controller")
	public void addProductControllerTestCase() throws Exception {
	//	Category inputCategory = Category.builder().categoryId(1).name("Regular Sweets").build();
		Product inputProduct = Product.builder().productId(12).name("Barfi").photoPath("www.google.com").price(150.44)
				.description("best dessert").available(true).build();

		Mockito.when(productService.addProduct(inputProduct)).thenReturn(product);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/product").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(inputProduct)))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the showAllProducts get Controller using mocked
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
	@DisplayName("Test Product Controller module for showAllProducts controller")
	public void showAllProductsControllerTestCase() throws Exception {
		Mockito.when(productService.showAllProducts()).thenReturn(Collections.singletonList(product));

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the cancelProduct delete Controller using mocked
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
	@DisplayName("Test Product Controller module for cancelProduct controller")
	public void cancelProductControllerTestCase() throws Exception {
		Mockito.when(productService.cancelProduct(12)).thenReturn(product);

		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/product/12").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the updateProduct put Controller using mocked data
	 * 
	 * @Param : it takes no parameter
	 * 
	 * @Return : it does not return anything
	 * 
	 * @Date Created : 27 Sept 2022
	 * 
	 */
	@Test
	@DisplayName("Test Product Controller module for updateProduct controller")
	public void updateProductControllerTestCase() throws Exception {
		//Category inputCategory = Category.builder().categoryId(6).name("Gold Wrapper Sweets").build();
		Product inputProduct = Product.builder().productId(32).name("Muffins").photoPath("www.google.com").price(650.44)
				.description("Light weight dessert").available(true).build();

		Product outputProduct = inputProduct;
		Mockito.when(productService.updateProduct(product)).thenReturn(outputProduct);

		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/product").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(inputProduct)))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the showAllProductsById get Controller using mocked
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
	@DisplayName("Test Product Controller module for showAllProductsById controller")
	public void showProductByIdProductControllerTestCase() throws Exception, IdNotFoundException {
		Mockito.when(productService.showAllProducts(32)).thenReturn(product);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/product/32").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
