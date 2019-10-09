package com.benz.rest.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.benz.rest.cfgs.SpringConfig;

public class ProfileDAOFactory {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
	public static ProfileDAO getInstance()
	{
		return (ProfileDAO)context.getBean("pdao");
	}
	
}
