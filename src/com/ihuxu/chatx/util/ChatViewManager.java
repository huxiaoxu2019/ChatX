package com.ihuxu.chatx.util;

import java.util.HashMap;
import com.ihuxu.chatx.view.Chat;


public class ChatViewManager {
	private static HashMap<String, Chat> chatViewHashMap = new HashMap<String, Chat>();
	
	public static Chat getChatView(String key) throws Exception {
		if(ChatViewManager.chatViewHashMap.containsKey(key)) {
			return ChatViewManager.chatViewHashMap.get(key);
		} else {
			throw new Exception("There is not the Chat in the chatHashMap variable.");
		}
	}
	
	public static Chat setChatView(String key, Chat chat) {
		return ChatViewManager.chatViewHashMap.put(key, chat);
	}
	
	public static boolean addChatView(String key, Chat chat) {
		if(!ChatViewManager.chatViewHashMap.containsKey(key)) {
			ChatViewManager.chatViewHashMap.put(key, chat);
			return true;
		}
		return false;
	}

	public static void removeChatView(String key) {
		ChatViewManager.chatViewHashMap.remove(key);
	}

	public static int getChatViewsCount() {
		return ChatViewManager.chatViewHashMap.size();
	}
}
