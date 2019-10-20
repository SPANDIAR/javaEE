package com.spandiar.europe.football.service;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
@PreMatching
public class AuthorizationFilter implements ContainerRequestFilter {
	
	private static final String AUTHHEADER = "Authorization";
	private static final String AUTHVALUEPREFIX = "Basic ";
	private static final String USER = "football";
	private static final String PASSWORD = "thegreatestgame";

	public AuthorizationFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		//System.out.print("Inside the Auth Filter " +  requestContext.getHeaders());
		
		List<String> authValueMap = requestContext.getHeaders().get(AUTHHEADER);
		if (authValueMap != null && authValueMap.size() > 0) {
			String authHeaderValue = authValueMap.get(0).replaceFirst(AUTHVALUEPREFIX, "");
			String decodedAuthString = Base64.decodeAsString(authHeaderValue);
			StringTokenizer tokenizer = new StringTokenizer(decodedAuthString, ":");
			String username = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			
			//System.out.print("Username " + username + " Password " + password);
			
			if(username.equals(USER) && password.equals(PASSWORD)) {
				return;
			} else {
				Response unauthorized = Response
						.status(Status.UNAUTHORIZED)
						.entity("Unauthorized Access")
						.build();
				requestContext.abortWith(unauthorized);
			}
		} else {
			
			Response unauthorized = Response
					.status(Status.UNAUTHORIZED)
					.entity("Unauthorized Access")
					.build();
			requestContext.abortWith(unauthorized);
		}
	}
}
