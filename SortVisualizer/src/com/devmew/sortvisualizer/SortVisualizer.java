package com.devmew.sortvisualizer;

import com.devmew.sortvisualizer.Algorithms.*;

public class SortVisualizer {
	public static int[] list = { 10, 9, 12, 13, 14, 3, 0, 15, 18, 1, 2, 7, 5, 16, 11, 4, 6, 8, 17 };
	
	public static AlgorithmBase algorithm;
	
	/**
	 * Visualize different sorting techniques.
	 * @param args
	 */
	public static void main(String[] args) {
		algorithm = new InsertionSort(list);
		algorithm.Sort();
		System.out.println(algorithm.GetName()+", Is Sorted: "+algorithm.Verify(list)+", Steps: "+algorithm.StepsTaken());
		
		algorithm = new BubbleSort(list);
		algorithm.Sort();
		System.out.println(algorithm.GetName()+", Is Sorted: "+algorithm.Verify(list)+", Steps: "+algorithm.StepsTaken());
		
		algorithm = new SelectionSort(list);
		algorithm.Sort();
		System.out.println(algorithm.GetName()+", Is Sorted: "+algorithm.Verify(list)+", Steps: "+algorithm.StepsTaken());
		
	}
}
