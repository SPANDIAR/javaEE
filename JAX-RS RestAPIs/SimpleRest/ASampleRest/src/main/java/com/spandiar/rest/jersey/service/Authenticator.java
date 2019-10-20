package com.spandiar.rest.jersey.service;

import java.util.HashMap;
import java.util.Map;

import com.spandiar.rest.jersey.ASampleRest.exception.AuthenticationFailureException;

public class Authenticator {
	
	private static Map<String, String> keyStore = new HashMap<>();

	public Authenticator() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static boolean isApplicationAuthorized(String key, String value) {
		getKeyStore().put("1773", "password");
		//return getKeyStore().get(key).contentEquals(value);
		boolean authenticationStatus = getKeyStore().get(key).contentEquals(value);
		if (authenticationStatus) {
			return authenticationStatus;
		} else {
			throw new AuthenticationFailureException("Authentication failed");
			//return true;
		}
	}

	public static Map<String, String> getKeyStore() {
		return keyStore;
	}

	public static void setKeyStore(Map<String, String> keyStore) {
		Authenticator.keyStore = keyStore;
	}
	
	
}
