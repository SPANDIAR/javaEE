package com.spandiar.springboot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="books")
@JsonInclude(Include.NON_NULL)
public class BookModel {
	@Id
	@Column (name="bookid")
	private int bookId;
	@Column (name="bookname")
	private String name;
	private String author;
	private String language;
	private String publisher;
	private int year;
	private int volume;
	private String isbn;
	@Column (name="createddate")
	@JsonIgnore
	private Date createdDate;
	@Column (name="modifieddate")
	private Date modifiedDate;
	@OneToMany
	@Cascade({CascadeType.DELETE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	@JoinColumn(name="bookid")
	@ElementCollection (fetch=FetchType.EAGER)
	@JsonProperty("additionalAttributes")
	@JsonManagedReference
	private List<BookAttributes> bookAttributes = new ArrayList<BookAttributes>();
	
	@Entity
	@Table (name="book_attributes")
	@IdClass(BookAttributeKeys.class)
	public static class BookAttributes {
		@Id
		@Column (name="bookid")
		@JsonIgnore
		private int bookId;
		@Id
		@Column (name="attributeid")
		@JsonIgnore
		private int attributeId;
		private String genre;
		@ManyToOne
		@JoinColumn(name="bookid", insertable=false, updatable=false)
		@JsonBackReference
		private BookModel bookModel;
		@JsonIgnore
		@Column (name="createddate")
		private Date createdDate;
		@JsonIgnore
		@Column (name="modifieddate")
		private Date modifiedDate;
		
		public BookAttributes() {
			
		}	

		public int getBookId() {
			return bookId;
		}

		public void setBookId(int bookId) {
			this.bookId = bookId;
		}

		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}

		public BookModel getBookModel() {
			return bookModel;
		}

		public void setBookModel(BookModel bookModel) {
			this.bookModel = bookModel;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public Date getModifiedDate() {
			return modifiedDate;
		}

		public void setModifiedDate(Date modifiedDate) {
			this.modifiedDate = modifiedDate;
		}

		public int getAttributeId() {
			return attributeId;
		}

		public void setAttributeId(int attributeId) {
			this.attributeId = attributeId;
		}
		
	}

	public BookModel() {
		
	}
	
	public int getBookId() {
		return bookId;
	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public List<BookAttributes> getBookAttributes() {
		return bookAttributes;
	}

	public void setBookAttributes(List<BookAttributes> bookAttributes) {
		this.bookAttributes = bookAttributes;
	}
	
}
