package com.benz.rest.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibUtil {

	private static ThreadLocal<Session> thl = new ThreadLocal<Session>();
	  private static SessionFactory factory=null;
	  
	  static {
		  
		  factory = new Configuration().configure("com/benz/rest/cfgs/hibernate.cfg.xml").buildSessionFactory();
	  }
	  
	  public static Session getSession()
	  {
		  Session ses=null;
		  if(thl.get()!=null)
		  {
			  ses=thl.get();
		  }else
		  {
			  ses = factory.openSession();
			  thl.set(ses);
		  }
		  return ses;
	  }
	  
	  public static void closeSession()
	  {
		  Session ses=null;
		  if(thl.get()!=null)
		  {
			  ses =thl.get();
			  ses.close();
			  thl.remove();
		  }
	  }
	  public static void closeFactory()
	  {
		  factory.close();
	  }
}
