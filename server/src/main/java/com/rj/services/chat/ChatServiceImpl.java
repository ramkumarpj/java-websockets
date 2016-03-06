package com.rj.services.chat;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import com.rj.services.chat.model.Message;
import com.rj.services.chat.websocket.MessageDecoder;
import com.rj.services.chat.websocket.MessageEncoder;

public class ChatServiceImpl implements ChatService {

	public static boolean isUnitTesting;

	private static volatile Map<String, Session> users = new ConcurrentHashMap<String, Session>();
	private MessageEncoder messageEncoder;
	private MessageDecoder messageDecoder;

	public ChatServiceImpl() {
		messageEncoder = new MessageEncoder();
		messageDecoder = new MessageDecoder();
	}

	private void login(String _nickName, Object _session) {

		if (isUnitTesting)
			return;
		
		try {
			if (!users.containsKey(_nickName)) {
				users.put(_nickName, (Session) _session);
				message(new Message(ChatService.LOGIN, _nickName, "joined"));
			} else

			{
				((Session) _session).getBasicRemote().sendText(
						messageEncoder.encode(new Message(ChatService.ERROR,
								_nickName, "Nick already taken!")));
			}
		} catch (IOException | EncodeException e) {
			e.printStackTrace();
		}

	}

	private void logout(String _nickName) {

		if (isUnitTesting)
			return;
		
		users.remove(_nickName);
		message(new Message(ChatService.LOGOUT, _nickName, "left"));
		System.out.println(_nickName + " logged out");
	}

	private void message(Message _message) {

		if (isUnitTesting)
			return;

		for (Map.Entry<String, Session> entry : users.entrySet())
			try {
				((Session) entry.getValue()).getBasicRemote().sendText(
						messageEncoder.encode(_message));
			} catch (IOException | EncodeException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void handleMessage(String _messageStr, Object _session) {

		if (_messageStr != null )
		{
		Message message = messageDecoder.decode(_messageStr);
		if (message.getAction().equalsIgnoreCase(ChatService.LOGIN)) {
			login(message.getNickName(), _session);
		} else if (message.getAction().equalsIgnoreCase(ChatService.LOGOUT)) {
			logout(message.getNickName());
		} else if (message.getAction().equalsIgnoreCase(ChatService.MESSAGE)) {
			message(message);
		} else {
			System.out.println("unknown action received");
		}
		}
		else
		{
			for(Map.Entry<String, Session> entry: users.entrySet())
			{
				if (entry.getValue().equals(_session))
				{
					users.remove(entry.getKey());
					message(new Message(ChatService.LOGOUT, entry.getKey(), "disconnected"));
					System.out.println(entry.getKey() + " disconnected");
				}
			}
		}

	}

}
