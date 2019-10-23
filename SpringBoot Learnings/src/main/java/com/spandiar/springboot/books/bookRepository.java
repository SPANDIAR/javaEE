package com.spandiar.springboot.books;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spandiar.springboot.model.BookModel;

public interface bookRepository extends CrudRepository<BookModel, Integer>{
	
	public List<BookModel> findByAuthorIgnoreCaseContaining(String author);
	public List<BookModel> findByNameIgnoreCaseContaining(String bookName);

}
