package com.spandiar.springboot.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
public class Library {
	@JsonIgnore
	private String library;
	private List<BookSimplifiedModel> libraryBooks;
	
	public Library() {
		
	}

	public String getLibrary() {
		return library;
	}

	public void setLibrary(String library) {
		this.library = library;
	}



	public List<BookSimplifiedModel> getLibraryBooks() {
		return libraryBooks;
	}

	public void setLibraryBooks(List<BookSimplifiedModel> libraryBooks) {
		this.libraryBooks = libraryBooks;
	}
	
}


