package com.ihuxu.chatx.view;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{
    
    private static final long serialVersionUID = 6879982149242897670L;

    /** North **/
    JLabel bannerJLabel;
    
    /** South **/
    JPanel loginPanel, loginButtonPanel, loginInputPanel, loginInputLeftPanel, loginInputCenterPanel, loginInputRightPanel, 
    loginInputCenterTopPanel, loginInputCenterBottomPanel;
    JButton loginButton;
    JLabel avatarLabel, signUpLabel, forgetPasswordLabel;
    JTextField usernameInput;
    JPasswordField passwordInput;
    
    
    public static void main(String args[]) {    
        new Login();
    }
    
    public Login() {
        /** North **/
        this.bannerJLabel = new JLabel(new ImageIcon("resource/image/login_banner.jpg"));
        this.bannerJLabel.setPreferredSize(new Dimension(430, 180));
        this.add(this.bannerJLabel, BorderLayout.NORTH);
        
        /** South **/
        this.loginPanel                                         = new JPanel();
        GridBagLayout loginPanelLayout                             = new GridBagLayout();
        GridBagConstraints loginPanelConstraints                 = new GridBagConstraints();
        this.loginPanel.setLayout(loginPanelLayout);
        
        /** loginInput Panel **/
        this.loginInputPanel = new JPanel();
        this.loginInputPanel.setBackground(new Color(235, 242, 249));
        GridBagLayout loginInputPanelLayout                             = new GridBagLayout();
        GridBagConstraints loginInputPanelConstraints                    = new GridBagConstraints();
        loginInputPanelConstraints.weightx      = 1;
        loginInputPanelConstraints.weighty      = 1;
        this.loginInputPanel.setLayout(loginInputPanelLayout);
        this.loginInputPanel.setPreferredSize(new Dimension(400, 100));
        loginInputPanelConstraints.fill = GridBagConstraints.BOTH;
        
        this.loginInputLeftPanel = new JPanel();
        this.loginInputLeftPanel.setLayout(null);
        this.loginInputLeftPanel.setPreferredSize(new Dimension(130, 100));
        this.loginInputLeftPanel.setBackground(new Color(235, 242, 249));
        loginInputPanelConstraints.gridwidth       = 1;
        loginInputPanelConstraints.gridheight      = 1;
        loginInputPanelLayout.setConstraints(this.loginInputLeftPanel, loginInputPanelConstraints);
        this.avatarLabel = new JLabel(new ImageIcon("resource/image/login_face_8.png"));
        this.avatarLabel.setBounds(50, 10, 80, 80);
        this.loginInputLeftPanel.add(this.avatarLabel);
        this.loginInputPanel.add(this.loginInputLeftPanel);
        
        this.loginInputCenterPanel = new JPanel();
        this.loginInputCenterPanel.setPreferredSize(new Dimension(210, 100));
        this.loginInputCenterPanel.setBackground(new Color(235, 242, 249));
        loginInputPanelConstraints.gridwidth       = 1;
        loginInputPanelConstraints.gridheight      = 1;
        loginInputPanelLayout.setConstraints(this.loginInputCenterPanel, loginInputPanelConstraints);
        this.loginInputCenterTopPanel = new JPanel();
        this.loginInputCenterTopPanel.setLayout(null);
        this.loginInputCenterTopPanel.setPreferredSize(new Dimension(210, 76));
        this.loginInputCenterBottomPanel = new JPanel();
        this.loginInputCenterBottomPanel.setPreferredSize(new Dimension(210, 24));
        GridBagLayout loginInputCenterPanelLayout                             = new GridBagLayout();
        GridBagConstraints loginInputCenterPanelConstraints                    = new GridBagConstraints();
        this.loginInputCenterPanel.setLayout(loginInputCenterPanelLayout);
        loginInputCenterPanelConstraints.gridwidth = 0;
        loginInputCenterPanelConstraints.gridheight = 1;
        loginInputCenterPanelLayout.setConstraints(this.loginInputCenterTopPanel, loginInputCenterPanelConstraints);
        this.usernameInput = new JTextField();
        this.passwordInput = new JPasswordField();
        this.usernameInput.setBounds(10, 7, 200, 38);
        this.passwordInput.setBounds(10, 37, 200, 38);
        this.loginInputCenterTopPanel.add(this.usernameInput);
        this.loginInputCenterTopPanel.add(this.passwordInput);
        this.loginInputCenterPanel.add(this.loginInputCenterTopPanel);
        loginInputCenterPanelConstraints.gridwidth = 0;
        loginInputCenterPanelConstraints.gridheight = 1;
        loginInputCenterPanelLayout.setConstraints(this.loginInputCenterBottomPanel, loginInputCenterPanelConstraints);
        this.loginInputCenterPanel.add(this.loginInputCenterBottomPanel);
        this.loginInputPanel.add(this.loginInputCenterPanel);
        
        
        this.loginInputRightPanel = new JPanel();
        this.loginInputRightPanel.setPreferredSize(new Dimension(90, 100));
        this.loginInputRightPanel.setBackground(new Color(235, 242, 249));
        loginInputPanelConstraints.gridwidth       = 0;
        loginInputPanelConstraints.gridheight      = 1;
        loginInputPanelLayout.setConstraints(this.loginInputRightPanel, loginInputPanelConstraints);
        this.loginInputPanel.add(this.loginInputRightPanel);
        
        
        /** loginButton Panel **/
        this.loginButtonPanel     = new JPanel();
        this.loginButtonPanel.setLayout(null);
        this.loginButtonPanel.setBackground(new Color(235, 242, 249));
        this.loginButtonPanel.setPreferredSize(new Dimension(430, 50));
        this.loginButton         = new JButton("登 陆", new ImageIcon("resource/image/button_login_normal.png"));
        this.loginButton.setHorizontalTextPosition(JButton.CENTER);
        this.loginButton.setVerticalTextPosition(JButton.CENTER);
        this.loginButton.setContentAreaFilled(false);
        this.loginButton.setFocusPainted(false);
        this.loginButton.setBorderPainted(false);
        this.loginButton.setOpaque(false); 
        this.loginButton.setBorder(null);
        this.loginButton.setForeground(Color.WHITE);
        this.loginButton.setBounds(140, 5, 200, 30);
        this.loginButtonPanel.add(this.loginButton);
    
        loginPanelConstraints.fill = GridBagConstraints.BOTH;
        
        loginPanelConstraints.gridwidth  = 0;
        loginPanelConstraints.weightx    = 1;
        loginPanelLayout.setConstraints(this.loginInputPanel, loginPanelConstraints);
        this.loginPanel.add(this.loginInputPanel);
        
        loginPanelConstraints.gridwidth  = 0;
        loginPanelConstraints.weightx    = 1;
        loginPanelLayout.setConstraints(this.loginButtonPanel, loginPanelConstraints);
        this.loginPanel.add(this.loginButtonPanel);
        
        this.add(this.loginPanel, BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setUndecorated(true);
        this.setTitle("ChatX");
        this.setSize(new Dimension(430, 330));
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }
}
