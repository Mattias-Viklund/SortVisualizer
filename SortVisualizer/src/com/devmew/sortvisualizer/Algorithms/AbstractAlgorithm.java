package com.devmew.sortvisualizer.Algorithms;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import javax.swing.*;

public abstract class AbstractAlgorithm extends JPanel
{
	private static final int WIDTH = 1280;
	private static final int HEIGHT = 720;

	private static final int BAR_WIDTH = 5;
	private static final double BAR_HEIGHT = 512.0 / 720.0;
	private static final int BARS = WIDTH / BAR_WIDTH;

	/**
	 * Integer array that contains the unsorted list.
	 */
	protected int[] list;
	protected int steps;
	protected String algorithmName;

	private int highestValue = Integer.MIN_VALUE;

	/**
	 * Default constructor, all classes that inherits from here should take an
	 * integer array as parameter.
	 *
	 * @param int[] list
	 */
	public AbstractAlgorithm(int[] list, String name)
	{
		if (list.length == 0)
		{
			throw new IllegalArgumentException("List to sort can not have the length 0");
		}

		this.list = list;
		this.algorithmName = name;
		this.setBackground(new Color(0, 0, 0));

		this.highestValue = getHighestValue();

	}

	/**
	 * Gets the canvas size
	 *
	 * @return size
	 */
	@Override
	public Dimension getPreferredSize()
	{
		return new Dimension(WIDTH, HEIGHT);

	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D panelGraphics = (Graphics2D) g.create();

		try
		{
			// Set color to WHITE, Font to Arial
			panelGraphics.setColor(Color.WHITE);
			panelGraphics.setFont(new Font("Arial", Font.BOLD, 20));

			// Draw current algorithm name and how many steps we've taken
			panelGraphics.drawString(" Current algorithm: " + this.algorithmName, 10, 30);
			panelGraphics.drawString("     Array Changes: " + this.steps, 10, 80);

			// Draw the bars
			drawBars(panelGraphics);

		}
		finally
		{
			panelGraphics.dispose();

		}
	}

	private void drawBars(Graphics2D panelGraphics)
	{
		int barWidth = getWidth() / list.length;
		int bufferedImageWidth = barWidth * list.length;
		int bufferedImageHeight = getHeight();

		if (bufferedImageHeight > 0 && bufferedImageWidth > 0)
		{
			if (bufferedImageWidth < 256)
			{
				bufferedImageWidth = 256;
			}

			BufferedImage bufferedImage = new BufferedImage(bufferedImageWidth, bufferedImageHeight, BufferedImage.TYPE_INT_ARGB);
			Graphics2D bufferedGraphics = null;

			try
			{
				bufferedGraphics = bufferedImage.createGraphics();

				for (int x = 0; x < list.length; x++)
				{
					double value = list[x];
					double max = value / highestValue;
					double heightInPanel = max * BAR_HEIGHT;
					int height = (int) (heightInPanel * (double) getHeight());
					int xBegin = x + (barWidth - 1) * x;
					int yBegin = getHeight() - height;

					bufferedGraphics.setColor(new Color(255, 255, 255));

					bufferedGraphics.fillRect(xBegin, yBegin, barWidth, height);

				}
			}
			finally
			{
				if (bufferedGraphics != null)
				{
					bufferedGraphics.dispose();

				}
			}

			panelGraphics.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);

		}
	}

	/**
	 * Fully sort the list using the algorithm.
	 */
	public abstract void sort();

	/**
	 * sort one step at a time
	 *
	 * @param currentStep which step in the for loop the program is at
	 */
	public abstract void step(int currentStep);

	/**
	 * Get how many loops is required to
	 *
	 * @return int how many loops to sort the array
	 */
	public abstract int getSortingLength();

	/**
	 * Returns array in current state of sorting algorithm.
	 *
	 * @return int[] array of integers in its current state
	 */
	public int[] getList()
	{
		return list;

	}

	/**
	 * Return the name of the sorting method as a string.
	 *
	 * @return String name of algorithm
	 */
	public String getName()
	{
		return this.algorithmName;

	}

	public Boolean verify()
	{
		int[] sorted = list;

		Arrays.sort(sorted);

		for (int i = 0; i < sorted.length; i++)
		{
			if (sorted[i] != list[i])
			{
				return false;
			}

		}

		return true;

	}

	public int getHighestValue()
	{
		int value = list[0];

		for (int i = 0; i < list.length; i++)
		{
			if (i > value)
			{
				value = i;
			}

		}

		return value;
	}
}
