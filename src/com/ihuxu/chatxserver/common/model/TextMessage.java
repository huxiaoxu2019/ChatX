package com.ihuxu.chatxserver.common.model;


public class TextMessage extends AbstractMessage {

	private static final long serialVersionUID = 5162083703674962610L;
	
	private long to;	
	private String content;
	private long from;
	
	public long getTo() {
		return to;
	}

	public void setTo(long to) {
		this.to = to;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getFrom() {
		return from;
	}

	public void setFrom(long from) {
		this.from = from;
	}
	
	public TextMessage() {
		super(TextMessage.TYPE_TEXT);
	}
	
}
