package com.demo.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.mongo.model.MyBook;

public interface MyBookRepository extends MongoRepository<MyBook, String> {

	//queries we can write if needed
}