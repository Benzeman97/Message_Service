package com.benz.rest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Comment")
@Entity
@Table(name="Comment2")
public class Comment {

	@Id
	@Column(name="cid")
	private long id;
	@Column
	private String message;
	@Column
	private Date created;
	@Column
	private String author;
	@Column
	private int mid;
	
	public Comment() {
		
	}

	public Comment(long id, String message, String author) {
		
		this.id = id;
		this.message = message;
		this.author = author;
		created = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}
	
	
	
	
	
	
}
