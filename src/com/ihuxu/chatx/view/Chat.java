package com.ihuxu.chatx.view;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Chat extends CommonView{

	private static final long serialVersionUID = -6919521642788139246L;

	public Chat() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screenSize.width / 2 - 600 /2 , screenSize.height / 2 - 500 / 2);
		this.setSize(600, 500);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setDragable(this);
		this.setVisible(true);
	}
}
