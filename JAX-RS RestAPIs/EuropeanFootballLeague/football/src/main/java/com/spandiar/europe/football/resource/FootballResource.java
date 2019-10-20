package com.spandiar.europe.football.resource;

import java.util.Collection;
import java.util.Map;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.spandiar.europe.football.model.FootballClubModel;
import com.spandiar.europe.football.service.FootballClubService;

@Path("league")
//@Singleton
public class FootballResource {
	
	@QueryParam("country") private String country;
	@PathParam("clubId") private String clubId;
	
	private FootballClubService footballClub;

	public FootballResource() {
		footballClub = new FootballClubService();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Collection<FootballClubModel> getFootballClubs() {
		if(country != null) {
			return footballClub.getChosenClubsFromCountry(country);
		} else {
		return footballClub.getAllFootballClubs();
		}
	}
	
	@GET
	@Path("{clubId}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public FootballClubModel getClubDetails() {
		return footballClub.getChosenFootballClub(clubId);
	}
	
	@POST
	public String addFootballClub(FootballClubModel clubToAdd) {
		return footballClub.addFootballClub(clubToAdd);
	}
}
