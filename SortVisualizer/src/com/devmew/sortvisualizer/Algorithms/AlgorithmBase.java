package com.devmew.sortvisualizer.Algorithms;

import java.util.Arrays;

public abstract class AlgorithmBase
{
	/**
	 * Integer array that contains the unsorted list.
	 */
	public int[] list;
	public int steps;

	/**
	 * Default constructor, all classes that inherits from here should take an
	 * integer array as parameter.
	 * 
	 * @param list
	 */
	public AlgorithmBase(int[] list)
	{
		this.list = list;

	}

	/**
	 * Fully sort the list at full speed.
	 */
	public abstract void Sort();

	/**
	 * Sort one step at a time.
	 */
	public abstract void Step();

	/**
	 * Get how many loops is required to 
	 * @return
	 */
	public abstract int GetSortingLength();

	/**
	 * Returns array in current state of sorting algorithm.
	 * 
	 * @return
	 */
	public abstract int[] GetList();

	/**
	 * Return the name of the sorting method as a string.
	 * 
	 * @return
	 */
	public abstract String GetName();

	public Boolean Verify()
	{
		int[] sorted = list;
		
		Arrays.sort(sorted);

		for (int i = 0; i < sorted.length; i++)
		{
			if (sorted[i] != list[i])
				return false;

		}

		return true;

	}

}
