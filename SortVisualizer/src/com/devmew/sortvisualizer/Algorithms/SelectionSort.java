package com.devmew.sortvisualizer.Algorithms;

public class SelectionSort extends AbstractAlgorithm
{
	public SelectionSort(int[] list)
	{
		super(list, "Selection Sort");

	}

	@Override
	public void sort()
	{
		for (int x = 0; x < getSortingLength(); x++)
		{
			step(x);

		}
	}

	public void swap(int firstIndex, int secondIndex)
	{
		int temp = list[firstIndex];
		list[firstIndex] = list[secondIndex];
		list[secondIndex] = temp;

	}

	@Override
	public void step(int currentStep)
	{
		// Implemented using
		// https://en.wikipedia.org/wiki/Selection_sort, as a references
		int minIndex = currentStep;
		for (int y = currentStep + 1; y < list.length; y++)
		{
			steps++;

			if (list[y] < list[minIndex])
			{
				minIndex = y;

			}
		}
		swap(currentStep, minIndex);

	}

	@Override
	public int getSortingLength()
	{
		return super.list.length - 1;

	}
}
