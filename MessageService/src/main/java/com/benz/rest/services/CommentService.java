package com.benz.rest.services;

import java.util.List;

import com.benz.rest.dao.CommentDAO;
import com.benz.rest.dao.CommentDAOFactory;
import com.benz.rest.entity.Comment;

public class CommentService {

	public List<Comment> getComments(int id)
	{
		  CommentDAO dao =  CommentDAOFactory.getCommentDAOInstance();
		  return dao.getComments(id);
	}
	
	public Comment getComment(int mid,long cid)
	{
		  CommentDAO dao =  CommentDAOFactory.getCommentDAOInstance();
		   return dao.getComment(mid, cid);

	}
	public Comment addComment(int mid,Comment cmt)
	{
		  CommentDAO dao =  CommentDAOFactory.getCommentDAOInstance();
            return dao.addComment(mid, cmt);
	}
	public Comment updateComment(int mid,long cid,Comment cmt)
	{
		  CommentDAO dao =  CommentDAOFactory.getCommentDAOInstance();
               return dao.updateComment(mid, cid, cmt);
	}
	public Comment deleteComment(int mid,long cid)
	{
		  CommentDAO dao =  CommentDAOFactory.getCommentDAOInstance();
                  return dao.deleteComment(mid, cid);
	}
}
