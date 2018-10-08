package com.devmew.sortvisualizer.Algorithms;

public class BubbleSort extends AbstractAlgorithm
{
	public BubbleSort(int[] list)
	{
		super(list, "Bubble Sort");

	}

	@Override
	public void sort()
	{
		for (int x = 0; x < getSortingLength(); x++)
		{
			step(x);

		}
	}

	public void Swap(int firstIndex, int secondIndex)
	{
		int temp = list[firstIndex];
		list[firstIndex] = list[secondIndex];
		list[secondIndex] = temp;

	}

	@Override
	public void step(int currentStep)
	{
		// Implemented using
		// https://en.wikipedia.org/wiki/Bubble_sort, as a reference.
		for (int y = 0; y < list.length - currentStep - 1; y++)
		{
			steps++;

			if (list[y] > list[y + 1])
				Swap(y, y + 1);

		}
	}

	@Override
	public int getSortingLength()
	{
		return list.length - 1;

	}
}
