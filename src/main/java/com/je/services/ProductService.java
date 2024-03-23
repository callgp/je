package com.je.services;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.je.entities.Product;
import com.je.enums.ProductStatus;
import com.je.exceptions.ResourceNotFoundException;
import com.je.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		product.setBarCode(UUID.randomUUID().toString());
		product.setProductStatus(ProductStatus.CREATED);
		return productRepository.save(product);
	}

	public Product fetch(Integer id) {
		return productRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Product Not Exits in Database"));
	}

	public Product update(Integer id, Product inputProduct) {
		Product dbProduct = fetch(id);
		dbProduct.setDescription(inputProduct.getDescription());
		dbProduct.setBarCode(inputProduct.getBarCode());
		dbProduct.setName(inputProduct.getName());
		dbProduct.setPrice(inputProduct.getPrice());
		return productRepository.save(dbProduct);
	}

	public void deleteProduct(Integer productId) {
		boolean isExists = productRepository.existsById(productId);
		if(isExists) {
			productRepository.deleteById(productId);
		} else {
			throw new RuntimeException("Record Not Found in DB");
		}
	}

	public List<Product> fetchAll() {
		List<Product> list = productRepository.findAll();
		return list.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).toList();
	}

	public Product fetchProductByName(String name) {
		Product dbProduct = productRepository.findByName(name);
		if (dbProduct == null) {
			throw new ResourceNotFoundException("Product Not exits in Db");
		}
		return dbProduct;
	}

	public List<Product> fetchProductsByCategoryName(String categoryName) {
		return productRepository.findByCategoryName(categoryName);
	}
}
