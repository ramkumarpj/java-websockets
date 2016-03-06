package com.rj.services.chat.websocket;

import java.util.Map;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.rj.services.chat.json.JsonHelper;
import com.rj.services.chat.model.Message;

public class MessageEncoder extends JsonHelper implements Encoder.Text<Message> {

	public MessageEncoder() {
		super();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init(EndpointConfig endpointConfig) {

		Map<String, Object> userProperties = endpointConfig.getUserProperties();
		for (Map.Entry<String, Object> entry : userProperties.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}

	@Override
	public String encode(Message _message) throws EncodeException {

		return getJson(_message);
	}
}
