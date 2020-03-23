package com.spandiar.springboot.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
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
		
	}
	
	public GoodReadsBookDetails getGoodBookDetailsUsingIsbn(String isbn) {
		
		GoodReadsBookDetails response = new GoodReadsBookDetails();
		
		if(!(null==isbn) && !(isbn.isEmpty())) {
			
			ResponseEntity<GoodReadsBookDetails> responseEntity;
			String url = URL + isbn + "?" + "key=" + GOODREADSKEY + "&" + "format=" + GOODREADSFORMAT;
			try {
				responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, GoodReadsBookDetails.class);
				if(responseEntity.getStatusCode().is2xxSuccessful()) {
					response = responseEntity.getBody();
				} else
					response = null;
			} catch(RestClientException ex) {
				ex.printStackTrace();
				response = null;
			}
		}
		return response;
	}
}
