package com.ihuxu.chatx.model;

import com.ihuxu.chatx.conf.Common;
import com.ihuxu.chatx.util.Session;
import com.ihuxu.chatx.util.server.Server;
import com.ihuxu.chatxserver.common.model.MessagePackage;
import com.ihuxu.chatxserver.common.model.TextMessage;

public class Chat {
	public static void sendTextMsg(String content) throws Exception {
		long uid;
		if(Session.get(Common.SESSION_USER_KEY).isEmpty()) {
			throw new Exception("unvalid session user key");
		} else {
			uid = Long.parseLong(Session.get(Common.SESSION_USER_KEY));
			TextMessage tM = new TextMessage();
			tM.setFrom(uid);
			tM.setTo(uid);
			tM.setContent(content);
			MessagePackage mP = new MessagePackage(MessagePackage.TYPE_CHAT_TEXT_MSG);
			mP.setTextMessage(tM);
			Server.getInstance().writeMessagePackage(mP);
		}
	}
	public static void sendImgMsg(String content) {}
}
