package com.je.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.je.entities.Category;

@Repository // optional annotation
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
