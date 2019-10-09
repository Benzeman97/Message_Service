package com.benz.rest.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.benz.rest.entity.Message;
import com.benz.rest.utility.HibUtil;

public class MessageDAOImpl implements MessageDAO{

	@Override
	public List<Message> getMessages() {
		 Transaction tran=null;
		   Session ses=null;
		   List<Message> messages =new ArrayList<Message>();
		   ses =HibUtil.getSession();
		
			   tran=ses.beginTransaction();
			    Query msg = ses.createQuery("from Message order by mid");
			     messages = msg.getResultList();
			    tran.commit();
		   
		   return messages;
	}

	@Override
	public Message getMessage(int id) {
		Transaction tran=null;
		   Session ses=null;
		   ses =HibUtil.getSession();
		   Message msgs=null;

			   tran=ses.beginTransaction();
	           msgs =ses.get(Message.class,id);
			   tran.commit();
		
		   return msgs;
	}

	@Override
	public Message addMessage(Message msg) {
		Transaction tran=null;
		   Session ses=null;
		  
		   ses =HibUtil.getSession();
		   try {
			   tran=ses.beginTransaction();
			   ses.save(msg);
			   tran.commit();
		   }catch(Exception ex)
		   {
			   System.out.println(ex.getMessage());
			   tran.rollback();

		   }
		   return msg; 
	}

	@Override
	public Message updateMessage(int id, Message msg) {
		Transaction tran=null;
		   Session ses=null;
		   Message msegs=null;
		   ses =HibUtil.getSession();
		   try {
			   tran=ses.beginTransaction();
			    msegs = ses.get(Message.class,id);
			      msegs.setMessage(msg.getMessage());
			      msegs.setCreated(msg.getCreated());
			      msegs.setMail(msg.getMail());
			     ses.update(msegs);
			   tran.commit();
		   }catch(Exception ex)
		   {
			   System.out.println(ex.getMessage());
			   tran.rollback();

		   }
		   return msegs;
	}

	@Override
	public Message deleteMessage(int id) {
		Transaction tran=null;
		   Session ses=null;
		   Message msg=null;
		   ses =HibUtil.getSession();
		  
			   tran=ses.beginTransaction();
			  msg = ses.get(Message.class,id);
			  if(msg!=null)
			   ses.delete(msg);
			  else
				  msg =null;
			   tran.commit();
		   
		  return msg;
	}

	@Override
	public List<Message> getMessagesByYear(int year) {
		
		  Transaction tran=null;
		  Session ses=null;
		  List<Message> messages = new ArrayList<Message>();
		  ses = HibUtil.getSession();
		 
			   tran = ses.beginTransaction();
			  Query qu = ses.createQuery("from Message");
			
			      List<Message> messages2 = qu.getResultList();
			      
			      if(messages2!=null)
			      {
			    	  Calendar cal = Calendar.getInstance();
			    for(Message msg : messages2)
			    {
			  
		    		cal.setTime(msg.getCreated());

			    	if((cal.get(Calendar.YEAR))==year)
			    	{
			    		messages.add(msg);
			    		
			    	}
			    }
			     
			      tran.commit();
			    return messages;
			      }else
			    	  return null;
			    
		 
	}

	@Override
	public List<Message> getMessagesByPage(int start, int size) {
		    Transaction tran =null;
		    Session ses=null;
		    List<Message> messages=null;
		     ses=HibUtil.getSession();
		    
		    	  tran = ses.beginTransaction();
		    	     Query qu = ses.createQuery("from Message order by mid");
		    	    messages = qu.getResultList();
		    	 
		    	    if((start+size)<=messages.size())
		    	    {
		    	    
		    	    messages = messages.subList(start,(start+size));
		    	  tran.commit();
		    	  return messages;
		    	    }
		    	    return new ArrayList<Message>();
		     
	}

	
}
