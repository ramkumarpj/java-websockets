package com.rj.services.chat;


public interface ChatService {

	public static final String LOGIN    = "LOGIN";
	
	public static final String LOGOUT   = "LOGOUT";
	
	public static final String MESSAGE  = "MESSAGE";
	
	public static final String ERROR  	= "ERROR";
	
	public void handleMessage(String _message, Object _session);
	
}
