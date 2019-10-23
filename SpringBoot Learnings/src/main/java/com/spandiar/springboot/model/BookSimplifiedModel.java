package com.spandiar.springboot.model;

import java.util.List;

public class BookSimplifiedModel {
	
	private int bookId;
	private String bookName;
	private String author;
	private String language;
	private String publisher;
	private int year;
	private int volume;
	private List<BookAttributesSimplified> bookGenreType;

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
	
	
	public List<BookAttributesSimplified> getBookGenreType() {
		return bookGenreType;
	}

	public void setBookGenreType(List<BookAttributesSimplified> bookGenreType) {
		this.bookGenreType = bookGenreType;
	}

	public static class BookAttributesSimplified {
		
		private String bookGenre;
		

		public BookAttributesSimplified() {
			
		}

		public String getBookGenre() {
			return bookGenre;
		}

		public void setBookGenre(String bookGenre) {
			this.bookGenre = bookGenre;
		}
		
	}
	
}
