package com.ihuxu.chatx.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class List extends CommonView implements KeyListener, MouseListener {

	private static final long serialVersionUID = 1101068431445178024L;
	JPanel backgroundPanel, bannerPanel, searchPanel, listPanel, footerPanel;
	JButton closeButton;
	JLabel leftTopTitleLabel, avatarLabel, nickNameLabel, searchLabel;
	JTextField searchInput;
	
	public List() {
		
		/** main panel**/
		this.backgroundPanel = new BackgroundPanel();
		this.backgroundPanel.setLayout(null);
		this.backgroundPanel.setPreferredSize(new Dimension(280, 700));
		this.add(this.backgroundPanel);
		
		/** banner **/
		this.bannerPanel = new JPanel();
		this.bannerPanel.setLayout(null);
		this.bannerPanel.setBounds(0, 0, 280, 110);
		this.bannerPanel.setPreferredSize(new Dimension(280, 110));
		this.bannerPanel.setOpaque(false);
		
		/** close button **/
		this.closeButton = new JButton(new ImageIcon("resource/image/close_press.png"));
		this.closeButton.setBounds(254, -4, 30, 30);
		this.closeButton.setContentAreaFilled(false);
		this.closeButton.setFocusPainted(false);
		this.closeButton.setBorderPainted(false);
		this.closeButton.setOpaque(false);
		this.closeButton.setBorder(null);
		this.closeButton.addMouseListener(this);
		this.bannerPanel.add(this.closeButton);
		
		/** leftTop label **/
		this.leftTopTitleLabel = new JLabel("ChatX");
		this.leftTopTitleLabel.setForeground(new Color(215, 214, 218));
		this.leftTopTitleLabel.setBounds(10, -5, 60, 30);
		this.bannerPanel.add(this.leftTopTitleLabel);
		
		/** avatar label **/
		this.avatarLabel = new JLabel(new ImageIcon("resource/image/avatar_56_56.png"));
		this.avatarLabel.setBounds(10, 40, 56, 56);
		this.bannerPanel.add(this.avatarLabel);
		
		/** nickname label **/
		this.nickNameLabel = new JLabel("GenialX");
		this.nickNameLabel.setFont(new Font("谐体", Font.BOLD, 14));
		this.nickNameLabel.setBounds(70, 30, 60, 30);
		this.nickNameLabel.setForeground(Color.WHITE);
		this.bannerPanel.add(this.nickNameLabel);
		
		this.backgroundPanel.add(this.bannerPanel);
		
		/** searchPanel **/
		this.searchPanel = new JPanel();
		this.searchPanel.setLayout(null);
		this.searchPanel.setBounds(0, 110, 280, 30);
		this.searchPanel.setOpaque(false);
		this.searchPanel.setBackground(Color.WHITE);
		
		this.searchInput = new JTextField();
		this.searchInput.setForeground(new Color(215, 214, 218));
		this.searchInput.setText("搜索: 联系人");
		this.searchInput.setBounds(4, 0, 280, 30);
		this.searchInput.setBorder(null);
		this.searchInput.setOpaque(false);
		this.searchInput.addMouseListener(this);
		this.searchInput.addKeyListener(this);
		this.searchInput.setMargin(new Insets(0, 10, 0, 0));
		this.searchPanel.add(this.searchInput);
		
		this.searchLabel = new JLabel(new ImageIcon("resource/image/find.png"));
		this.searchLabel.setBounds(250, 0, 30, 30);
		this.searchPanel.add(this.searchLabel);
		
		this.backgroundPanel.add(this.searchPanel);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.addMouseListener(this);
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
		if(e.getSource() == this.closeButton) {
			/** close button event **/
			System.out.println("Close button event, system exit(0).");
			this.dispose();
			System.exit(0);
		} else if(e.getSource() == this.searchInput) {
			/** search input **/
			System.out.println("search input mouse clicked event");
			this.searchInput.setText("");
			this.searchInput.setForeground(Color.BLACK);
			this.searchInput.setOpaque(true);
			this.searchPanel.setOpaque(true);
			this.paint(this.getGraphics());
		} else {
			this.searchInput.setOpaque(false);
			this.searchInput.setForeground(new Color(215, 214, 218));
			this.searchInput.setText("搜索: 联系人");
			this.searchPanel.setOpaque(false);
			this.paint(this.getGraphics());
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

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getSource() == this.searchInput) {
			if(this.searchInput.getText().length() > 10) {
				e.setKeyChar('\0');
			}
		}
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
