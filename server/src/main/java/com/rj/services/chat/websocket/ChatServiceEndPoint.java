package com.rj.services.chat.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.rj.services.chat.ChatService;
import com.rj.services.chat.ChatServiceImpl;

@ServerEndpoint("/chat")
public class ChatServiceEndPoint {

	private ChatService chatService;
	
	public ChatServiceEndPoint()
	{
		chatService = new ChatServiceImpl();
	}
	
	@OnOpen
	public void open(Session _session) {
		System.out.println("ChatServiceEndPoint :: OnOpen Called");
	}

	@OnClose
	public void close(Session _session) {
		System.out.println("ChatServiceEndPoint :: OnClose Called");
		chatService.handleMessage(null, _session);
	}

	@OnError
	public void onError(Throwable error) {
		System.out.println("ChatServiceEndPoint :: OnError Called");
	}

	@OnMessage
	public void handleMessage(String _message, Session _session) {
		System.out.println("ChatServiceEndPoint :: handleMessage Called");
		chatService.handleMessage(_message, _session);
	}
}
