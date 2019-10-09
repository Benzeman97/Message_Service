package com.benz.rest.services;

import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.benz.rest.dao.MessageDAO;
import com.benz.rest.dao.MessageDAOFactory;
import com.benz.rest.entity.ErrorMessage;
import com.benz.rest.entity.Message;
import com.benz.rest.exception.ExplicitException;



public class MessageService {

	MessageDAO dao =null;
	public List<Message> getMessages()
	{
		
		  dao = MessageDAOFactory.getInstance();
		  return dao.getMessages();
		  	
	}
	
	public Message getMessage(int id) throws ExplicitException  {
		Message msg=null;;
		  dao = MessageDAOFactory.getInstance();
		   msg = dao.getMessage(id);
		    if(msg==null) {
		    	
		    	//throw new DataNotFoundException("Message with Id "+id+" not found");
		    	throw new ExplicitException("Message with Id "+id+" not found");
		    }
		    
		    return msg;
			  
		   
	}
	
	public Message addMessage(Message msg)
	{
		  dao = MessageDAOFactory.getInstance();
		  return dao.addMessage(msg);
	}
	
	public Message updateMessage(int id,Message msg)
	{
		  dao = MessageDAOFactory.getInstance();
		  return dao.updateMessage(id, msg);
	}
	public Message deleteMessage(int id)
	{
		  dao = MessageDAOFactory.getInstance();
		    return dao.deleteMessage(id);
	}
	public List<Message> getMessagesByYear(int year)
	{
		dao = MessageDAOFactory.getInstance();
		return dao.getMessagesByYear(year);
	}
	public List<Message> getMessagesByPage(int start,int size)
	{
		dao = MessageDAOFactory.getInstance();
		 return dao.getMessagesByPage(start,size);
		  
	}
}
