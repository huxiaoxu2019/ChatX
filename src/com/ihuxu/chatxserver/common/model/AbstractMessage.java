package com.ihuxu.chatxserver.common.model;

import java.io.Serializable;

public abstract class AbstractMessage implements Message, Serializable{

	private static final long serialVersionUID = -4441744578469840165L;
	private int type = Message.TYPE_UNKNOWN;
	
	public AbstractMessage(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}

}
