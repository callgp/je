package com.je.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.je.entities.Product;

@Repository // optional annotation
public interface ProductRepository extends JpaRepository<Product, Integer>{

	// by default findById
	// select * from product where name='mi'
	Product findByName(String productName); 
	// one methods means you should write one controlelr endpoint and one service layer logic
	
	List<Product> findByCategoryName(String categoryName);
	
	List<Product> findByCategoryId(Integer categoryId);
	
	// HQL Queries we can run in any database no dependeny to any databaes
	// * will not work only alias name will work here 
	@Query("select p from Product p "
			+ "INNER JOIN p.category c "
			+ "where c.name =:categoryName")
	List<Product> fetchProductsUsingCategoryName(String categoryName);
	
	@Query(value="select * from product p inner join category c on p.category_id = c.id",
			nativeQuery = true)
	List<Product> fetchProducs();
	
	Product findByNameAndPrice(String name,double price);
	
	//Product findByContaining(String searchKeyWord);
	
	
	
}
