package com.ihuxu.chatx.view;

import javax.swing.*;

import com.ihuxu.chatx.model.Member;
import com.ihuxu.chatx.util.server.ServerThread;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Login extends CommonView implements MouseListener, KeyListener{
 
	private static final long serialVersionUID = 6879982149242897670L;

	/** North **/
	JLabel bannerJLabel;

	/** South **/
	JPanel loginPanel, loginButtonPanel, loginInputPanel, loginInputLeftPanel,
			loginInputCenterPanel, loginInputRightPanel,
			loginInputCenterTopPanel, loginInputCenterBottomPanel;
	JButton loginButton, closeButton;
	JLabel avatarLabel, signUpLabel, forgetPasswordLabel,
			rememberPasswordLabel, autoLoginLabel;
	JTextField usernameInput;
	JPasswordField passwordInput;
	JCheckBox rememberPasswordCheckBox, autoLoginCheckBox;

	public static void main(String args[]) {
		new Login();
	}

	public Login() {
		/** North **/
		this.bannerJLabel = new JLabel(new ImageIcon("resource/image/login_banner.jpg"));
		this.bannerJLabel.setLayout(null);
		this.bannerJLabel.setPreferredSize(new Dimension(430, 180));
		this.closeButton = new JButton(new ImageIcon("resource/image/close_press.png"));
		this.closeButton.setBounds(403, -4, 30, 30);
		this.closeButton.setContentAreaFilled(false);
		this.closeButton.setFocusPainted(false);
		this.closeButton.setBorderPainted(false);
		this.closeButton.setOpaque(false);
		this.closeButton.setBorder(null);
		this.closeButton.addMouseListener(this);
		this.bannerJLabel.add(this.closeButton);
		this.add(this.bannerJLabel, BorderLayout.NORTH);
		
		/** South **/
		this.loginPanel = new JPanel();
		GridBagLayout loginPanelLayout = new GridBagLayout();
		GridBagConstraints loginPanelConstraints = new GridBagConstraints();
		this.loginPanel.setLayout(loginPanelLayout);

		/** loginInput Panel **/
		this.loginInputPanel = new JPanel();
		GridBagLayout loginInputPanelLayout = new GridBagLayout();
		GridBagConstraints loginInputPanelConstraints = new GridBagConstraints();
		loginInputPanelConstraints.weightx = 1;
		loginInputPanelConstraints.weighty = 1;
		this.loginInputPanel.setLayout(loginInputPanelLayout);
		this.loginInputPanel.setPreferredSize(new Dimension(400, 100));
		this.loginInputPanel.setBackground(new Color(235, 242, 249));
		loginInputPanelConstraints.fill = GridBagConstraints.BOTH;

		this.loginInputLeftPanel = new JPanel();
		this.loginInputLeftPanel.setLayout(null);
		this.loginInputLeftPanel.setPreferredSize(new Dimension(130, 100));
		this.loginInputLeftPanel.setBackground(new Color(235, 242, 249));
		loginInputPanelConstraints.gridwidth = 1;
		loginInputPanelConstraints.gridheight = 1;
		loginInputPanelLayout.setConstraints(this.loginInputLeftPanel, loginInputPanelConstraints);
		this.avatarLabel = new JLabel(new ImageIcon("resource/image/login_face_8.png"));
		this.avatarLabel.setBounds(50, 10, 80, 80);
		this.loginInputLeftPanel.add(this.avatarLabel);
		this.loginInputPanel.add(this.loginInputLeftPanel);

		this.loginInputCenterPanel = new JPanel();
		this.loginInputCenterPanel.setPreferredSize(new Dimension(210, 100));
		this.loginInputCenterPanel.setBackground(new Color(235, 242, 249));
		loginInputPanelConstraints.gridwidth = 1;
		loginInputPanelConstraints.gridheight = 1;
		loginInputPanelLayout.setConstraints(this.loginInputCenterPanel, loginInputPanelConstraints);
		this.loginInputCenterTopPanel = new JPanel();
		this.loginInputCenterTopPanel.setLayout(null);
		this.loginInputCenterTopPanel.setPreferredSize(new Dimension(210, 76));
		this.loginInputCenterTopPanel.setBackground(new Color(235, 242, 249));
		this.loginInputCenterBottomPanel = new JPanel();
		this.loginInputCenterBottomPanel.setLayout(null);
		this.loginInputCenterBottomPanel.setPreferredSize(new Dimension(210, 24));
		this.loginInputCenterBottomPanel.setBackground(new Color(235, 242, 249));
		GridBagLayout loginInputCenterPanelLayout = new GridBagLayout();
		GridBagConstraints loginInputCenterPanelConstraints = new GridBagConstraints();
		this.loginInputCenterPanel.setLayout(loginInputCenterPanelLayout);
		loginInputCenterPanelConstraints.gridwidth = 0;
		loginInputCenterPanelConstraints.gridheight = 1;
		loginInputCenterPanelLayout.setConstraints(this.loginInputCenterTopPanel, loginInputCenterPanelConstraints);
		this.usernameInput = new JTextField();
		this.passwordInput = new JPasswordField();
		this.usernameInput.setBounds(10, 7, 200, 38);
		this.passwordInput.setBounds(10, 37, 200, 38);
		this.usernameInput.addKeyListener(this);
		this.passwordInput.addKeyListener(this);
		this.loginInputCenterTopPanel.add(this.usernameInput);
		this.loginInputCenterTopPanel.add(this.passwordInput);
		this.loginInputCenterPanel.add(this.loginInputCenterTopPanel);
		this.rememberPasswordCheckBox = new JCheckBox();
		this.rememberPasswordCheckBox.setBounds(6, -3, 22, 22);
		this.loginInputCenterBottomPanel.add(this.rememberPasswordCheckBox);
		this.autoLoginCheckBox = new JCheckBox();
		this.autoLoginCheckBox.setBounds(132, -3, 22, 22);
		this.loginInputCenterBottomPanel.add(this.autoLoginCheckBox);
		this.rememberPasswordLabel = new JLabel("记住密码");
		this.rememberPasswordLabel.setBounds(30, -7, 60, 30);
		this.rememberPasswordLabel.setForeground(new Color(102, 102, 102));
		this.loginInputCenterBottomPanel.add(this.rememberPasswordLabel);
		this.autoLoginLabel = new JLabel("自动登录");
		this.autoLoginLabel.setBounds(156, -7, 60, 30);
		this.autoLoginLabel.setForeground(new Color(102, 102, 102));
		this.loginInputCenterBottomPanel.add(this.autoLoginLabel);
		loginInputCenterPanelConstraints.gridwidth = 0;
		loginInputCenterPanelConstraints.gridheight = 1;
		loginInputCenterPanelLayout.setConstraints(this.loginInputCenterBottomPanel, loginInputCenterPanelConstraints);
		this.loginInputCenterPanel.add(this.loginInputCenterBottomPanel);
		this.loginInputPanel.add(this.loginInputCenterPanel);

		this.loginInputRightPanel = new JPanel();
		this.loginInputRightPanel.setLayout(null);
		this.loginInputRightPanel.setPreferredSize(new Dimension(90, 100));
		this.loginInputRightPanel.setBackground(new Color(235, 242, 249));
		this.signUpLabel = new JLabel("注册账号");
		this.forgetPasswordLabel = new JLabel("找回密码");
		this.signUpLabel.setBounds(8, 12, 60, 30);
		this.forgetPasswordLabel.setBounds(8, 42, 60, 30);
		this.signUpLabel.setForeground(new Color(0, 117, 175));
		this.forgetPasswordLabel.setForeground(new Color(0, 117, 175));
		this.loginInputRightPanel.add(this.signUpLabel);
		this.loginInputRightPanel.add(this.forgetPasswordLabel);
		loginInputPanelConstraints.gridwidth = 0;
		loginInputPanelConstraints.gridheight = 1;
		loginInputPanelLayout.setConstraints(this.loginInputRightPanel, loginInputPanelConstraints);
		this.loginInputPanel.add(this.loginInputRightPanel);

		/** loginButton Panel **/
		this.loginButtonPanel = new JPanel();
		this.loginButtonPanel.setLayout(null);
		this.loginButtonPanel.setBackground(new Color(235, 242, 249));
		this.loginButtonPanel.setPreferredSize(new Dimension(430, 50));
		this.loginButton = new JButton("登 陆", new ImageIcon("resource/image/button_login_normal.png"));
		this.loginButton.setHorizontalTextPosition(JButton.CENTER);
		this.loginButton.setVerticalTextPosition(JButton.CENTER);
		this.loginButton.setContentAreaFilled(false);
		this.loginButton.setFocusPainted(false);
		this.loginButton.setBorderPainted(false);
		this.loginButton.setOpaque(false);
		this.loginButton.setBorder(null);
		this.loginButton.setForeground(Color.WHITE);
		this.loginButton.addMouseListener(this);
		this.loginButton.setBounds(140, 5, 200, 30);
		this.loginButtonPanel.add(this.loginButton);

		loginPanelConstraints.fill = GridBagConstraints.BOTH;

		loginPanelConstraints.gridwidth = 0;
		loginPanelConstraints.weightx = 1;
		loginPanelLayout.setConstraints(this.loginInputPanel, loginPanelConstraints);
		this.loginPanel.add(this.loginInputPanel);

		loginPanelConstraints.gridwidth = 0;
		loginPanelConstraints.weightx = 1;
		loginPanelLayout.setConstraints(this.loginButtonPanel, loginPanelConstraints);
		this.loginPanel.add(this.loginButtonPanel);

		this.add(this.loginPanel, BorderLayout.SOUTH);

		Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screenSize.width / 2 - 430 /2 , screenSize.height / 2 - 330 / 2);
		this.setUndecorated(true);
		this.setSize(new Dimension(430, 330));
		this.setResizable(false);
		this.setDragable(this);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this.closeButton) {
			/** close login window event **/
			this.dispose();
			System.exit(0);
		} else if(e.getSource() == this.loginButton) {
			/** login event **/
			this.login();
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource() == this.usernameInput) {
			/** username input event **/
			if(e.getKeyCode() == 10) {
				/** username input enter key event **/
				this.passwordInput.requestFocus();
			}
		} else if(e.getSource() == this.passwordInput) {
			/** password input event **/
			if(e.getKeyCode() == 10) {
				/** password input enter key event **/
				this.login();
			}
		}
		
	}
	
	private void login() {
		long uid = Long.parseLong(this.usernameInput.getText());
		String password = new String(this.passwordInput.getPassword());
		boolean login = false;
		try {
			login = Member.checkLogin(uid, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(login) {
			System.out.println("login seccussfully.");
			this.dispose(); 
			List list = new List();
			ServerThread serverThread = new ServerThread(list);
			serverThread.start();
		} else {
			/**
			 * @todo there is a bug for the another try after the failed.
			 */
			System.out.println("login failed.");
		}
	}
}
