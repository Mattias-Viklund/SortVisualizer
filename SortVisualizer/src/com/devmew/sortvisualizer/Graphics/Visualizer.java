package com.devmew.sortvisualizer.Graphics;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Visualizer
{
	public JFrame window = new JFrame("Sort visualizer");
	public JPanel contentPane = new JPanel();
	
	public Visualizer(int width, int height)
	{
		contentPane.setBackground(Color.BLACK);
		
		window.setSize(width, height);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}

	public int Draw(int[] array)
	{
		int lowest = array[0];
		int highest = array[0];

		for (int i = 0; i < array.length; i++)
		{
			if (highest < array[i])
				highest = array[i];

			if (lowest > array[i])
				lowest = array[i];

		}

		int difference = highest - lowest;

		float width = (window.getWidth() / array.length) - 2;
		float heightRatio = (window.getHeight() / highest) - 20;

		window.removeAll();
		window.setContentPane(contentPane);
		
		Rectangle r = new Rectangle((int) (1 * width + 1), 0, (int) width, (int) heightRatio * array[0], Color.WHITE);
		window.add(r);

		for (int i = 0; i < array.length; i++)
		{

		}

		return 1;

	}
}
