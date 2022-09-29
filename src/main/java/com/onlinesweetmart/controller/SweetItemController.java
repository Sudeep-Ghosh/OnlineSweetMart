package com.onlinesweetmart.controller;

import java.util.List;

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

import com.onlinesweetmart.entity.SweetItem;
import com.onlinesweetmart.service.SweetItemService;

@RestController
@RequestMapping("/api/v1")
public class SweetItemController {

	@Autowired
	private SweetItemService sweetItemService;
	
	@PostMapping("/sweetitem")
	public ResponseEntity<SweetItem>  addSweetItem(@RequestBody SweetItem sweetItem) {
	
		return new ResponseEntity<SweetItem>(sweetItemService.addSweetItem(sweetItem),HttpStatus.CREATED);
	}
	
	@PutMapping("/sweetitem")
	public ResponseEntity<SweetItem> updateSweetItem(@RequestBody SweetItem sweetItem) {
	
		return  new ResponseEntity<SweetItem>(sweetItemService.updateSweetItem(sweetItem),HttpStatus.ACCEPTED);
	}

	@DeleteMapping("sweetitem/{sweetItemId}")
	public ResponseEntity<SweetItem> cancelSweetItem(@PathVariable int sweetItemId) {
		
		return new ResponseEntity<SweetItem>(sweetItemService.cancelSweetItem(sweetItemId),HttpStatus.ACCEPTED);
	}

	@GetMapping("/sweetitem")
	public ResponseEntity<List<SweetItem>> showAllSweetItems() {
		
		return new ResponseEntity<List<SweetItem>>(sweetItemService.showAllSweetItems(), HttpStatus.ACCEPTED);
	}
}
