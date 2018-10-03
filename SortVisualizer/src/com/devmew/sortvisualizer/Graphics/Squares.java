package com.devmew.sortvisualizer.Graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class Squares extends JPanel
{
	private List<Rectangle> squares = new ArrayList<Rectangle>();

	public void addSquare(int x, int y, int width, int height)
	{
		Rectangle rect = new Rectangle(x, y, width, height);
		squares.add(rect);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (Rectangle rect : squares)
		{
			g2.draw(rect);

		}
	}
}