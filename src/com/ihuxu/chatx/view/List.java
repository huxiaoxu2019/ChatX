package com.ihuxu.chatx.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;


public class List extends CommonView implements KeyListener, MouseListener {

	private static final long serialVersionUID = 1101068431445178024L;
	JPanel backgroundPanel, bannerPanel, searchPanel, listPanel, footerPanel, scrollPanePanel;
	JButton closeButton;
	JLabel leftTopTitleLabel, avatarLabel, nickNameLabel, searchLabel;
	JTextField searchInput;
	JScrollPane listScrollPane;
	JLabel[] friendListLabel;
	JPanel[] friendListPanel;
	
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
		
		/** list panel **/
		this.listPanel = new JPanel();
		this.listPanel.setBounds(0, 140, 280, 500);
		this.listPanel.setLayout(null);
		this.listPanel.setOpaque(false);
		
		/** scrollpane **/
		this.listScrollPane = new JScrollPane();
		this.listScrollPane.setPreferredSize(new Dimension(280, 500));
		this.listScrollPane.setBorder(null);
		this.listScrollPane.setBounds(0, 0, 280, 510);
		this.listScrollPane.setBackground(new Color(1, 1, 1, 0.5f));
		this.listScrollPane.getViewport().setBackground(new Color(1, 1, 1, 0.5f));
		
		/** friendlist jlabel **/
		this.scrollPanePanel = new JPanel();
		this.scrollPanePanel.setBounds(0, 0, 280, 500);
		this.scrollPanePanel.setOpaque(false);
		this.scrollPanePanel.setLayout(null);
		this.friendListLabel = new JLabel[2];
		this.friendListPanel = new JPanel[2];
		
		for(int i = 0; i < this.friendListLabel.length; i++) {
			this.friendListPanel[i] = new JPanel();
			this.friendListPanel[i].addMouseListener(new FriendListPanelListener());
			this.friendListPanel[i].setOpaque(false);
			this.friendListPanel[i].setLayout(null);
			this.friendListPanel[i].setBounds(0, 50 * i, 280, 50);
			int top = 0;
			if(i == 0) {
				top = 1;
			}
			this.friendListPanel[i].setBorder(BorderFactory.createMatteBorder(top, 0, 1, 0, new Color(220, 219, 222)));
			this.friendListLabel[i] = new JLabel(new ImageIcon("resource/image/avatar_40_40.png"));
			this.friendListLabel[i].setBounds(2, 0, 50, 50);
			this.friendListPanel[i].add(this.friendListLabel[i]);
			this.scrollPanePanel.add(this.friendListPanel[i]);
		}
		
		
		this.listScrollPane.setViewportView(this.scrollPanePanel);
		this.listPanel.add(this.listScrollPane);
		this.backgroundPanel.add(this.listPanel);
		
		/** footer panel **/
		this.footerPanel = new JPanel();
		this.footerPanel.setBackground(new Color(1, 1, 1, 0.95f));
		this.footerPanel.setBounds(0, 640, 280, 60);
		
		this.backgroundPanel.add(this.footerPanel);
		
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
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

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
	
	class FriendListPanelListener extends MouseAdapter{
		@Override
		public void mouseEntered(MouseEvent e) {
			System.out.println("mouse entered the friendlist panel event.");
			JPanel jPanel = (JPanel)e.getSource();
			jPanel.setOpaque(true);
			jPanel.setBackground(new Color(249, 238, 194));
			List.this.update(List.this.getGraphics());
		}

		@Override
		public void mouseExited(MouseEvent e) {
			System.out.println("mouse exited the friendlist panel event.");
			JPanel jPanel = (JPanel)e.getSource();
			jPanel.setOpaque(false);
			List.this.update(List.this.getGraphics());
		}
	}
	
}
