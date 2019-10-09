package com.benz.rest.dao;

import java.util.List;

import com.benz.rest.entity.Message;

public interface MessageDAO {

	public List<Message> getMessages();
	public Message getMessage(int id);
	public Message addMessage(Message msg);
	public Message updateMessage(int id,Message msg);
	public Message deleteMessage(int id);
	public List<Message> getMessagesByYear(int year);
	public List<Message> getMessagesByPage(int start,int size);
}
