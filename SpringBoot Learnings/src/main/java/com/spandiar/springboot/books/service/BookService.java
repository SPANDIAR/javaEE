package com.spandiar.springboot.books.service;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.*;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import com.spandiar.springboot.books.mybatis.BookMapper;
import com.spandiar.springboot.model.BookModel;
import com.spandiar.springboot.model.BookSimplifiedModel;
import com.spandiar.springboot.model.BookSimplifiedModel.BookAttributesSimplified;
import com.spandiar.springboot.model.GoodReadsBookDetails;
import com.spandiar.springboot.model.Library;
import com.spandiar.springboot.repository.MongoDbHandle;


@Service
public class BookService {
	
	private static final String AUTHOR="A.AUTHOR";
	private static final String LANGUAGE="A.LANGUAGE";
	private static final String BOOKNAME="A.BOOKNAME";
	private static final String GOODREADS = "GoodReadsBookDetails";
	
	Logger logger = LoggerFactory.getLogger(BookService.class);
	
	private List<BookModel> allBooks;
/*	@Autowired
	private bookRepository bookRepository;
	@PersistenceContext
	private EntityManager entityManager;*/
	@Autowired
	private BookMapper myBatisHandle;
	@Autowired
	private GoodBooksService goodBooksClientHandle;
	/*@Autowired
	private final MongoOperations mongoOpsDBHandle;*/
	@Autowired
	private MongoTemplate mongoTemplateDBHandle;
	
	
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
	
	public Library getBooksByLanguage(String langCd){
		
		/*String sqlBooksByLang = "select id, bookname, author, language, publisher, year, volume, isbn, createddate, modifieddate from Books b where b.language=:langCd";
		Query selectBooksByLang = entityManager.createNativeQuery(sqlBooksByLang, BookModel.class).setParameter("langCd", langCd);
		List<BookModel> resultList = selectBooksByLang.getResultList();
		return resultList;*/
		
		langCd='%'+langCd+'%';
		return myBatisHandle.QueryParamSearch(LANGUAGE, langCd);
	}
	
	public Library getBooksByAuthor(String author) {
		
		/*String sqlBooksByAuthor = "select id, bookname, author, language, publisher, year, volume, isbn, createddate, modifieddate from Books b where b.author like %||:author||%";
		Query selectBooksByAuthor = entityManager.createNativeQuery(sqlBooksByAuthor, BookModel.class).setParameter("author", author);
		List<BookModel> resultList = selectBooksByAuthor.getResultList();
		return resultList;
		return bookRepository.findByAuthorIgnoreCaseContaining(author);*/
		
		author = '%'+author+'%';
		return myBatisHandle.QueryParamSearch(AUTHOR, author);
		
	}
	
	public Library getBooksByName(String bookName) {
		
		//return bookRepository.findByNameIgnoreCaseContaining(bookName);
		bookName = '%'+bookName+'%';
		return myBatisHandle.QueryParamSearch(BOOKNAME, bookName);
	}
	
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
		
	
	public int addBooksToLibrary(BookSimplifiedModel bookToAdd) {
		//int bookId = this.nextBookId();
		int attributeId=1;
		//bookToAdd.setBookId(bookId);
		if (null != bookToAdd.getBookAttributes()) {
			
			Iterator<BookAttributesSimplified> bookAttributeIterator = bookToAdd.getBookAttributes().iterator();
			if (null != bookAttributeIterator ) {
				while(bookAttributeIterator.hasNext()) {
					BookAttributesSimplified bookAttribute = bookAttributeIterator.next();
					//bookAttribute.setBookId(bookId);
					bookAttribute.setAttributeId(attributeId);
					//bookAttribute.setCreatedDate(new Date());
					//bookAttribute.setModifiedDate(new Date());
					attributeId++;
				}
				//bookToAdd.setCreatedDate(new Date());
				//bookToAdd.setModifiedDate(new Date());
				//bookRepository.save(bookToAdd);
				myBatisHandle.AddBookToLibrary(bookToAdd);
			}
		}
		return bookToAdd.getBookId();
	}

	private int nextBookId() {
		return (myBatisHandle.getNextBookId());
	}
	
	public BookSimplifiedModel getBookFromRepository(int bookId) {
		//return myBatisHandle.selectOne(bookId);
		BookSimplifiedModel bookWithGenre = myBatisHandle.BookWithGenre(bookId);
		GoodReadsBookDetails goodBookDetailsUsingIsbn;
		
		if (bookWithGenre == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
		} else if (bookWithGenre != null & bookWithGenre.getIsbn() != null) {
			// check local mongo cache if book details exist
			try {
				logger.info("Size of the GoodReads collection in mongo is " + mongoTemplateDBHandle.getCollection(GOODREADS).countDocuments());
				
				String formattedIsbn = StringUtils.delete(bookWithGenre.getIsbn(), "-");
				Criteria criteria1 = new Criteria().where("book.isbn").is(formattedIsbn);
				Criteria criteria2 = new Criteria().where("book.isbn13").is(formattedIsbn);
				Criteria orCondition = new Criteria().orOperator(criteria1, criteria2);
				Query query = new Query().addCriteria(orCondition);
				
				goodBookDetailsUsingIsbn = mongoTemplateDBHandle.findOne(query, GoodReadsBookDetails.class);
				
			} catch (Exception e) {
				goodBookDetailsUsingIsbn = null;
				logger.info("Error occured when reading from mongo" + e.getStackTrace().toString());
			}
			if(null != goodBookDetailsUsingIsbn) {
				logger.info("Additional details read from cache");
				bookWithGenre.setBookRating(Float.valueOf(goodBookDetailsUsingIsbn.getBook().getRating()));
				bookWithGenre.setBookSnippet(goodBookDetailsUsingIsbn.getBook().getDescription());
			} else {
				// invoke GoodReads and get description and rating
				goodBookDetailsUsingIsbn = goodBooksClientHandle
						.getGoodBookDetailsUsingIsbn(bookWithGenre.getIsbn());
				if (goodBookDetailsUsingIsbn != null) {
					logger.info("External service invoked to fetch additional details");
					logger.info(goodBookDetailsUsingIsbn.toString());
					mongoTemplateDBHandle.save(goodBookDetailsUsingIsbn);
					bookWithGenre.setBookRating(Float.valueOf(goodBookDetailsUsingIsbn.getBook().getRating()));
					bookWithGenre.setBookSnippet(goodBookDetailsUsingIsbn.getBook().getDescription());
				}
			}
		}
		return bookWithGenre;
	}
}
