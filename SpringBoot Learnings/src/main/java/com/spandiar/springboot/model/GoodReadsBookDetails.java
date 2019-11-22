package com.spandiar.springboot.model;

import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement(name="GoodreadsResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
@Document(collection="GoodReadsBookDetails")
public class GoodReadsBookDetails {
		@Id
		private String Id;
		@XmlElement(name="book")
		private GoodReadsBook book;
		
		@JsonIgnoreProperties(ignoreUnknown=true)
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class GoodReadsBook {
			
			@XmlElement(name="id")
			private String id;
			@XmlElement(name="isbn")
			private String isbn;
			@XmlElement(name="isbn13")
			private String isbn13;
			@XmlElement(name="title")
			private String title;
			@XmlElement(name="description")
			private String description;
			@XmlElement(name="average_rating")
			private String rating;
			
			public GoodReadsBook() {
				super();
				// TODO Auto-generated constructor stub
			}
			
			
			public String getId() {
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}
			
			
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			
		   public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}
			
			
			public String getRating() {
				return rating;
			}
			
			public void setRating(String rating) {
				this.rating = rating;
			}


			public String getIsbn() {
				return isbn;
			}


			public void setIsbn(String isbn) {
				this.isbn = isbn;
			}


			public String getIsbn13() {
				return isbn13;
			}


			public void setIsbn13(String isbn13) {
				this.isbn13 = isbn13;
			}
			
		}
	
	public GoodReadsBookDetails() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public String getId() {
		return Id;
	}
	
	public void setId(String id) {
		Id = id;
	}

	public GoodReadsBook getBook() {
		return book;
	}

	public void setBook(GoodReadsBook book) {
		this.book = book;
	}
	
}
