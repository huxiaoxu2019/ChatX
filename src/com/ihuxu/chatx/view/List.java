package com.ihuxu.chatx.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class List extends CommonView implements KeyListener, MouseListener {

	private static final long serialVersionUID = 1101068431445178024L;
	JPanel backgroundPanel, bannerPanel, searchPanel, listPanel, footerPanel;
	JButton closeButton;
	
	public List() {
		
		/** main panel**/
		this.backgroundPanel = new BackgroundPanel();
		this.backgroundPanel.setPreferredSize(new Dimension(280, 700));
		this.add(this.backgroundPanel);
		
		/** banner **/
		this.bannerPanel = new JPanel();
		this.bannerPanel.setLayout(null);
		this.bannerPanel.setPreferredSize(new Dimension(280, 110));
		this.bannerPanel.setBackground(Color.red);
//		this.bannerPanel.setOpaque(false);
		
		/** close button **/
		this.closeButton = new JButton(new ImageIcon("resource/image/close_press.png"));
		this.closeButton.setBounds(250, -8, 30, 30);
		this.closeButton.setContentAreaFilled(false);
		this.closeButton.setFocusPainted(false);
		this.closeButton.setBorderPainted(false);
		this.closeButton.setOpaque(false);
		this.closeButton.setBorder(null);
		this.closeButton.addMouseListener(this);
		this.bannerPanel.add(this.closeButton);
		this.backgroundPanel.add(this.bannerPanel);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screenSize.width / 2 - 280 /2 , screenSize.height / 2 - 700 / 2);
		this.setUndecorated(true);
		this.setSize(new Dimension(280, 700));
		this.setResizable(false);
		this.setDragable(this);
		this.setVisible(true);
	}
	
	
	class BackgroundPanel extends JPanel {
		private static final long serialVersionUID = -8637125902711760622L;
		
	    public void paintComponent(Graphics g) {
	         int x = 0, y = 0;
	         ImageIcon icon=new ImageIcon("resource/image/list_bg.jpg");
	         g.drawImage(icon.getImage(), x, y, getSize().width, getSize().height, this);
	         while(true) {
	        	 g.drawImage(icon.getImage(), x, y, this);
	             if(x > getSize().width && y > getSize().height)break;
	             if(x > getSize().width) {
	            	 x = 0;
	            	 y += icon.getIconHeight();
	             } else {
	            	 x +=icon.getIconWidth();
	             }
	         }
	    }
	}
	      

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
