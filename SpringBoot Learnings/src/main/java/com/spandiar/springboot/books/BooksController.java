package com.spandiar.springboot.books;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spandiar.springboot.books.service.BookService;
import com.spandiar.springboot.books.service.GoodBooksService;
import com.spandiar.springboot.model.BookSimplifiedModel;
import com.spandiar.springboot.model.GoodReadsBookDetails;
import com.spandiar.springboot.model.Library;


@RestController
public class BooksController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private GoodBooksService goodBooksService;
	
	Logger logger = LoggerFactory.getLogger(BooksController.class);

	public BooksController() {
	}
	
/*	//@RequestMapping("/library/books")
	@GetMapping("/library/books")
	public Library getAllBooks() {
		return bookService.getAllBooks();
	}*/
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public String welcome() {
		return "Welcome to the library";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/library/books/{bookId}")
	public BookSimplifiedModel getBookById(@PathVariable("bookId") int bookId) {
		
		//return bookService.getBookById(bookId);
		return bookService.getBookFromRepository(bookId);
	}
	

	@GetMapping("/library/books")
	public Library getAllBooks(@RequestParam("langCd") Optional<String> langCd, @RequestParam("author") Optional<String> author, @RequestParam("bookName") Optional<String> bookName) {
		logger.trace("Inside getAllBooks Controller");
		if (langCd.isPresent()) {
			System.out.print("Language Code is " + langCd.get());
			return bookService.getBooksByLanguage(langCd.get());
		} 
		else if(author.isPresent()) {
			System.out.print("Author is " + author.get());
			return bookService.getBooksByAuthor(author.get());
		}
		else if (bookName.isPresent()) {
			
			System.out.println("Book Name passed is: " + bookName.get());
			return bookService.getBooksByName(bookName.get());
		}
		else {
			return bookService.getAllBooks();
		}
		
	}
	
	@GetMapping("/library/books/isbn/{isbnId}")
	public GoodReadsBookDetails getBookDetailsByISBN(@PathVariable("isbnId") String isbnId) {
		
		GoodReadsBookDetails goodBookDetailsUsingIsbn = new GoodReadsBookDetails();
		
		try {
			if(!(null==isbnId) && !(isbnId.isEmpty())) {
				goodBookDetailsUsingIsbn = goodBooksService.getGoodBookDetailsUsingIsbn(isbnId);
			}
		} catch (Exception ex) {
			return null;
		}
		
		return goodBookDetailsUsingIsbn;
	}
	
	public void searchBooksByTitle() {
		
	}
	
/*	@RequestMapping(method=RequestMethod.PUT, value="/library/books/{bookId}")
	public String updateBookDetails(@PathVariable("bookId") int bookId, @RequestBody BookModel updatedBook) {
		if (bookId == updatedBook.getBookId()) {
		return bookService.updateBookDetails(updatedBook);
		} else 
			return "BookId does not match with message";
	}*/
	
	@RequestMapping(method=RequestMethod.POST, value="/library/books")
	@CrossOrigin
	public ResponseEntity addBook(@RequestBody BookSimplifiedModel bookToAdd) {
		
		int bookId = bookService.addBooksToLibrary(bookToAdd);
		if(bookId > 0) {
			BookSimplifiedModel bookFromRepository = bookService.getBookFromRepository(bookId);
			//ResponseEntity<BookSimplifiedModel> = new ResponseEntity(response, HttpStatus.OK);
			return (new ResponseEntity(bookFromRepository, HttpStatus.OK));
		} else
			return (new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR));
	}

}
