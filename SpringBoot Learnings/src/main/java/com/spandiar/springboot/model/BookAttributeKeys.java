package com.spandiar.springboot.model;

import java.io.Serializable;

public class BookAttributeKeys implements Serializable{
	
	private int bookId;
	private int attributeId;

	public BookAttributeKeys() {
		// TODO Auto-generated constructor stub
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
	
}
