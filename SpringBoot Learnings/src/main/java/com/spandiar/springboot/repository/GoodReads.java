/*package com.spandiar.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.spandiar.springboot.model.GoodReadsBookDetails;

@Repository
public interface GoodReads extends MongoRepository<GoodReadsBookDetails, String>{
	
	@Query(value = "{'book.isbn':?0}")
	GoodReadsBookDetails findByIsbn(String isbn);	
	@Query(value = "{$or:[{'book.isbn':?0},{'book.isbn13':?0}]}")
	//@Query(value = "[{'book.isbn':?0},{'book.isbn13':?0}]")
	GoodReadsBookDetails findByIsbnOrIsbn13(String isbn);	
}
*/