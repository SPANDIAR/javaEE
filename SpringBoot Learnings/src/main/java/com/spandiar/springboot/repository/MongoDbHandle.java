package com.spandiar.springboot.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;


@Configuration
public class MongoDbHandle {
	
	private static final String DBNAME = "library";
	
	
	public @Bean MongoClient mongoClient() {
		return new MongoClient("localhost", 27017);
	}
	
	public @Bean MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoClient(), DBNAME);
	}

}
