package com.devmew.sortvisualizer;

import java.awt.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

import com.devmew.sortvisualizer.Algorithms.*;

import javax.swing.*;

public class SortVisualizer
{
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	private final JFrame window;

	private static ArrayList<AbstractAlgorithm> algorithms;
	private static int[] unsortedArray;

	public SortVisualizer()
	{
		algorithms = new ArrayList<AbstractAlgorithm>();

		unsortedArray = generateRandomArray(50, 100);

		algorithms.add(new BubbleSort(unsortedArray));
		algorithms.add(new SelectionSort(unsortedArray));
		algorithms.add(new InsertionSort(unsortedArray));

		window = new JFrame("Sort Visualizer");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new JPanel());
		window.setVisible(true);

	}

	public static int[] generateRandomArray(int count, int maxValue)
	{
		Random rng = new Random();
		int[] array = new int[count];

		for (int i = 0; i < count; i++)
		{
			array[i] = rng.nextInt(maxValue);

		}

		return array;

	}

	public void run()
	{
		int[] sorted = unsortedArray;
		Arrays.sort(sorted);

		window.getContentPane().setBackground(new Color(0, 0, 0));

		while (true)
		{
			for (AbstractAlgorithm algorithm : algorithms)
			{
				window.getContentPane().removeAll();
				window.getContentPane().add(algorithm);

				for (int i = 0; i < algorithm.getSortingLength(); i++)
				{
					algorithm.step(i);
					algorithm.repaint();
					window.repaint();
					window.pack();

					try
					{
						Thread.sleep(100);

					}
					catch (InterruptedException ex)
					{
						ex.printStackTrace();

					}
				}
			}
		}
	}

	/**
	 * Program start point
	 *
	 * @param args String array with command line arguments.
	 */
	public static void main(String[] args)
	{
		SortVisualizer visualizer = new SortVisualizer();
		visualizer.run();

	}
}
