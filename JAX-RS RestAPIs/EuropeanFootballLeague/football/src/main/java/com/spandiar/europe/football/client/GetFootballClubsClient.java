package com.spandiar.europe.football.client;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.util.Base64;

import com.spandiar.europe.football.model.FootballClubModel;

public class GetFootballClubsClient {
	
	private static Client client;
	private static WebTarget rootTarget;
	private static final String USERNAME = "football";
	private static final String PASSWORD = "thegreatestgame";
	private static final String AUTHORIZATION = "Authorization";

	private static String authValue;
	
	public GetFootballClubsClient() {
		
		client = ClientBuilder.newClient();
		rootTarget = client.target("http://localhost:8080/football/europe/league");
		authValue = Base64.encodeAsString(USERNAME + ":" + PASSWORD);
	}
	
	public void getAllFootballClubs() {
		
		Invocation invoker = rootTarget.request().header(AUTHORIZATION, authValue).buildGet();
		Response allFootballClubsResponse = invoker.invoke();
		if (allFootballClubsResponse.getStatus() == 200) {
			List<FootballClubModel> allFootballClubs = allFootballClubsResponse.readEntity(new GenericType<List<FootballClubModel>>() {});
			System.out.println(" CLubs Size: " + allFootballClubs.size());
			//System.out.println(" CLubs Size: " + allFootballClubs.);
			for(FootballClubModel club: allFootballClubs) {
				System.out.println("Club: " + club.getClubId() + " " + club.getClubName() + " " + club.getNickName());
			}
			
		} else {
			String readEntity = allFootballClubsResponse.readEntity(String.class);
			System.out.println("Oops!! something went wrong " + readEntity);
		}
	}
	
	public void getAllFootballClubsByCountry() {
		
	}
	
	public void getFootballClubDetails() {
		
	}
	

	public static void main(String[] args) {
		
		GetFootballClubsClient footballClient = new GetFootballClubsClient();
		footballClient.getAllFootballClubs();
		
	}
}
