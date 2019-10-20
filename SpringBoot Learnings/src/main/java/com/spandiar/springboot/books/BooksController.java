package com.spandiar.springboot.books;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spandiar.springboot.model.BookModel;

@RestController
public class BooksController {
	
	@Autowired
	private BookService bookService;

	public BooksController() {
	}
	
/*	//@RequestMapping("/library/books")
	@GetMapping("/library/books")
	public List<BookModel> getAllBooks() {
		return bookService.getAllBooks();
	}*/
	
	
	@RequestMapping("/library/books/{bookId}")
	public BookModel getBookById(@PathVariable("bookId") int bookId) {
		
		return bookService.getBookById(bookId);
	}
	
	@GetMapping("/library/books")
	public List<BookModel> getAllBooks(@RequestParam("langCd") Optional<String> langCd, @RequestParam("author") Optional<String> author) {

		if (langCd.isPresent()) {
			System.out.print("Language Code is " + langCd.get());
			return bookService.getBooksByLanguage(langCd.get());
		} 
		else if(author.isPresent()) {
			System.out.print("Author is " + author.get());
			return bookService.getBooksByAuthor(author.get());
		}
		else {
			return bookService.getAllBooks();
		}
	}
	
	public void searchBooksByTitle() {
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/library/books")
	public int addBook(@RequestBody BookModel bookToAdd) {
		return (bookService.addBooksToLibrary(bookToAdd));
	}

}