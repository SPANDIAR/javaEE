package com.spandiar.rest.jersey.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.spandiar.rest.jersey.model.SoccerClub;

public class GetSoccerClub {

	public GetSoccerClub() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8080/ASampleRest/webapi/");
		WebTarget soccerClub = baseTarget.path("soccerclubs");
		WebTarget getSoccerClub = soccerClub.path("{clubId}");
		
		Response response = getSoccerClub.resolveTemplate("clubId", "LIV")
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		SoccerClub club = response.readEntity(SoccerClub.class);
		System.out.print(club.getClubName());
	}

}
