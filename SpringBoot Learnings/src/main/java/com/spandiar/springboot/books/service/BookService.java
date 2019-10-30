package com.spandiar.springboot.books.service;

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
import com.spandiar.springboot.model.BookSimplifiedModel;
import com.spandiar.springboot.model.GoodReadsBookDetails;
import com.spandiar.springboot.model.Library;



@Service
public class BookService {
	
	private static final String AUTHOR="A.AUTHOR";
	private static final String LANGUAGE="A.LANGUAGE";
	private static final String BOOKNAME="A.BOOKNAME";
	
	private List<BookModel> allBooks;
/*	@Autowired
	private bookRepository bookRepository;
	@PersistenceContext
	private EntityManager entityManager;*/
	@Autowired
	private BookMapper myBatisHandle;
	@Autowired
	private GoodBooksService goodBooksClientHandle;
	
	public BookService() {
		
	}

	public Library getAllBooks() {
		/* Iterator<BookModel> bookIterator = bookRepository.findAll().iterator();
		 allBooks = new ArrayList<BookModel>();
		 while(bookIterator.hasNext()) {
			 allBooks.add(bookIterator.next());
		 }
		 return allBooks;*/
		return myBatisHandle.AllBooks();
	}
	
/*	public Library getBooksByLanguage(String langCd){
		String sqlBooksByLang = "select id, bookname, author, language, publisher, year, volume, isbn, createddate, modifieddate from Books b where b.language=:langCd";
		Query selectBooksByLang = entityManager.createNativeQuery(sqlBooksByLang, BookModel.class).setParameter("langCd", langCd);
		List<BookModel> resultList = selectBooksByLang.getResultList();
		return resultList;
		
		langCd='%'+langCd+'%';
		return myBatisHandle.QueryParamSearch(LANGUAGE, langCd);
	}*/
	
/*	public Library getBooksByAuthor(String author) {
		String sqlBooksByAuthor = "select id, bookname, author, language, publisher, year, volume, isbn, createddate, modifieddate from Books b where b.author like %||:author||%";
		Query selectBooksByAuthor = entityManager.createNativeQuery(sqlBooksByAuthor, BookModel.class).setParameter("author", author);
		List<BookModel> resultList = selectBooksByAuthor.getResultList();
		return resultList;
		
		//return bookRepository.findByAuthorIgnoreCaseContaining(author);
		
		author = '%'+author+'%';
		return myBatisHandle.QueryParamSearch(AUTHOR, author);
		
	}*/
	
/*	public Library getBooksByName(String bookName) {
		
		//return bookRepository.findByNameIgnoreCaseContaining(bookName);
		bookName = '%'+bookName+'%';
		return myBatisHandle.QueryParamSearch(BOOKNAME, bookName);
	}*/
	
/*	public String updateBookDetails(BookModel updateBookDetail) {
		
		if(null != updateBookDetail) {
			updateBookDetail.setCreatedDate(new Date());
			updateBookDetail.setModifiedDate(new Date());
			List<BookAttributes> bookAttributes = updateBookDetail.getBookAttributes();
			Iterator<BookAttributes> iterator = bookAttributes.iterator();
			int i=1;
			while(iterator.hasNext()) {
				BookAttributes next = iterator.next();
				next.setBookId(updateBookDetail.getBookId());
				next.setAttributeId(i);
				next.setCreatedDate(new Date());
				next.setModifiedDate(new Date());
				i++;
			}
			bookRepository.save(updateBookDetail);
			return "Book details are updated";
		} else
		{
			return "Error";
		}
	}*/

	
	/*public BookModel getBookById(int bookId) {
		
		 Optional<BookModel> bookDetails = bookRepository.findById(bookId);
		 return bookDetails.get();
	}*/
		
	
/*	public int addBooksToLibrary(BookModel bookToAdd) {
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
		//bookRepository.save(bookToAdd);
		myBatisHandle.AddBookToLibrary(bookToAdd);
		
		return bookId;
	}*/

	/*private int nextBookId() {
		return (this.getAllBooks().size() + 1);
	}*/
	
	public BookSimplifiedModel testMyBatis(int bookId) {
		//return myBatisHandle.selectOne(bookId);
		BookSimplifiedModel bookWithGenre = myBatisHandle.BookWithGenre(bookId);
		if(bookWithGenre != null & bookWithGenre.getIsbn() != null) {
			// invoke GoodReads and get description and rating
			GoodReadsBookDetails goodBookDetailsUsingIsbn = goodBooksClientHandle.getGoodBookDetailsUsingIsbn(bookWithGenre.getIsbn());
			if (goodBookDetailsUsingIsbn != null) {
				bookWithGenre.setBookRating(Float.valueOf(goodBookDetailsUsingIsbn.getGoodReadsResponse().getBook().getRating()));
			}
		}
		return bookWithGenre;
	}
	
}
