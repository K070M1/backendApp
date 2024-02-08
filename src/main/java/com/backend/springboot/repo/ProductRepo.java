package com.backend.springboot.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.springboot.model.Product;

public interface ProductRepo  extends MongoRepository<Product, String>{
	
	List<Product> findByName(String name);
	
}
