package com.ihuxu.chatx.test;


import java.awt.Dimension;

import javax.swing.*;
public class Button extends JFrame {

	public static void main(String args[]) {
		new Button();
	}
	public Button() {
		
		JButton button = new JButton("login");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		button.setBounds(10, 10, 100, 30);
		panel.add(button);
		
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setUndecorated(true);
		this.setTitle("ChatX");
		this.setSize(400, 300);
		this.setResizable(false);
		this.setVisible(true);
	}
}
