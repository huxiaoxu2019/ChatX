package com.ihuxu.chatx.view;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;

import javax.swing.JFrame;

abstract public class CommonView extends JFrame{
	
	private static final long serialVersionUID = -1569238103611114992L;
	
	Point loc 			= null;
	Point tmp 			= null;
	boolean isDragged   = false;
	
	protected void setDragable(Component component) {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
				component.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());
				isDragged = true;
				component.setCursor(new Cursor(Cursor.MOVE_CURSOR));
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(component.getLocation().x + e.getX() - tmp.x,
							component.getLocation().y + e.getY() - tmp.y);
					component.setLocation(loc);
				}
			}
		});
	}


}
