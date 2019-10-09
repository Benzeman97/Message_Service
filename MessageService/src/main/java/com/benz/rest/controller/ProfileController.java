package com.benz.rest.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.benz.rest.cfgs.SpringConfig;
import com.benz.rest.entity.Profile;
import com.benz.rest.services.ProfileService;

@Path("/profiles")
public class ProfileController {

	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Profile> getProfiles() throws Exception
	{
		ProfileService ps = context.getBean(ProfileService.class);
		return ps.getProfiles();
	}
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Profile getProfile(@PathParam("id") int id) throws Exception
	{
		ProfileService ps = context.getBean(ProfileService.class);
             return ps.getProfile(id);
	}
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Profile addProfile(Profile prof) throws Exception
	{
		ProfileService ps = context.getBean(ProfileService.class);
		return ps.addProfile(prof);
	}
	@PUT
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Profile updateProfile(@PathParam("id") int id,Profile prof) throws Exception
	{
		ProfileService ps = context.getBean(ProfileService.class);
		return ps.updateProfile(id, prof);
	}
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Profile deleteProfile(@PathParam("id") int id) throws Exception
	{
		ProfileService ps = context.getBean(ProfileService.class);
		 return ps.deleteProfile(id);
	}
}
