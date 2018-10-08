package com.devmew.sortvisualizer.Graphics;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Visualizer
{
	public JFrame window = new JFrame("Sort visualizer");
	public JPanel contentPane = new JPanel();

	public Visualizer(int width, int height)
	{
		window.setSize(width, height);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		window.setContentPane(contentPane);
		window.getContentPane().setLayout(null);
		window.getContentPane().setBackground(Color.BLACK);
		window.setBackground(Color.BLACK);

	}

	public int Draw(int[] array)
	{
		window.getContentPane().removeAll();

		int lowest = array[0];
		int highest = array[0];

		for (int i = 0; i < array.length; i++)
		{
			if (highest < array[i])
			{
				highest = array[i];
			}

			if (lowest > array[i])
			{
				lowest = array[i];
			}

		}

		int difference = highest - lowest;

		float width = (window.getWidth() / array.length) - 2;
		float heightRatio = (window.getHeight() / highest) - 20;

		SortBar sort = new SortBar(0, 0, 100, 100);
		window.getContentPane().add(sort);
		System.out.println("Bam");

//		for (int i = 0; i < array.length; i++)
//		{
//
//		}

		return 1;

	}
}
