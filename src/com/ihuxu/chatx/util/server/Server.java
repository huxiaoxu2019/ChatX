package com.ihuxu.chatx.util.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.ihuxu.chatxserver.common.model.MessagePackage;

public class Server {
	private static Server instance;
	
	private static Socket socket;
	private static ObjectOutputStream out;
	private static ObjectInputStream in;
	
	public static Server getInstance() {
		if(Server.instance == null) {
			Server.instance = new Server();
		}
		return Server.instance;
	}
	
	private Socket getSocket() {
		if(Server.socket == null) {
			try {
				Server.socket = new Socket("127.0.0.1", 1720);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return Server.socket;
	}
	
	private ObjectOutputStream getOutputStream() {
		if(Server.out == null) {
			try {
				Server.out = new ObjectOutputStream(this.getSocket().getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return Server.out;
	}
	
	private ObjectInputStream getInputStream() {
		if(Server.in == null) {
			try {
				Server.in = new ObjectInputStream(this.getSocket().getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return Server.in;
	}
	
	public static void writeMessagePackage(MessagePackage obj) {
		ObjectOutputStream out = Server.getInstance().getOutputStream();
		try {
			out.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static MessagePackage readMessagePackage() throws IOException, ClassNotFoundException {
		ObjectInputStream in = Server.getInstance().getInputStream();
		return (MessagePackage) in.readObject();
	}
	
}
