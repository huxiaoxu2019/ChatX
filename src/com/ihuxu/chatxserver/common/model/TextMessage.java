package com.ihuxu.chatxserver.common.model;

import java.util.HashMap;

public class TextMessage extends AbstractMessage {

	private static final long serialVersionUID = 5162083703674962610L;
	
	private HashMap<String, String> message = new HashMap<String, String>();
	
	public TextMessage() {
		super(TextMessage.TYPE_TEXT);
	}
	
	public String set(String key, String value) {
		return this.message.put(key, value);
	}
	
	public String get(String key) {
		return this.message.get(key);
	}
	
}
