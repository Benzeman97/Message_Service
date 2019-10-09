package com.benz.rest.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageDAOFactory {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(com.benz.rest.cfgs.SpringConfig.class);
	public static MessageDAO getInstance()
	{
		return (MessageDAO)context.getBean("factory");
	}
}
