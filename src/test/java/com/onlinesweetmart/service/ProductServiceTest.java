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

import com.onlinesweetmart.entity.Product;
import com.onlinesweetmart.exception.EmptyProductListException;
import com.onlinesweetmart.exception.IdNotFoundException;
import com.onlinesweetmart.exception.ProductNotFoundException;
import com.onlinesweetmart.repository.ProductRepository;

@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@MockBean
	private ProductRepository productRepository;

	@BeforeEach
	void productInitializerSetup() {
		//Category category = Category.builder().categoryId(1).name("Regular Sweets").build();

		Product product = Product.builder().productId(12).name("Barfi").photoPath("www.google.com").price(150.44)
				.description("best dessert").available(true).build();

		Mockito.when(productRepository.save(product)).thenReturn(product);
		Mockito.when(productRepository.findAll()).thenReturn(Collections.singletonList(product));
	}

	@BeforeEach
	void productFetchByIdSetup() {
	//	Category category = Category.builder().categoryId(5).name("Gold wrapper Sweets").build();

		Optional<Product> product = Optional
				.ofNullable(Product.builder().productId(15).name("Black forest").photoPath("www.google.com")
						.price(550.44).description("Brown chocholate cake").available(true).build());

		Mockito.when(productRepository.findById(product.get().getProductId())).thenReturn(product);
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the addProduct service using mocked data
	 * 
	 * @Param : it takes no parameter
	 * 
	 * @Return : it does not return anything
	 * 
	 * @Date Created : 27 Sept 2022
	 * 
	 */
	@Test
	@DisplayName("Test Product Service to add product based on valid Product data")
	public void addProductTestCase() {
		//Category category = Category.builder().categoryId(1).name("Regular Sweets").build();

		Product product = Product.builder().productId(12).name("Barfi").photoPath("www.google.com").price(150.44)
				.description("best dessert").available(true).build();

		Product fetchProduct = productService.addProduct(product);

		assertEquals(fetchProduct, product);
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the showAllProducts service using mocked data
	 * 
	 * @Param : it takes no parameter
	 * 
	 * @Return : it does not return anything
	 * 
	 * @Date Created : 27 Sept 2022
	 * 
	 */
	@Test
	@DisplayName("Test Product Service to fetch all products from DB")
	public void showAllProductsTestCase() throws EmptyProductListException {
	//	Category category = Category.builder().categoryId(1).name("Regular Sweets").build();

		Product product = Product.builder().productId(12).name("Barfi").photoPath("www.google.com").price(150.44)
				.description("best dessert").available(true).build();

		List<Product> fetchProduct = productService.showAllProducts();

		assertEquals(fetchProduct, Collections.singletonList(product));
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the showAllProductById service using mocked data
	 * 
	 * @Param : it takes no parameter
	 * 
	 * @Return : it does not return anything
	 * 
	 * @Date Created : 27 Sept 2022
	 * 
	 */
	@Test
	@DisplayName("Test Product Service to fetch respective data on valid product data")
	public void showProductByIdTestCase() throws ProductNotFoundException {
		//Category category = Category.builder().categoryId(5).name("Gold wrapper Sweets").build();

		Product product = Product.builder().productId(15).name("Black forest").photoPath("www.google.com").price(550.44)
				.description("Brown chocholate cake").available(true).build();

		Product fetchProduct = productService.showAllProducts(product.getProductId());

		assertEquals(fetchProduct, product);
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the udpateProduct service using mocked data
	 * 
	 * @Param : it takes no parameter
	 * 
	 * @Return : it does not return anything
	 * 
	 * @Date Created : 27 Sept 2022
	 * 
	 */
	@Test
	@DisplayName("Test Product Service to fetch respective data and update it")
	public void updateProductTestCase() throws IdNotFoundException {
		//Category category = Category.builder().categoryId(5).name("Gold wrapper Sweets").build();

		Product product = Product.builder().productId(15).name("Black forest").photoPath("www.google.com").price(550.44)
				.description("Brown chocholate cake").available(true).build();

		Product fetchProduct = productService.updateProduct(product);

		assertEquals(fetchProduct, product);
	}

	/*
	 * @Author : Hasan Khan S
	 * 
	 * @Description : this tests the cancelProduct service using mocked data
	 * 
	 * @Param : it takes no parameter
	 * 
	 * @Return : it does not return anything
	 * 
	 * @Date Created : 27 Sept 2022
	 * 
	 */
	@Test
	@DisplayName("Test Product Service to perform cancel service")
	public void cancelProductTestCase() throws IdNotFoundException {
		//Category category = Category.builder().categoryId(5).name("Gold wrapper Sweets").build();

		Product product = Product.builder().productId(15).name("Black forest").photoPath("www.google.com").price(550.44)
				.description("Brown chocholate cake").available(true).build();

		Product fetchCanceledProduct = productService.cancelProduct(product.getProductId());

		assertEquals(fetchCanceledProduct, product);
	}

}
