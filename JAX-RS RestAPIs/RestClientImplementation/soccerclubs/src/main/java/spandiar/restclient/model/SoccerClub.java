package spandiar.restclient.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SoccerClub {
	
	private String clubId;
	private String clubName;
	private String league;
	private String nickName;
	private String stadium;
	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	private int establishedYear;
	

	public SoccerClub() {
		// TODO Auto-generated constructor stub
	}
	
	public SoccerClub(String clubId, String clubName, String league, String nickName, int year) {
		this.clubId = clubId;
		this.clubName = clubName;
		this.league = league;
		this.nickName = nickName;
		this.establishedYear = year;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public int getEstablishedYear() {
		return establishedYear;
	}

	public void setEstablishedYear(int establishedYear) {
		this.establishedYear = establishedYear;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getClubId() {
		return clubId;
	}

	public void setClubId(String clubId) {
		this.clubId = clubId;
	}
	
}

