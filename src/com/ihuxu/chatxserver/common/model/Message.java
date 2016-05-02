package com.ihuxu.chatxserver.common.model;

public interface Message {
	
	public static final int TYPE_UNKNOWN = 0;
	public static final int TYPE_TEXT = 1;
	
	public int getType();
	
}
