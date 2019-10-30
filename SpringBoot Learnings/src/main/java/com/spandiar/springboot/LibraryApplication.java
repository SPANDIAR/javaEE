package com.spandiar.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LibraryApplication {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public LibraryApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
}
