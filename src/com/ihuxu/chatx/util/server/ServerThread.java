package com.ihuxu.chatx.util.server;

import java.io.IOException;

import com.ihuxu.chatx.conf.Common;
import com.ihuxu.chatx.util.Session;
import com.ihuxu.chatx.view.List;
import com.ihuxu.chatxserver.common.model.MessagePackage;
import com.ihuxu.chatxserver.common.model.TextMessage;

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
					this.list.appendTextMessage(messagePackage.getTextMessage());
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
				e1.printStackTrace();
				/**
				 * TODO alert the server has gone away.
				 */
				Server.getInstance().close();
				ServerThread.setServerActive(false);

				/** re-login to the server untill the server is connected. **/
				while(ServerThread.isServerActive() == false) {
					System.out.println("reconnection to start in " + com.ihuxu.chatx.conf.Server.RECONNECTION_INTERVAL + " milliseconds...");
					try {
						Thread.sleep(com.ihuxu.chatx.conf.Server.RECONNECTION_INTERVAL);
					} catch (InterruptedException e2) {
						e2.printStackTrace();
					}
					try {
						long uid = Long.parseLong(Session.get(Common.SESSION_USER_KEY));
						String password = Session.get(Common.SESSION_USER_PWD);
						TextMessage tM = new TextMessage();
						tM.setFrom(uid);
						tM.setContent(password);
						MessagePackage mP = new MessagePackage(MessagePackage.TYPE_LOGIN_MSG);
						mP.setTextMessage(tM);
						Server.getInstance().writeMessagePackage(mP);
						MessagePackage response = Server.getInstance().readMessagePackage();
						if(response.getType() == MessagePackage.TYPE_LOGIN_SUC_MSG) {
							System.out.println("The re-connect to server that is successfull。");
							ServerThread.setServerActive(true);
						} else {
							System.out.println("The re-connect to server that is failed, so sleep 1 second to re-connect...");
							
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
