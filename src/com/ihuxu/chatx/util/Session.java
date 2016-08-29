package com.ihuxu.chatx.util;

import java.util.HashMap;

public class Session {
	
	private static HashMap<String, String> session;
	
	private static HashMap<String, String> getSession() {
		if(Session.session == null) {
			Session.session = new HashMap<String, String>();
		}
		return Session.session;
	}

	public static void set(String key, String value) {
		Session.getSession().put(key, value);
	}
	
	public static String get(String key) {
		return Session.getSession().get(key);
	}
	
}
