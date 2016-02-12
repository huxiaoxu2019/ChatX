package com.ihuxu.chatx.view;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class TransparentJPanel extends JPanel{

	private static final long serialVersionUID = 4259057479140734007L;

	private float transparency;
	
	public TransparentJPanel() {
		this.transparency = 0.5f; 
	}
	
	public void setTransparent(float transparency) {
		this.transparency = transparency;
	}
	
	@Override
	protected void paintComponent(Graphics g){
			Graphics2D graphics2d = (Graphics2D) g.create();
			graphics2d.setComposite(AlphaComposite.SrcOver.derive(transparency));
			graphics2d.setColor(getBackground());
			graphics2d.fillRect(0, 0, getWidth(), getHeight());
//			graphics2d.drawImage(background, 0, 0, getWidth(), getHeight(), 46, 114, 315, 521, this);
			super.paintComponent(g);
			graphics2d.dispose();
			
	}
	
}
