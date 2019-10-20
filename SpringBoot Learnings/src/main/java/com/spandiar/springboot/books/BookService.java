package com.spandiar.springboot.books;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spandiar.springboot.books.mybatis.BookMapper;
import com.spandiar.springboot.model.BookModel;
import com.spandiar.springboot.model.BookModel.BookAttributes;
import com.spandiar.springboot.model.BookSimplifiedModel;

@Service
public class BookService {
	
	private List<BookModel> allBooks;
	@Autowired
	private bookRepository bookRepository;
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private BookMapper iBatisHandle;
	
	public BookService() {
		
	}

	public List<BookModel> getAllBooks() {
		 Iterator<BookModel> bookIterator = bookRepository.findAll().iterator();
		 allBooks = new ArrayList<BookModel>();
		 while(bookIterator.hasNext()) {
			 allBooks.add(bookIterator.next());
		 }
		 return allBooks;
	}
	
	public List<BookModel> getBooksByLanguage(String langCd){
		String sqlBooksByLang = "select id, bookname, author, language, publisher, year, volume, isbn, createddate, modifieddate from Books b where b.language=:langCd";
		Query selectBooksByLang = entityManager.createNativeQuery(sqlBooksByLang, BookModel.class).setParameter("langCd", langCd);
		List<BookModel> resultList = selectBooksByLang.getResultList();
		return resultList;
	}
	
	public List<BookModel> getBooksByAuthor(String author) {
		/*String sqlBooksByAuthor = "select id, bookname, author, language, publisher, year, volume, isbn, createddate, modifieddate from Books b where b.author like %||:author||%";
		Query selectBooksByAuthor = entityManager.createNativeQuery(sqlBooksByAuthor, BookModel.class).setParameter("author", author);
		List<BookModel> resultList = selectBooksByAuthor.getResultList();
		return resultList;*/
		
		return bookRepository.findByAuthorIgnoreCaseContaining(author);
		
	}

	
	public BookModel getBookById(int bookId) {
		
		 Optional<BookModel> bookDetails = bookRepository.findById(bookId);
		 return bookDetails.get();
	}
		
	
	public int addBooksToLibrary(BookModel bookToAdd) {
		int bookId = this.nextBookId();
		int attributeId=1;
		bookToAdd.setBookId(bookId);
		Iterator<BookAttributes> bookAttributeIterator = bookToAdd.getBookAttributes().iterator();
		while(bookAttributeIterator.hasNext()) {
			BookAttributes bookAttribute = bookAttributeIterator.next();
			bookAttribute.setBookId(bookId);
			bookAttribute.setAttributeId(attributeId);
			bookAttribute.setCreatedDate(new Date());
			bookAttribute.setModifiedDate(new Date());
			attributeId++;
		}
		bookToAdd.setCreatedDate(new Date());
		bookToAdd.setModifiedDate(new Date());
		bookRepository.save(bookToAdd);
		return bookId;
	}

	private int nextBookId() {
		return (this.getAllBooks().size() + 1);
	}
	
	public BookSimplifiedModel testMyBatis(int bookId) {
		return iBatisHandle.selectOne(bookId);
	}
	
}
