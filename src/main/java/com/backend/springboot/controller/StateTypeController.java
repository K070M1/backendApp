package com.backend.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
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

import com.backend.springboot.model.StateType;
import com.backend.springboot.repo.StateTypeRepo;

import util.PropertyUtils;

@RestController
@RequestMapping("/stateTypes")
public class StateTypeController {
	
	@Autowired
	StateTypeRepo repo;
	
	@GetMapping()
	public ResponseEntity<List<StateType>> getStates(){
		List<StateType> list = repo.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StateType> findOne(@PathVariable String id){
		 StateType item = repo.findById(id).orElse(null);
		 if (item != null) {
			 return ResponseEntity.ok(item);
	     }else{
	    	 return ResponseEntity.notFound().build();
	     }
	}
	
	@PostMapping()
	public ResponseEntity<StateType> save(@RequestBody StateType p){
		StateType newData = repo.save(p);
		return ResponseEntity.ok().body(newData);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StateType> update(@PathVariable String id, @RequestBody StateType updatedItem){
		if(!repo.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		StateType existingItem = repo.findById(id).orElse(null);
		
		if(existingItem != null) {
			
			String[] nonNullProps =  PropertyUtils.getNullPropertyNames(updatedItem);
			
			System.out.println("Propiedades nulas" + Arrays.toString(nonNullProps));
			
			BeanUtils.copyProperties(updatedItem, existingItem, nonNullProps);
			
			existingItem = repo.save(existingItem);
			return ResponseEntity.ok().body(existingItem);
		}else {
			return ResponseEntity.status(500).body(null);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable String id){
		if(!repo.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		StateType existingItem = repo.findById(id).orElse(null);
		
		if(existingItem != null) {
			repo.deleteById(id);
			return ResponseEntity.status(200).body("Deleted successfully..!");
		}else {
			return ResponseEntity.status(500).body("Error...");
		}
	}
	
}
