package com.devmew.sortvisualizer;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

import com.devmew.sortvisualizer.Algorithms.*;
import com.devmew.sortvisualizer.Graphics.*;

import javax.swing.JFrame;

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
		algorithms = new ArrayList<AbstractAlgorithm>();

		unsortedArray = generateRandomArray(50);

		algorithms.add(new BubbleSort(unsortedArray));
		algorithms.add(new SelectionSort(unsortedArray));
		algorithms.add(new InsertionSort(unsortedArray));

	}

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

	public static void run()
	{
		Screen screen = new Screen();

		while (true)
		{
			int[] sorted = unsortedArray;
			Arrays.sort(sorted);

			for (AbstractAlgorithm alg : algorithms)
			{
				for (int i = 0; i < alg.getSortingLength(); i++)
				{
					alg.step(i);
					//screen.Draw(alg.getList());

				}
			}
		}
	}

	/**
	 * Program start point
	 * @param args String array with command line arguments.
	 */
	public static void main(String[] args)
	{
		SortVisualizer visualizer = new SortVisualizer();
		run();

	}
}
