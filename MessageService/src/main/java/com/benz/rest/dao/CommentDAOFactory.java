package com.benz.rest.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentDAOFactory {
     
	private static ApplicationContext context = new AnnotationConfigApplicationContext(com.benz.rest.cfgs.SpringConfig.class);

	public static CommentDAO getCommentDAOInstance()
	{
		return (CommentDAO)context.getBean("cdao");
	}
}
