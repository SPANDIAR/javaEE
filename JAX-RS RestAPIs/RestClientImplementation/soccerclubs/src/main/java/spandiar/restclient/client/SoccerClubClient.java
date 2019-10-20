package spandiar.restclient.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import spandiar.restclient.model.SoccerClub;

public class SoccerClubClient {
	
	private Client client;
	WebTarget rootTarget;

	public SoccerClubClient() {
		client = ClientBuilder.newClient();
		rootTarget = client.target("http://localhost:8080/ASampleRest/webapi/soccerclubs/");
	}
	
	public Invocation getSoccerClub(String clubId) {
		
		Invocation buildGet = this.rootTarget.path(clubId).request().buildGet();
		return buildGet;
	}
	
	public Invocation addSoccerClub(SoccerClub newClub) {
		
		Invocation addClubInvoker = rootTarget.request().buildPost(Entity.json(newClub));
		return addClubInvoker;
	}
	
	public Invocation getClubsInLeague(String league) {
		
		Invocation leagueInvoker = rootTarget.queryParam("league", league).request().buildGet();
		return leagueInvoker;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SoccerClubClient club = new SoccerClubClient();
		
		// Get a club
		/*
		Invocation getClub = club.getSoccerClub("MIL");
		Response getSoccerClub = getClub.invoke();
		
		if (getSoccerClub.getStatus() == 200) {
			System.out.println("Club details received successfully");
			System.out.println(getSoccerClub.readEntity(String.class));
		}
		
		// Add a club
		
		SoccerClub newClub = new SoccerClub("SOU", "Sothhampton United", "EPL", "the Southerners", 1905);
		Invocation addClubInvoker = club.addSoccerClub(newClub);
		Response addClubResponse = addClubInvoker.invoke();
		
		if(addClubResponse.getStatus() == 200) {
			System.out.print(addClubResponse.readEntity(String.class));
		}*/
		
		// Get a list of clubs
		
		Invocation leagueInvoker = club.getClubsInLeague("EPL");
		Response leagueClubsResponse = leagueInvoker.invoke();
		if (leagueClubsResponse.getStatus() == 200) {
			List<SoccerClub> leagueClubs = leagueClubsResponse.readEntity(new GenericType<List<SoccerClub>>(){});
			System.out.print("Size of the list is " + leagueClubs.size());
			for(SoccerClub leagueResponse : leagueClubs ) {
				System.out.println("Club Name is: " + leagueResponse.getClubName());
			}
		}
	}
}
