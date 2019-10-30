package com.spandiar.springboot.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement(name="GoodreadsResponse")
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
public class GoodReadsBookDetails {
	
	private GoodReadsResponse goodReadsResponse;
	
	@JsonIgnoreProperties(ignoreUnknown=true)
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class GoodReadsResponse {
		
		private GoodReadsBook book;
		
		@JsonIgnoreProperties(ignoreUnknown=true)
		@XmlAccessorType(XmlAccessType.FIELD)
		public static class GoodReadsBook {
			
			private String id;
			private String title;
			//private String description;
			private String rating;
			
			public GoodReadsBook() {
				super();
				// TODO Auto-generated constructor stub
			}
			
			@XmlElement(name="id")
			public String getId() {
				return id;
			}
			public void setId(String id) {
				this.id = id;
			}
			
			@XmlElement(name="title")
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
			
			@XmlElement(name="average_rating")
			public String getRating() {
				return rating;
			}
			
			public void setRating(String rating) {
				this.rating = rating;
			}
			
		}
		
		public GoodReadsResponse() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		@XmlElement(name="book")
		public GoodReadsBook getBook() {
			return book;
		}

		public void setBook(GoodReadsBook book) {
			this.book = book;
		}
		
	}
	
	public GoodReadsBookDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@XmlElement(name="GoodreadsResponse")
	public GoodReadsResponse getGoodReadsResponse() {
		return goodReadsResponse;
	}

	public void setGoodReadsResponse(GoodReadsResponse goodReadsResponse) {
		this.goodReadsResponse = goodReadsResponse;
	}
	

}
