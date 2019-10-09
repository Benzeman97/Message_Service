package com.benz.rest.cfgs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.benz.rest.controller.CommentController;
import com.benz.rest.dao.CommentDAO;
import com.benz.rest.dao.CommentDAOImpl;
import com.benz.rest.dao.MessageDAO;
import com.benz.rest.dao.MessageDAOImpl;
import com.benz.rest.dao.ProfileDAO;
import com.benz.rest.dao.ProfileDAOImpl;
import com.benz.rest.services.MessageService;
import com.benz.rest.services.ProfileService;

@Configuration
public class SpringConfig {

	@Bean(name="factory")
	@Scope(value="prototype")
	public MessageDAO getMessageDAOImpl()
	{
		return new MessageDAOImpl();
	}
	
	@Bean(name="service")
	@Scope(value="prototype")
	public MessageService getMessageSErvice()
	{
		return new MessageService();
	}
	
	@Bean(name="pdao")
	@Scope(value="prototype")
	public ProfileDAO getProfileImpl()
	{
		return new ProfileDAOImpl();
	}
	
	@Bean(name="profile")
	@Scope(value="prototype")
	public ProfileService getProfileService()
	{
		return new ProfileService();
	}
	
	@Bean(name="cc")
	@Scope(value="prototype")
	public CommentController getCommentController()
	{
		return new CommentController();
	}
	
	@Bean(name="cdao")
	@Scope(value="prototype")
	public CommentDAO getCommentDAO()
	{
		return new CommentDAOImpl();
	}
}
