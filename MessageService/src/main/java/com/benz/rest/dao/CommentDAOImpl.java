package com.benz.rest.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.benz.rest.entity.Comment;
import com.benz.rest.utility.HibUtil;

public class CommentDAOImpl implements CommentDAO {

	@Override
	public List<Comment> getComments(int id) {
		Transaction tran=null;
		Session ses=null;
		List<Comment> comments=null;
		 ses=HibUtil.getSession();
		 try {
			 System.out.println(id);
			 tran = ses.beginTransaction();
			   Query qu =  ses.createQuery("from Comment where mid="+id);
			 comments = qu.getResultList();
			 System.out.println(comments);
			 for(Comment c : comments)
			 {
				 System.out.println(c.getId());
			 }
			      tran.commit();
		 }catch(Exception ex)
		 {
			 System.out.println(ex.getMessage());
		 }
		 return comments;
	}

	@Override
	public Comment getComment(int mid, long cid) {
		Transaction tran=null;
		Session ses=null;
		Comment comment=null;
		 ses=HibUtil.getSession();
		 try {
			 tran = ses.beginTransaction();
			   Query qu =  ses.createQuery("from Comment where mid="+mid+" and id="+cid);
			    comment =(Comment) qu.getSingleResult();
			      tran.commit();
		 }catch(Exception ex)
		 {
			 System.out.println(ex.getMessage());
		 }
		 return comment;
	}
  
	@Override
	public Comment addComment(int mid, Comment cmt) {
		Transaction tran=null;
		Session ses=null;
		ses = HibUtil.getSession();
		try {
			tran = ses.beginTransaction();
			cmt.setMid(mid);
			ses.save(cmt);
			tran.commit();
			return cmt;
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
		
	}

	@Override
	public Comment updateComment(int mid, long cid, Comment cmt) {
		Transaction tran=null;
		Session ses=null;
		Comment comment=null;
		ses = HibUtil.getSession();
		try {
			tran = ses.beginTransaction();
			  comment = ses.get(Comment.class,cid);
			  if(comment!=null)
			  {
				   comment.setMessage(cmt.getMessage());
				   comment.setCreated(cmt.getCreated());
				   comment.setAuthor(cmt.getAuthor());
				    ses.update(comment);
			
			  }
			tran.commit();
			return comment;
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
		
	}

	@Override
	public Comment deleteComment(int mid, long cid) {
		Transaction tran=null;
		Session ses=null;
		Comment comment=null;
		ses = HibUtil.getSession();
		try {
			tran = ses.beginTransaction();
			 Query qu =  ses.createQuery("from Comment where mid="+mid+" and cid="+cid);
			    comment =(Comment) qu.getSingleResult();
			  if(comment!=null)
			  {
				   ses.delete(comment);
				   tran.commit();
					return comment;
			  }else
				  return null;
			
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return null;
		}
		
	}
   
}
