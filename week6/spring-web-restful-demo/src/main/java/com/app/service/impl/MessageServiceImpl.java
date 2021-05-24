package com.app.service.impl;

import java.util.List;

import com.app.model.Message;
import com.app.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	private static Map<Integer, Message> map = new HashMap<>();
	private static int counter;
	
	@Override
	public Message addMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message updateMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message getMessageById(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getAllMessages(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getMessagesByUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
