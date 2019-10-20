package com.spandiar.rest.jersey.ASampleRest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.spandiar.rest.jersey.model.ExceptionResponse;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	public DataNotFoundExceptionMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Response toResponse(DataNotFoundException exception) {
		//return null;
		ExceptionResponse ex = new ExceptionResponse("404", exception.getMessage());
		return Response.status(Status.NOT_FOUND).entity(ex).build();
	}

}
