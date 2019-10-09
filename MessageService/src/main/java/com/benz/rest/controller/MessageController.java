package com.benz.rest.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import com.benz.rest.entity.Message;
import com.benz.rest.exception.ExplicitException;
import com.benz.rest.services.MessageService;

@Controller
@Path("/messages")
public class MessageController {
     
	ApplicationContext context = new AnnotationConfigApplicationContext(com.benz.rest.cfgs.SpringConfig.class);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Message> getMessages()
	{
		 MessageService ms = context.getBean(MessageService.class);
           return ms.getMessages();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Message getMessage(@PathParam("id") int id,@Context UriInfo uriInfo) throws ExplicitException
	{
	
		MessageService ms = context.getBean(MessageService.class);
		Message msg = ms.getMessage(id);
		String uri = uriInfo.getBaseUriBuilder().path(MessageController.class).path(Integer.toString(msg.getMid())).build().toString();
		   msg.addLinks(uri,"self");
		   msg.addLinks(getUriForProfile(uriInfo,msg),"profile");
		   msg.addLinks(getUriForComments(uriInfo,msg),"comments");
		   return msg;
	}
	public String getUriForProfile(UriInfo uriInfo,Message message)
	{
		URI uri = uriInfo.getBaseUriBuilder().path(ProfileController.class).path(message.getAuthor()).build();
		 return uri.toString();
	}
	
	public String getUriForComments(UriInfo uriInfo,Message message)
	{
		URI uri = uriInfo.getBaseUriBuilder().path(MessageController.class).path(MessageController.class,"commentService").resolveTemplate("id",message.getMid()).build();
	      return uri.toString();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Message addMessage(Message msg)
	{
		MessageService ms = context.getBean(MessageService.class);
		  return ms.addMessage(msg);
	}
	
	@PUT
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Message updateMessage(@PathParam("id") int id,Message msg) {
		
		MessageService ms = context.getBean(MessageService.class);
		  return ms.updateMessage(id, msg);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Message deleteMessage(@PathParam("id") int id)
	{
		MessageService ms = context.getBean(MessageService.class);
		return ms.deleteMessage(id);
	}
	
	
	@Path("/{id}/comments")
	public CommentController commentService()
	{
		return (CommentController)context.getBean("cc");
	}
	
	@GET
	@Path("/years/{year}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Message> getMessageByYear(@PathParam("year") int year)
	{
		MessageService ms = context.getBean(MessageService.class);
           if(year>0)
		  return ms.getMessagesByYear(year);
           else
        	   return null;
	}
	
	@GET
	@Path("/{start}/{size}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Message> getMessagesByPage(@PathParam("start")int start,@PathParam("size") int size)
    {
		if(start>=0 && size>0)
		{
			MessageService ms = context.getBean(MessageService.class);
			   return ms.getMessagesByPage(start, size);
		}else
			return new ArrayList<Message>();
    }
}
