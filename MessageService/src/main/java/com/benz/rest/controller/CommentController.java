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

import com.benz.rest.entity.Comment;
import com.benz.rest.services.CommentService;

@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CommentController {

	@GET
	public List<Comment> getComments(@PathParam("id") int id)
	{
		CommentService cs = new CommentService();
		return cs.getComments(id);
	}
	@GET
	@Path("/{cid}")
	public Comment getComment(@PathParam("id") int mid,@PathParam("cid") long cid)
	{
		CommentService cs = new CommentService();
		return cs.getComment(mid, cid);
	}
	@POST
	public Comment addComment(@PathParam("id") int mid,Comment cmt)
	{
		CommentService cs = new CommentService();
		 return cs.addComment(mid,cmt);
	}
	@PUT
	@Path("/{cid}")
	public Comment updateComment(@PathParam("id") int mid,@PathParam("cid") long cid,Comment cmt)
	{
		CommentService cs = new CommentService();
		return cs.updateComment(mid, cid, cmt);
	}
	
	@DELETE
	@Path("/{cid}")
	public Comment deleteComment(@PathParam("id") int mid,@PathParam("cid") long cid)
	{
		CommentService cs = new CommentService();
		return cs.deleteComment(mid, cid);
	}
}
