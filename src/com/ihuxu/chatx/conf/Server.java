package com.ihuxu.chatx.conf;

public interface Server {
	
	/**
	 * The server's IP.
	 */
	public static final String HOST = "115.28.36.19";
	
	/**
	 * The server's port to listening.
	 */
	public static final int PORT = 1722;
	
	/**
	 * The interval(milliseconds) to reconnect to the server, while the client do disconnect from the server.
	 * 
	 * For now, the interval milliseconds should be shorter than the server crontab interval miliseconds.
	 * 
	 * @TODO to dispose the server crontab bug.
	 */
	public static final int RECONNECTION_INTERVAL = 5000;
	
	/**
	 * The timeout(milliseconds) of the socket connecting to the server.
	 */
	public static final int SERVER_TIMEOUT = 300000;
}
