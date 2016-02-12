package com.ihuxu.chatx.test;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ihuxu.chatx.view.TransparentJPanel;

public class TPanel extends JFrame{

	private static final long serialVersionUID = 6179017766517354667L;

	public static void main(String args[]) {
		new TPanel();
	} 
	
	public TPanel() {
		JPanel jp1;
		JPanel jp2;
		jp1 = new JPanel();
		jp1.setBounds(0, 0, 400, 200);
		jp1.setBackground(Color.GREEN);
		
		jp2 = new JPanel();
		
		jp2.setBounds(0, 0, 400, 120);
		jp2.setBackground(new Color(0.4f, 0.2f, 0.5f, 0.95f));
		

		this.add(jp2);
		this.add(jp1);
		this.setLayout(null);
		this.setSize(400, 300);
		this.setVisible(true);
	}
	
}
