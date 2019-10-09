package com.benz.rest.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.benz.rest.entity.Profile;
import com.benz.rest.utility.HibUtil;

public class ProfileDAOImpl implements ProfileDAO{

	@Override
	public List<Profile> getProfiles() {
		 Transaction tran = null;
		 Session ses=null;
		 List<Profile> profiles;
		 ses=HibUtil.getSession();
		 try {
			 tran = ses.beginTransaction();
			 Query prof = ses.createQuery("from Profile order by pid asc");
			  profiles = prof.getResultList();
			  tran.commit();
			  return profiles;
		 }catch(Exception ex)
		 {
			 System.out.println(ex.getMessage());
			 tran.rollback();
			 return null;
		 }
	}

	@Override
	public Profile getProfile(int id) {
		Transaction tran = null;
		 Session ses=null;
		 ses=HibUtil.getSession();
		 try {
			 tran = ses.beginTransaction();
			 Profile prof= ses.get(Profile.class, id);
			  tran.commit();
			  return prof;
		 }catch(Exception ex)
		 {
			 System.out.println(ex.getMessage());
			 tran.rollback();
			 return null;
		 }
	}

	@Override
	public Profile addProfile(Profile prof) {
		Transaction tran = null;
		 Session ses=null;
		
		 ses=HibUtil.getSession();
		 try {
			 tran = ses.beginTransaction();
			   ses.save(prof);
			  tran.commit();
			  return prof;
		 }catch(Exception ex)
		 {
			 System.out.println(ex.getMessage());
			 tran.rollback();
			 return null;
		 }
	}

	@Override
	public Profile updateProfile(int id, Profile prof) {
		Transaction tran = null;
		 Session ses=null;
		 Profile p=null;
		 ses=HibUtil.getSession();
		 try {
			 tran = ses.beginTransaction();
			  p = ses.get(Profile.class, id);
			  if(p!=null)
			  {
				  p.setPname(prof.getPname());
				  p.setFname(prof.getFname());
				  p.setLname(prof.getLname());
				  p.setCreated(prof.getCreated());
				  ses.update(p);
				  tran.commit();
				  return p;
			  }else
				  return null;
		 }catch(Exception ex)
		 {
			 System.out.println(ex.getMessage());
			 tran.rollback();
			 return null;
		 }
	}

	@Override
	public Profile deleteProfile(int id) {
		Transaction tran = null;
		 Session ses=null;
		 Profile p=null;
		 ses=HibUtil.getSession();
		 try {
			 tran = ses.beginTransaction();
			  p = ses.get(Profile.class, id);
			  if(p!=null)
			  {
				  ses.delete(p);
				  tran.commit();
				  return p;
			  }else
				  return null;
			  
		 }catch(Exception ex)
		 {
			 System.out.println(ex.getMessage());
			 tran.rollback();
			 return null;
		 }
	}

	
}
