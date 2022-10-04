package com.onlinesweetmart.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinesweetmart.entity.Product;
import com.onlinesweetmart.exception.EmptyProductListException;
import com.onlinesweetmart.exception.IdNotFoundException;
import com.onlinesweetmart.exception.ProductNotFoundException;
import com.onlinesweetmart.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	/*
	 * @Author : Hasan Khan S
	 * @Description : this service is used to add a product to the database
	 * @Param : it takes product as a parameter
	 * @Return : it returns the product added
	 * @Date Created : 24 Sept 2022
	 * 
	 * */

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	
	/*
	 * @Author : Hasan Khan S
	 * @Description : this service is used to update an existing product to the database
	 * @Param : it takes product as a parameter
	 * @Return : it returns the updated product added
	 * @Date Created : 24 Sept 2022
	 * 
	 * */
	
	@Override
	public Product updateProduct(Product product) throws IdNotFoundException {
		Optional<Product> fetchProduct = productRepository.findById(product.getProductId());

		if (fetchProduct.isPresent()) {
			if (Objects.nonNull(product.getName()) && !"".equalsIgnoreCase(product.getName())) {
				fetchProduct.get().setName(product.getName());
			}

			if (Objects.nonNull(product.getPhotoPath()) && !"".equalsIgnoreCase(product.getPhotoPath())) {
				fetchProduct.get().setPhotoPath(product.getPhotoPath());
			}

			if (Objects.nonNull(product.getPrice())) {
				fetchProduct.get().setPrice(product.getPrice());
			}
			
			if (Objects.nonNull(product.getDescription())&& !"".equalsIgnoreCase(product.getDescription())) {
				fetchProduct.get().setDescription(product.getDescription());
			}
			
			if (Objects.nonNull(product.getAvailable())) {
				fetchProduct.get().setAvailable(product.getAvailable());
			}
		
			productRepository.save(fetchProduct.get());
			return fetchProduct.get();
		}

		else {
			throw new IdNotFoundException("Product with product ID: " + product.getProductId() + " not available.");
		}
	}
	
	
	/*
	 * @Author : Hasan Khan S
	 * @Description : this service is used to delete a product from the database
	 * @Param : it takes productId as a parameter
	 * @Return : it returns the deleted product
	 * @Date Created : 24 Sept 2022
	 * 
	 * */
	
	@Override
	public Product cancelProduct(Integer productId) throws IdNotFoundException {
		Optional<Product> fetchProduct = productRepository.findById(productId);

		if (fetchProduct.isPresent()) {
			Product tempProduct = fetchProduct.get();
			productRepository.deleteById(productId);
			return tempProduct;
		} else {
			throw new IdNotFoundException("Product with product ID: " + productId + " not available.");
		}
	}
	
	
	/*
	 * @Author : Hasan Khan S
	 * @Description : this service is used to fetch all the available products from the database
	 * @Param : it takes productId as a parameter
	 * @Return : it returns the respected product
	 * @Date Created : 24 Sept 2022
	 * 
	 * */
	
	@Override
	public Product showAllProducts(Integer productId) throws ProductNotFoundException {
		Optional<Product> fetchAvailableProduct = productRepository.findById(productId);
		if(fetchAvailableProduct.isPresent()) {
			return fetchAvailableProduct.get();
		}
		else {
			throw new ProductNotFoundException("Product with product ID: " + productId + " not available.");
		}
	}
	
	
	/*
	 * @Author : Hasan Khan S
	 * @Description : this service is used to fetch all the available products from the database
	 * @Param : it takes no parameter
	 * @Return : it returns the List<products>
	 * @Date Created : 24 Sept 2022
	 * 
	 * */
	
	@Override
	public List<Product> showAllProducts() throws EmptyProductListException {
		List<Product> fetchProducts = productRepository.findAll();
		
		if(fetchProducts.isEmpty()) {
			throw new EmptyProductListException("No products found in the product list");
		}
		return fetchProducts;
	}

}
