package com.benz.rest.dao;

import java.util.List;

import com.benz.rest.entity.Profile;

public interface ProfileDAO {

	public List<Profile> getProfiles();
	public Profile getProfile(int id);
	public Profile addProfile(Profile prof);
	public Profile updateProfile(int id,Profile prof);
	public Profile deleteProfile(int id);
	
}
