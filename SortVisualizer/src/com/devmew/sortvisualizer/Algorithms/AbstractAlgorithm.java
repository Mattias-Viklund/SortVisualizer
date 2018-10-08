package com.devmew.sortvisualizer.Algorithms;

import java.util.Arrays;

public abstract class AbstractAlgorithm
{
	/**
	 * Integer array that contains the unsorted list.
	 */
	protected int[] list;
	protected int steps;

	/**
	 * Default constructor, all classes that inherits from here should take an
	 * integer array as parameter.
	 * @param int[] list
	 */
	public AbstractAlgorithm(int[] list)
	{
		this.list = list;

	}

	/**
	 * Fully sort the list using the algorithm.
	 */
	public abstract void Sort();

	/**
	 * Sort one step at a time
	 * @param currentStep which step in the for loop the program is at
	 */
	public abstract void Step(int currentStep);

	/**
	 * Get how many loops is required to
	 * @return int how many loops to sort the array
	 */
	public abstract int GetSortingLength();

	/**
	 * Returns array in current state of sorting algorithm.
	 * @return int[] array of integers in its current state
	 */
	public int[] GetList()
	{
		return list;

	}

	/**
	 * Return the name of the sorting method as a string.
	 * @return String name of algorithm
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
