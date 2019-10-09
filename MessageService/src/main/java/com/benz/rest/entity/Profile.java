package com.benz.rest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Profile")
@Entity
@Table(name="Profile")
public class Profile {
	
	@Id
	@Column
	private int pid;
	@Column
	private String pname;
	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private Date created;
	
	
	public Profile() {
		
	}


	public Profile(int pid, String pname,String fname,String lname) {
		
		this.pid = pid;
		this.pname = pname;
		this.fname=fname;
		this.lname=lname;
		created = new Date();
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}
	
	
	

}
