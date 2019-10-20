package com.spandiar.rest.jersey.ASampleRest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.spandiar.rest.jersey.model.ExceptionResponse;

@Provider
public class AuthenticationFailureExceptionMapper implements ExceptionMapper<AuthenticationFailureException>{

	public AuthenticationFailureExceptionMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Response toResponse(AuthenticationFailureException exception) {	
		ExceptionResponse ex = new ExceptionResponse("401", exception.getMessage());
		return Response.status(Status.UNAUTHORIZED).entity(ex).build();
	}

}
