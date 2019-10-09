package com.benz.rest.entity;

public class Link {

	private String link;
	private String rel;
	
	public Link(String link2, String rel) {
		
		this.link = link2;
		this.rel = rel;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}
	
	
	
	
}
