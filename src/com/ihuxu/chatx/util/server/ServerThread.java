package com.ihuxu.chatx.util.server;

import java.io.IOException;

import com.ihuxu.chatx.view.List;
import com.ihuxu.chatxserver.common.model.MessagePackage;

public class ServerThread extends Thread {
	
	private static boolean serverActive = true;
	
	private List list;
	
	public ServerThread(List list) {
		this.list = list;
	}
	
	public static boolean isServerActive() {
		return serverActive;
	}

	private static void setServerActive(boolean serverActive) {
		ServerThread.serverActive = serverActive;
	}
	
	public void run() {
		while(ServerThread.isServerActive()) {
			try {
				MessagePackage messagePackage = Server.getInstance().readMessagePackage();
				switch(messagePackage.getType()) {
				case MessagePackage.TYPE_CHAT_TEXT_MSG:
					System.out.println("recieve the chat text msg");
					break;
				case MessagePackage.TYPE_LOGIN_FAI_MSG:
					break;
				case MessagePackage.TYPE_LOGIN_SUC_MSG:
					break;
				default:
					throw new Exception("unknown message package type:" + messagePackage.getType());
				}
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				/**
				 * TODO alert the server has gone away.
				 */
				Server.close();
				ServerThread.setServerActive(false);
				e1.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
