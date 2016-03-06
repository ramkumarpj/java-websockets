package com.rj.services.chat;

import javax.websocket.EncodeException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.rj.services.chat.model.Message;
import com.rj.services.chat.websocket.MessageEncoder;

public class ChatServiceImplTest {

	@BeforeClass
	public static void setup()
	{
		ChatServiceImpl.isUnitTesting = true;
	}
	
	@Test
	public void handleLoginMessage() throws EncodeException {
		ChatService chatService = new ChatServiceImpl();
		Message message = new Message(ChatService.LOGIN, "ram", "");
		MessageEncoder messageEncoder = new MessageEncoder();
		chatService.handleMessage(messageEncoder.encode(message), null);
	}
	
	@Test
	public void handleLogoutMessage() throws EncodeException {
		ChatService chatService = new ChatServiceImpl();
		Message message = new Message(ChatService.LOGOUT, "ram", "");
		MessageEncoder messageEncoder = new MessageEncoder();
		chatService.handleMessage(messageEncoder.encode(message), null);
	}
	
	@Test
	public void handleMessage() throws EncodeException {
		ChatService chatService = new ChatServiceImpl();
		Message message = new Message(ChatService.MESSAGE, "ram", "Hello");
		MessageEncoder messageEncoder = new MessageEncoder();
		chatService.handleMessage(messageEncoder.encode(message), null);
	}

}
