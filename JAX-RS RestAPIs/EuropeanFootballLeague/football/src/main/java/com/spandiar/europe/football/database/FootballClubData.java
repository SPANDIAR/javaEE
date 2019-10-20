package com.spandiar.europe.football.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.spandiar.europe.football.model.FootballClubModel;

public class FootballClubData {
	
	private Map<String, FootballClubModel> footballClubMap = new HashMap<String, FootballClubModel> ();

	public FootballClubData() {
		
	}

	public Map<String, FootballClubModel> getFootballClubMap() {
		return footballClubMap;
	}

	public void setFootballClubMap(Map<String, FootballClubModel> footballClubMap) {
		this.footballClubMap = footballClubMap;
	}

}
