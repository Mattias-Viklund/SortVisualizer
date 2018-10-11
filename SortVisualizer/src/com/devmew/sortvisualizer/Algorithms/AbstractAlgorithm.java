package com.devmew.sortvisualizer.Algorithms;

import static com.devmew.sortvisualizer.SortVisualizer.WIDTH;
import static com.devmew.sortvisualizer.SortVisualizer.HEIGHT;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import javax.swing.*;

public abstract class AbstractAlgorithm extends JPanel
{
	private static final int BAR_WIDTH = 5;
	private static final double BAR_HEIGHT = 512.0 / 720.0;
	private static final int BARS = WIDTH / BAR_WIDTH;

	/**
	 * Integer array that contains the unsorted list.
	 */
	protected int[] list;
	protected int steps;
	protected String algorithmName;

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

	}

	public void updateContent(){
		repaint();

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

			int maxValue = getHighestValue();

			BufferedImage bufferedImage = new BufferedImage(bufferedImageWidth, bufferedImageHeight, BufferedImage.TYPE_INT_ARGB);
			makeBufferedImageTransparent(bufferedImage);
			Graphics2D bufferedGraphics = null;

			try
			{
				bufferedGraphics = bufferedImage.createGraphics();

				for (int x = 0; x < list.length; x++)
				{
					double currentValue = list[x];
					double percentOfMax = currentValue / maxValue;
					double heightPercentOfPanel = percentOfMax * BAR_HEIGHT;
					int height = (int) (heightPercentOfPanel * (double) getHeight());
					int xBegin = x + (barWidth - 1) * x;
					int yBegin = getHeight() - height;

					bufferedGraphics.setColor(new Color(255, 255, 255));

				}
			}
			finally
			{
				if (bufferedGraphics != null)
				{
					bufferedGraphics.dispose();

				}
			}

			int i = 0;
			panelGraphics.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);

		}
	}

	private void makeBufferedImageTransparent(BufferedImage image)
	{
		Graphics2D graphics = null;

		try
		{
			graphics = image.createGraphics();

			graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
			graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
			graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

		}
		finally
		{
			if (graphics != null)
			{
				graphics.dispose();

			}
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
