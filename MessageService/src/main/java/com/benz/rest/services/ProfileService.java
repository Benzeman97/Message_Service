package com.benz.rest.services;

import java.util.List;

import com.benz.rest.dao.ProfileDAO;
import com.benz.rest.dao.ProfileDAOFactory;
import com.benz.rest.entity.Profile;

public class ProfileService {

	ProfileDAO dao=null;
	
	    
	public List<Profile> getProfiles() throws Exception
	{
		dao = ProfileDAOFactory.getInstance();
		return dao.getProfiles();
	}
	
	public Profile getProfile(int id)  throws Exception
	{
		dao = ProfileDAOFactory.getInstance();
		return dao.getProfile(id);
	}
	public Profile addProfile(Profile prof)  throws Exception
	{
		dao = ProfileDAOFactory.getInstance();
		return dao.addProfile(prof);
	}
	
	public Profile updateProfile(int id,Profile prof)  throws Exception
	{
		dao = ProfileDAOFactory.getInstance();
		return dao.updateProfile(id, prof);
	}
	public Profile deleteProfile(int id)  throws Exception
	{
		dao = ProfileDAOFactory.getInstance();
		return dao.deleteProfile(id);
	}
}
