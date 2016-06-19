package com.ihuxu.chatx.model;

import java.io.IOException;

import com.ihuxu.chatx.conf.Common;
import com.ihuxu.chatx.util.Session;
import com.ihuxu.chatx.util.server.Server;
import com.ihuxu.chatxserver.common.model.MessagePackage;
import com.ihuxu.chatxserver.common.model.TextMessage;

public class Member {
	
	public static boolean checkLogin(long uid, String password) throws ClassNotFoundException, IOException {
		Session.set(Common.SESSION_USER_KEY, Long.toString(uid));
		Session.set(Common.SESSION_USER_PWD, password);
		TextMessage tM = new TextMessage();
		tM.setFrom(uid);
		tM.setContent(password);
		MessagePackage mP = new MessagePackage(MessagePackage.TYPE_LOGIN_MSG);
		mP.setTextMessage(tM);
		Server.getInstance().writeMessagePackage(mP);
		MessagePackage response = Server.getInstance().readMessagePackage();
		if(response.getType() == MessagePackage.TYPE_LOGIN_SUC_MSG) {
			return true;
		}
		return false;
	}
}
