package com.ihuxu.chatx.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Chat extends CommonView implements MouseListener{

	private static final long serialVersionUID = -6919521642788139246L;

	JPanel backgroundPanel, topPanel, centerPanel, bottomPanel;
	
	JButton closeButton;
	
	public Chat() {
		/** background panel **/
		this.backgroundPanel = new BackgroundPanel();
		this.backgroundPanel.setLayout(null);
		this.backgroundPanel.setPreferredSize(new Dimension(600, 500));
		this.backgroundPanel.setBorder(null);
		this.add(this.backgroundPanel);
		
		/** top panel **/
		this.topPanel = new JPanel();
		this.topPanel.setLayout(null);
		this.topPanel.setBounds(0, 0, 600, 80);
		this.topPanel.setPreferredSize(new Dimension(600, 80));
//		this.topPanel.setOpaque(false);
		this.topPanel.setBackground(new Color(1, 1, 1, 0.5f));
//		this.topPanel.setBackground(Color.RED);
		
		/** close button **/
		this.closeButton = new JButton(new ImageIcon("resource/image/close_press.png"));
		this.closeButton.setBounds(572, -4, 30, 30);
		this.closeButton.setContentAreaFilled(false);
		this.closeButton.setFocusPainted(false);
		this.closeButton.setBorderPainted(false);
		this.closeButton.setOpaque(false);
		this.closeButton.setBorder(null);
		this.closeButton.addMouseListener(this);
		this.backgroundPanel.add(this.closeButton);
		
		this.backgroundPanel.add(this.topPanel);
		
		/** center panel **/
		this.centerPanel = new JPanel();
		this.centerPanel.setPreferredSize(new Dimension(600, 280));
		this.centerPanel.setBounds(0, 80, 600, 280);
		this.centerPanel.setBackground(new Color(1, 1, 1, 0.5f));
//		this.centerPanel.setOpaque(false);
//		this.centerPanel.setBackground(Color.GREEN);
		
		this.backgroundPanel.add(this.centerPanel);
		
		/** bottom panel **/
		this.bottomPanel = new JPanel();
		this.bottomPanel.setPreferredSize(new Dimension(600, 140));
		this.bottomPanel.setBounds(0, 360, 600, 140);
		this.bottomPanel.setBackground(new Color(1, 1, 1, 0.5f));
//		this.bottomPanel.setOpaque(false);
//		this.bottomPanel.setBackground(Color.GRAY);
		
		this.backgroundPanel.add(this.bottomPanel);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screenSize.width / 2 - 600 /2 , screenSize.height / 2 - 500 / 2);
		this.setUndecorated(true);
		this.setSize(new Dimension(600, 500));
		this.setResizable(false);
		this.setDragable(this);
		this.setVisible(true);
	}
	
	
	class BackgroundPanel extends JPanel {
		private static final long serialVersionUID = -8637125902211760622L;
		
	    public void paintComponent(Graphics g) {
	         int x = 0, y = 0;
	         /** if adopt the random image index, then the close button effect is bad, couse of the re-paint maybe.
	         int randomHeadIndex = (int) Math.ceil(Math.random() * 2);
	         ImageIcon icon=new ImageIcon("resource/image/chat_bg_" + randomHeadIndex + ".jpg");
	         **/
	         ImageIcon icon=new ImageIcon("resource/image/chat_bg_3.jpg");
	         g.drawImage(icon.getImage(), x, y, getSize().width, getSize().height, this);
	         /**
	         while(true) {
	        	 g.drawImage(icon.getImage(), x, y, this);
	             if(x > getSize().width && y > getSize().height) break;
	             if(x > getSize().width) {
	            	 x = 0;
	            	 y += icon.getIconHeight();
	             } else {
	            	 x +=icon.getIconWidth();
	             }
	         }
	         **/
	    }
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.closeButton) {
			/** close button clicked event **/
			System.out.println("close button clicked event on the chat window.");
			this.dispose();
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
