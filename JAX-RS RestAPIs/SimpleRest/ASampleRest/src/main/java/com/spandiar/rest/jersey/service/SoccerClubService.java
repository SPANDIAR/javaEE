package com.spandiar.rest.jersey.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.spandiar.rest.jersey.ASampleRest.exception.DataNotFoundException;
import com.spandiar.rest.jersey.database.SoccerClubDB;
import com.spandiar.rest.jersey.model.SoccerClub;

public class SoccerClubService {
	
	//private List<SoccerClub> soccerClubs = new ArrayList<SoccerClub>();
	private List<SoccerClub> soccerClubs;

	public SoccerClubService() {
		// TODO Auto-generated constructor stub
		
		SoccerClub club1 = new SoccerClub("ARS", "Arsenal", "EPL", "the gunners", 1881);
		SoccerClub club2 = new SoccerClub("MUFC", "Manchester United", "EPL", "red devils", 1885);
		SoccerClub club3 = new SoccerClub("LIV", "Liverpool", "EPL", "reds", 1896);
		SoccerClub club4 = new SoccerClub("CHE", "Chelsea", "EPL", "blues", 1899);
		SoccerClub club5 = new SoccerClub("RMFC", "Read Madrid", "LaLiga", "galaticos", 1899);
		SoccerClub club6 = new SoccerClub("BAR", "Barcelona", "LaLiga", "catalans", 1880);
		SoccerClub club7 = new SoccerClub("VAL", "Valencia", "LaLiga", "valencia", 1882);
		SoccerClub club8 = new SoccerClub("BAY", "Bayern Munich", "Bundesliga", "Munchen", 1882);
		SoccerClub club9 = new SoccerClub("MIL", "AC Milan", "Serie A", "Milan", 1882);
		SoccerClub club10 = new SoccerClub("INT", "Inter Milan", "Serie A", "Inter", 1882);
		SoccerClub club11 = new SoccerClub("JUV", "Juventus", "Serie A", "Old Lady", 1882);



		
		SoccerClubDB.getClubMap().put(club1.getClubId(), club1);
		SoccerClubDB.getClubMap().put(club2.getClubId(), club2);
		SoccerClubDB.getClubMap().put(club3.getClubId(), club3);
		SoccerClubDB.getClubMap().put(club4.getClubId(), club4);
		SoccerClubDB.getClubMap().put(club5.getClubId(), club5);
		SoccerClubDB.getClubMap().put(club6.getClubId(), club6);
		SoccerClubDB.getClubMap().put(club7.getClubId(), club7);
		SoccerClubDB.getClubMap().put(club8.getClubId(), club8);
		SoccerClubDB.getClubMap().put(club9.getClubId(), club9);
		SoccerClubDB.getClubMap().put(club10.getClubId(), club10);
		SoccerClubDB.getClubMap().put(club11.getClubId(), club11);

		
	}

	public List<SoccerClub> getSoccerClubs() {
		return soccerClubs;
	}


	public void setSoccerClubs(List<SoccerClub> soccerClubs) {
		this.soccerClubs = soccerClubs;
	}
	
	public  List<SoccerClub> getAllSoccerClubs(String league) {
		// Implement the logic to return all clubs
		if (league == null || league.isEmpty()) {
		return (new ArrayList<SoccerClub> (SoccerClubDB.getClubMap().values()));
		} else if (league.length()>0){
			soccerClubs = new ArrayList<SoccerClub> (SoccerClubDB.getClubMap().values());
			Iterator<SoccerClub> traverse = soccerClubs.iterator();	
			
			/*for(Map.Entry<String, SoccerClub> club: SoccerClubDB.getClubMap().entrySet()) {
			// return only the clubs which match the league
			if(club.getValue().getLeague().contentEquals(league)) {
				this.getSoccerClubs().add(club.getValue());
			}	
			}*/
		
			while(traverse.hasNext()) {
				if(!(traverse.next().getLeague().contentEquals(league))) {
					traverse.remove();
				}
			}	
			return this.getSoccerClubs();
		} else {
			return null;
		}
	}
	
	public SoccerClub getSoccerClubDetails(String clubId) {
		// logic to return only the specific club based on the club Id
		//return SoccerClubDB.getClubMap().get(clubId);
		SoccerClub soccerClub = SoccerClubDB.getClubMap().get(clubId);
		
		if (soccerClub == null) {
			throw new DataNotFoundException("Soccer Club " + clubId + " is not found");
		}
		return soccerClub;
	}
	
	public void addSoccerClub(SoccerClub clubDetails) {
		
		SoccerClubDB.getClubMap().put(clubDetails.getClubId(), clubDetails);
	}
	
	public void updateSoccerClub(String clubId, SoccerClub clubDetails) {
		
		SoccerClubDB.getClubMap().put(clubId, clubDetails);
	}
	
}
