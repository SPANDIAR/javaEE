package com.spandiar.rest.jersey.service;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter{
	
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String AUTHORIZATION_PREFIX = "Basic ";
	private static final String USERNAME = "soccer";
	private static final String PASSWORD = "football";
	

	public AuthenticationFilter() {
		
	}	

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		MultivaluedMap<String, String> headers = requestContext.getHeaders();
		System.out.println("Headers are " + headers);
		//List<String> authTokenList = headers.get(AUTHORIZATION_HEADER);
		if (headers.get(AUTHORIZATION_HEADER).size() > 0) {
			String authToken = headers.get(AUTHORIZATION_HEADER).get(0);
		}
	}
}
