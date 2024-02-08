package com.backend.springboot.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.springboot.model.StateType;

public interface StateTypeRepo extends MongoRepository<StateType, String>{
	
}
