package com.devmew.sortvisualizer.Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rectangle extends JComponent
{
	private static final long serialVersionUID = 1L;

	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	
	public Rectangle(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponents(g);
	    Graphics2D g2d = (Graphics2D) g;

	    g2d.setColor(color);
	    g2d.fillRect(x, y, width, height);
	    
	    g.drawString("PENIS", 5, 5);
		
	}
}
