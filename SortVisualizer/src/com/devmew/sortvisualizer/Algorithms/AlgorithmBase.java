package com.devmew.sortvisualizer.Algorithms;

import java.util.Arrays;

public abstract class AlgorithmBase 
{
	/**
	 * Default constructor, all classes that inherits from here should take an integer array as parameter.
	 * @param list
	 */
	public AlgorithmBase(int[] list) {
		
		
	}
	
	/**
	 * Basic implementation of the sorting algorithm.
	 */
	public abstract void Sort();
	
	/**
	 * Returns array in current state of sorting algorithm.
	 * @return
	 */
	public abstract int[] GetList();
	
	/**
	 * Return the name of the sorting method as a string.
	 * @return
	 */
	public abstract String GetName();
	
	/**
	 * Returns the total amounts of steps it took to get to the final result.
	 * @return
	 */
	public abstract int StepsTaken();
	
	public Boolean Verify(int[] unsorted) {
		if (unsorted.length != GetList().length)
			return false;
		
		Arrays.sort(unsorted);
		
		for (int i = 0; i < unsorted.length; i++) {
			if (unsorted[i] != GetList()[i])
				return false;
			
		}
		
		return true; 
		
	}
	
}
