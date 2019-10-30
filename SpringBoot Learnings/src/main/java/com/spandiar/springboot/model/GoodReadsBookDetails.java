package com.spandiar.springboot.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement(name="GoodreadsResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
public class GoodReadsBookDetails {
	
		@XmlElement(name="book")
		private GoodReadsBook book;
		
		@JsonIgnoreProperties(ignoreUnknown=true)
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class GoodReadsBook {
			
			@XmlElement(name="id")
			private String id;
			@XmlElement(name="title")
			private String title;
			//private String description;
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
			
		/* @XmlElement(name="description")		
		   public String getDescription() {
				return description;
			}
			public void setDescription(String description) {
				this.description = description;
			}*/
			
			
			public String getRating() {
				return rating;
			}
			
			public void setRating(String rating) {
				this.rating = rating;
			}
			
		}
	
	public GoodReadsBookDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public GoodReadsBook getBook() {
		return book;
	}

	public void setBook(GoodReadsBook book) {
		this.book = book;
	}
	
}
