package com.spandiar.rest.jersey.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ExceptionResponse {
	
	private String errorCode;
	private String errorMessage;

	public ExceptionResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public ExceptionResponse (String errorCode, String errorMessage) {
		this.errorCode=errorCode;
		this.errorMessage=errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
