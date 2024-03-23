package com.je.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.je.entities.Category;
import com.je.repository.CategoryRepository;

import jakarta.validation.Valid;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category createCategory(@Valid Category category) {
		return categoryRepository.save(category);
	}

}
