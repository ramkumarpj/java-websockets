package com.rj.services.chat.model;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nickName;
	
	private Date date;
	
	private String message;
	
	private String action;
	
	public Message()
	{
		
	}
	
	public Message(String _action, String _nickName, String _message)
	{
		action = _action;
		nickName = _nickName;
		message = _message;
		date = new Date();
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
