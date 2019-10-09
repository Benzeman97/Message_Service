package com.benz.rest.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Message")
@Entity
@Table(name="message")
public class Message {

	@Id
	@Column
	private int mid;
	@Column
	private String message;
	@Column
	private Date created;
	@Column
	private String author;
	
    @Transient
	private List<Link> links=new ArrayList<Link>();
	
	
	public Message() {
		
	}
	public Message(int mid, String message, String mail) {
	
		this.mid = mid;
		this.message = message;
		this.author = mail;
		created =new Date();
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
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
	public String getMail() {
		return author;
	}
	public void setMail(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void addLinks(String link2,String rel)
	{
		Link link = new Link(link2,rel);
		 this.getLinks().add(link);
	}
	
	
	
	
}
