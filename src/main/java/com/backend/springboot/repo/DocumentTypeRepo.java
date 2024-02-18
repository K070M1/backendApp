package com.backend.springboot.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.springboot.model.DocumentType;

public interface DocumentTypeRepo extends MongoRepository<DocumentType, String>{

}
