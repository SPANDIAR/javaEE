package com.spandiar.springboot.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spandiar.springboot.model.GoodReadsBookDetails;

@Service
public class GoodBooksService {
	
	private static final String URL = "https://www.goodreads.com/book/isbn/";
	private static final String GOODREADSKEY = "i3d73iCe8uz6shMljLDew";
	private static final String GOODREADSUSER = "104698060";
	private static final String GOODREADSFORMAT = "xml";
	@Autowired
	private RestTemplate restTemplate;

	public GoodBooksService() {
		// TODO Auto-generated constructor stub
	}
	
	public GoodReadsBookDetails getGoodBookDetailsUsingIsbn(String isbn) {
		
		String url = URL + isbn + "?" + "key=" + GOODREADSKEY + "&" + "format=" + GOODREADSFORMAT;
		System.out.println("GoodBooks URL is: " + url);
		//String forStringObject = restTemplate.getForObject(url, String.class);
		//System.out.println("Response from GoodReads is: " + forStringObject);
		GoodReadsBookDetails forObject = restTemplate.getForObject(url, GoodReadsBookDetails.class);
		return forObject;
	}

}
