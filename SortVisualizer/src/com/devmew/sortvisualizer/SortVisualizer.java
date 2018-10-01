package com.devmew.sortvisualizer;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.Arrays;

import com.devmew.sortvisualizer.Algorithms.*;
import com.devmew.sortvisualizer.Graphics.Visualizer;

public class SortVisualizer {
	public static int[] unsortedList = { 10, 9, 12, 13, 14, 3, 0, 15, 18, 1, 2, 7, 5, 16, 11, 4, 6, 8, 17 };
	
	public static AlgorithmBase[] algorithms;
	
	public static Visualizer visualizer = new Visualizer(700, 400);
	
	/**
	 * Visualize different sorting techniques.
	 * @param args
	 */
	public static void main(String[] args) {
		InitializeAlgorithms();
		Run();
		
	}
	
	// Long and convoluted name, but descriptive.
	public static void InitializeAlgorithms() {
		algorithms = new AlgorithmBase[3];
		
		algorithms[0] = new BubbleSort(unsortedList);
		algorithms[1] = new InsertionSort(unsortedList);
		algorithms[2] = new SelectionSort(unsortedList);
		
	}
	
	public static void Run() {
		int[] sorted = unsortedList;
		Arrays.sort(sorted);
		
		for (AlgorithmBase alg : algorithms)
		{
			for (int i = 0; i < alg.GetSortingLength(); i++)
			{
				alg.Step(i);
				visualizer.Draw(alg.list);
				
			}
		}
	}
}
