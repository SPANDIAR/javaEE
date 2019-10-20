package com.spandiar.rest.jersey.database;

import java.util.HashMap;
import java.util.Map;

import com.spandiar.rest.jersey.model.SoccerClub;

public class SoccerClubDB {
	
	private static Map<String, SoccerClub> clubMap = new HashMap();

	public SoccerClubDB() {
		// TODO Auto-generated constructor stub
	}

	public static Map<String, SoccerClub> getClubMap() {
		return clubMap;
	}

}
