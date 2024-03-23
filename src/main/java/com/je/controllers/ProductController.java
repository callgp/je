package com.je.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.je.entities.Product;
import com.je.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/products")
//@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product createProduct( @RequestBody @Valid Product product) {
		return productService.createProduct(product);
	}
	
	@GetMapping("{id}")
	public Product fetchProduct(@PathVariable Integer id) {
		return productService.fetch(id);
	}
	
	@GetMapping
	public List<Product> fetchAllProducts() {
		return productService.fetchAll();
	}
	
	@GetMapping("name/{name}")
	public Product fetchProduct(@PathVariable String name) {
		return productService.fetchProductByName(name);
	}
	
	@PutMapping("{id}")
	public Product updateProduct(@PathVariable Integer id,@RequestBody Product product) {
		return productService.update(id,product);
	}
	
	@DeleteMapping("{id}")
	public void deleteProduct(@PathVariable(value="id") Integer productId) {
		productService.deleteProduct(productId);
	}
	
	@GetMapping("category/name/{name}")
	public List<Product> fetchProductsByCategory(@PathVariable(value="name") String categoryName) {
		return productService.fetchProductsByCategoryName(categoryName);
	}	
	
	
}
