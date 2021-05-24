package com.app.service;

import java.util.List;

import com.app.model.Message;

public interface MessageService {

	public Message addMessage(Message message);
	public Message updateMessage(Message message);
	public Message getMessageById(Message message);
	public List<Message> getAllMessages(Message message);
	public List<Message> getMessagesByUser(String userName);
}
