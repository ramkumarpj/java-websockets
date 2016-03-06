package com.rj.services.chat.websocket;

import java.util.Map;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.rj.services.chat.json.JsonHelper;
import com.rj.services.chat.model.Message;

public class MessageDecoder extends JsonHelper implements Decoder.Text<Message> {

	public MessageDecoder() {
		super();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init(EndpointConfig _endpointConfig) {

		Map<String, Object> userProperties = _endpointConfig
				.getUserProperties();
		for (Map.Entry<String, Object> entry : userProperties.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}

	@Override
	public Message decode(String _json) {

		return (Message) getObject(_json, Message.class);
	}

	@Override
	public boolean willDecode(String _json) {
		
		return  getObject(_json, Message.class) != null ? true : false;
	}
}
