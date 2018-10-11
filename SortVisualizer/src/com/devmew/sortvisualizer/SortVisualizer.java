package com.devmew.sortvisualizer;

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
		window = new JFrame("Sort Visualizer");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setContentPane(new JPanel());
		window.pack();
		window.setVisible(true);

		algorithms = new ArrayList<AbstractAlgorithm>();

		unsortedArray = generateRandomArray(50);

		algorithms.add(new BubbleSort(unsortedArray));
		algorithms.add(new SelectionSort(unsortedArray));
		algorithms.add(new InsertionSort(unsortedArray));

	}

	/**
	 * Generate integer array with random numbers from 0 - 1000
	 *
	 * @param count size of generated array
	 * @return int[] with result
	 */
	public static int[] generateRandomArray(int count)
	{
		Random rng = new Random();
		int[] array = new int[count];

		for (int i = 0; i < count; i++)
		{
			array[i] = rng.nextInt(1000);

		}

		return array;

	}

	public void run()
	{
		while (true)
		{
			int[] sorted = unsortedArray;
			Arrays.sort(sorted);

			for (AbstractAlgorithm alg : algorithms)
			{
				window.getContentPane().removeAll();
				window.getContentPane().add(alg);
				window.pack();
				for (int i = 0; i < alg.getSortingLength(); i++)
				{
					alg.step(i);
					alg.updateContent();
					try

					{
						Thread.sleep(20l);
					}
					catch (Exception e)
					{

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
