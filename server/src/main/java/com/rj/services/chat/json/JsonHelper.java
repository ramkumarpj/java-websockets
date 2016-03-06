package com.rj.services.chat.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {
	ObjectMapper mapper;

	public JsonHelper() {
		mapper = new ObjectMapper();
	}

	protected String getJson(Object _object) {
		try {
			return mapper.writeValueAsString(_object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected Object getObject(String json, Class<?> _class) {
		try {
			return mapper.readValue(json, _class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
