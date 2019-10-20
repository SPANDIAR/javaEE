package com.spandiar.europe.football.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FootballClubModel {
	
	private String clubId;
	private String clubName;
	private String country;
	private String nickName;
	private String stadium;
	private int establishedYear;

	public FootballClubModel() {
		// TODO Auto-generated constructor stub
	}
	
	public FootballClubModel(String clubId, String clubName, String country, String nickName, String stadium, int establishedYear) {
		
		this.clubId = clubId;
		this.clubName = clubName;
		this.country = country;
		this.nickName = nickName;
		this.stadium = stadium;
		this.establishedYear = establishedYear;
	}

	public String getClubId() {
		return clubId;
	}

	public void setClubId(String clubId) {
		this.clubId = clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public int getEstablishedYear() {
		return establishedYear;
	}

	public void setEstablishedYear(int establishedYear) {
		this.establishedYear = establishedYear;
	}
}
