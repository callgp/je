package com.je.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.je.entities.Category;
import com.je.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Category createCategory(@Valid @RequestBody Category category) {
		return categoryService.createCategory(category);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
