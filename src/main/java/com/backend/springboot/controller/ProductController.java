package com.backend.springboot.controller;

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

import com.backend.springboot.model.Product;
import com.backend.springboot.repo.ProductRepo;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductRepo repo;
	
	@GetMapping()
	public ResponseEntity<List<Product>> getProduct(){
		List<Product> productList = repo.findAll();
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findOne(@PathVariable String id){
		 Product product = repo.findById(id).orElse(null);
		 if (product != null) {
			 return ResponseEntity.ok(product);
	     }else{
	    	 return ResponseEntity.notFound().build();
	     }
	}
	
	@PostMapping()
	public ResponseEntity<String> save(@RequestBody Product p){
		repo.save(p);
		return new ResponseEntity<String>("Data Inserted", HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable String id, @RequestBody Product updatedProduct){
		if(!repo.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		Product existingProduct = repo.findById(id).orElse(null);
		
		if(existingProduct != null) {
			existingProduct.setName(updatedProduct.getName());
			repo.save(existingProduct);
			return ResponseEntity.ok("Product updated successfully");
		}else {
			return ResponseEntity.status(500).body("Error al intentar actualizar...");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id){
		if(!repo.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		Product existingProduct = repo.findById(id).orElse(null);
		
		if(existingProduct != null) {
			repo.deleteById(id);
			return ResponseEntity.status(200).body("Producto borrado correctamente");
		}else {
			return ResponseEntity.status(500).body("Error al intentar eliminar...");
		}
	}
}
