package com.benz.rest.dao;

import java.util.List;

import com.benz.rest.entity.Comment;

public interface CommentDAO {

	 List<Comment> getComments(int id);
	 Comment getComment(int mid,long cid);
	Comment addComment(int mid,Comment cmt);
	 Comment updateComment(int mid,long cid,Comment cmt);
	Comment deleteComment(int mid,long cid);
}
