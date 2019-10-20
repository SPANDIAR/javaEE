package com.spandiar.europe.football.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.spandiar.europe.football.database.FootballClubDBModel;
import com.spandiar.europe.football.database.FootballClubData;
import com.spandiar.europe.football.model.FootballClubModel;

public class FootballClubService {
	
	private FootballClubModel clubServiceModel;
	private List<FootballClubModel> clubServiceModelList;
	private FootballClubData footballClubDetails = new FootballClubData();
	private FootballClubDBModel dbClubObject = new FootballClubDBModel();
	private DataPersistance dbSessionObject = new DataPersistance();
	

	public FootballClubService() {
		
	}
	
	public String addFootballClub(FootballClubModel clubToAdd) {
		/*String clubId = clubToAdd.getClubId();
		footballClubDetails.getFootballClubMap().put(clubId, clubToAdd);
		
		if(footballClubDetails.getFootballClubMap().get(clubId) != null) {
			FootballClubModel addedClub = footballClubDetails.getFootballClubMap().get(clubId);
			String response = "Club " + addedClub.getClubId() + " - " + addedClub.getClubName() + " added successfully";
			return response;
		}
		else 
			return "Club could not be added";*/
		
		this.copyToDBModel(clubToAdd);
		dbSessionObject.saveObject(dbClubObject);
		return "lets see";
	}
	
	public Collection<FootballClubModel> getAllFootballClubs() {
		
		//return footballClubDetails.getFootballClubMap().values();
		List<FootballClubDBModel> allClubListDbModel = dbSessionObject.selectAllRecords();
		this.copyToServiceModelList(allClubListDbModel);
		return clubServiceModelList;
		
	}
	
	public FootballClubModel getChosenFootballClub(String clubId) {
		
		//return footballClubDetails.getFootballClubMap().get(clubId);
		dbClubObject = dbSessionObject.selectSpecificObject(clubId);
		this.copyToServiceModel(dbClubObject);
		return clubServiceModel;
	}
	
	public List<FootballClubModel> getChosenClubsFromCountry(String country) {
		
		List<FootballClubDBModel> clubFromCountryList = dbSessionObject.selectSpecificClubsFromCountry(country);
		this.copyToServiceModelList(clubFromCountryList);
		return clubServiceModelList;
	}
	
	public void copyToDBModel(FootballClubModel clubToAdd) {
		
		dbClubObject.setClubId(clubToAdd.getClubId());
		dbClubObject.setClubName(clubToAdd.getClubName());
		dbClubObject.setCountry(clubToAdd.getCountry());
		dbClubObject.setNickName(clubToAdd.getNickName());
		dbClubObject.setStadium(clubToAdd.getStadium());
		dbClubObject.setEstablishedYear(clubToAdd.getEstablishedYear());
		dbClubObject.setCreatedDt(new Date());
		dbClubObject.setModifiedDt(new Date());
	}
	
	public void copyToServiceModel(FootballClubDBModel dbClubObject) {
		clubServiceModel = new FootballClubModel();
		clubServiceModel.setClubId(dbClubObject.getClubId());
		clubServiceModel.setClubName(clubServiceModel.getClubName());
		clubServiceModel.setCountry(dbClubObject.getCountry());
		clubServiceModel.setNickName(dbClubObject.getNickName());
		clubServiceModel.setStadium(dbClubObject.getStadium());
		clubServiceModel.setEstablishedYear(dbClubObject.getEstablishedYear());
	}
	
	public void copyToServiceModelList(List<FootballClubDBModel> allClubListDbModel) {
		
		clubServiceModelList = new ArrayList<FootballClubModel>();
		
		 for(FootballClubDBModel dbModel: allClubListDbModel) {
			 this.copyToServiceModel(dbModel);
			 clubServiceModelList.add(clubServiceModel);
		 }
	}
}
