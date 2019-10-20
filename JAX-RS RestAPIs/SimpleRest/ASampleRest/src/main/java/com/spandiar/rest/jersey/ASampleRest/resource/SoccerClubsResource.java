package com.spandiar.rest.jersey.ASampleRest.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.spandiar.rest.jersey.model.SoccerClub;
import com.spandiar.rest.jersey.service.Authenticator;
import com.spandiar.rest.jersey.service.SoccerClubService;

@Path("soccerclubs")
public class SoccerClubsResource {
	
	private SoccerClubService clubs = new SoccerClubService();

	public SoccerClubsResource() {
		// TODO Auto-generated constructor stub
	}	
	
	@GET
	@Produces(value= {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<SoccerClub> listOfSoccerClubs(@HeaderParam("ApplicationID") String appId, 
											  @HeaderParam("ApplicationPwd") String appPwd,	
											  @QueryParam("league") String league) {
		
	/*	try{
			// check if authorized
			if (Authenticator.isApplicationAuthorized(appId, appPwd)) {
				// return all Soccer Clubs
				return clubs.getAllSoccerClubs(league);
			} else
				return null;
		} catch (Exception e){
			return null;
		}*/
		
		return clubs.getAllSoccerClubs(league);
	}
	
	@GET
	@Path("/{clubId}")
	//@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public SoccerClub getSoccerClub(@PathParam("clubId") String clubId, @Context HttpHeaders headers) {
	
		/*if(Authenticator.isApplicationAuthorized(headers.getHeaderString("ApplicationID"), headers.getHeaderString("ApplicationPwd"))) {
			// return specific Soccer Club
			return clubs.getSoccerClubDetails(clubId);
		}
		else return null;*/
		//return clubs.getSoccerClubDetails(clubId);
		return clubs.getSoccerClubDetails(clubId);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addSoccerClub(SoccerClub clubDetails) {
		// accept and add a new Soccer Club
		clubs.addSoccerClub(clubDetails);
		return "Club added successfully";
	}
	
	@PUT
	@Path("/{clubId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateSoccerClub(@PathParam("clubId") String clubId, SoccerClub clubDetails) {
		
		clubs.updateSoccerClub(clubId, clubDetails);
		return "Hey! I'm inside the PUT method";
		
	}
	
}
