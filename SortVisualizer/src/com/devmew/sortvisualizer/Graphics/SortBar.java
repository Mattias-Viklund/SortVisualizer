package com.devmew.sortvisualizer.Graphics;

import javax.swing.*;
import java.awt.*;

public class SortBar extends JPanel
{
	private int x;
	private int y;
	private int width;
	private int height;

	public SortBar(int x, int y, int width, int height){
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		super.setOpaque(true);

	}

	@Override
	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.setClip(0, 0, width, height);
		graphics.setColor(Color.WHITE);
		graphics.fillRect(x, y, width, height);

	}
}
