package com.spandiar.springboot.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BookSimplifiedModel {
	
	private int bookId;
	private String bookName;
	private String author;
	private String language;
	private String publisher;
	private int year;
	private int volume;
	private String isbn;
	private String bookSnippet;
	private float bookRating;
	private List<BookAttributesSimplified> bookAttributes;

	public BookSimplifiedModel() {
		// TODO Auto-generated constructor stub
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookSnippet() {
		return bookSnippet;
	}

	public void setBookSnippet(String bookSnippet) {
		this.bookSnippet = bookSnippet;
	}

	public float getBookRating() {
		return bookRating;
	}

	public void setBookRating(float bookRating) {
		this.bookRating = bookRating;
	}

	public List<BookAttributesSimplified> getBookAttributes() {
		return bookAttributes;
	}

	public void setBookAttributes(List<BookAttributesSimplified> bookAttributes) {
		this.bookAttributes = bookAttributes;
	}
	
	public static class BookAttributesSimplified {
		
		@JsonIgnore
		private int bookId;
		private int attributeId;
		private String bookGenre;
		

		public BookAttributesSimplified() {
			
		}	
		
		public int getBookId() {
			return bookId;
		}

		public void setBookId(int bookId) {
			this.bookId = bookId;
		}

		public int getAttributeId() {
			return attributeId;
		}


		public void setAttributeId(int attributeId) {
			this.attributeId = attributeId;
		}


		public String getBookGenre() {
			return bookGenre;
		}

		public void setBookGenre(String bookGenre) {
			this.bookGenre = bookGenre;
		}
		
	}
	
}