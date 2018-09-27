package com.devmew.sortvisualizer;

import com.devmew.sortvisualizer.Algorithms.*;

public class SortVisualizer {
	public static int[] list = { 10, 9, 12, 13, 14, 3, 0, 15, 18, 1, 2, 7, 5, 16, 11, 4, 6, 8, 17 };
	
	public static AlgorithmBase insSort;
	public static AlgorithmBase bubSort;
	public static AlgorithmBase selSort;
	
	/**
	 * Visualize different sorting techniques.
	 * @param args
	 */
	public static void main(String[] args) {
		insSort = new InsertionSort(list);
		insSort.Sort();
		System.out.println(insSort.GetName()+", Is Sorted: "+insSort.Verify()+", Steps: "+insSort.steps);
		
		bubSort = new BubbleSort(list);
		bubSort.Sort();
		System.out.println(bubSort.GetName()+", Is Sorted: "+bubSort.Verify()+", Steps: "+bubSort.steps);
		
		selSort = new SelectionSort(list);
		selSort.Sort();
		System.out.println(selSort.GetName()+", Is Sorted: "+selSort.Verify()+", Steps: "+selSort.steps);
		
	}
}
