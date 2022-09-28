package com.onlinesweetmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinesweetmart.entity.Category;
import com.onlinesweetmart.exception.EmptyCategoryListException;
import com.onlinesweetmart.exception.IdNotFoundException;
import com.onlinesweetmart.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping(value = "/category")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		Category fetchResultCategory = categoryService.addCategory(category);
		
		return new ResponseEntity<Category>(fetchResultCategory, HttpStatus.OK);
	}
	
	@PutMapping(value = "/category")
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws IdNotFoundException{
		Category fetchUpdatedResultCategory = categoryService.updateCategory(category);
		
		return new ResponseEntity<Category>(fetchUpdatedResultCategory, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/category/{id}")
	public ResponseEntity<Category> cancelCategory(@PathVariable(name = "id")
													Integer categoryId) throws IdNotFoundException{
		
		Category fetchCanceledResultCategory = categoryService.cancelCategory(categoryId);
		
		return new ResponseEntity<Category>(fetchCanceledResultCategory, HttpStatus.OK);
	}
	
	@GetMapping(value = "/category")
	public ResponseEntity<List<Category>> showAllCategories() throws EmptyCategoryListException{
		List<Category> fetchAllResultCategories = categoryService.showAllCategories();
		
		return new ResponseEntity<List<Category>>(fetchAllResultCategories, HttpStatus.OK);
	}
	
}
