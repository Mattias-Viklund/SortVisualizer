package com.devmew.sortvisualizer.Algorithms;

public class InsertionSort extends AbstractAlgorithm
{
	public InsertionSort(int[] list)
	{
		super(list, "Insertion Sort");

	}

	@Override
	public void sort()
	{
		for (int x = 0; x < getSortingLength(); x++)
		{
			step(x);

		}
	}

	@Override
	public void step(int currentStep)
	{
		// Implemented using
		// https://en.wikipedia.org/wiki/Insertion_sort, as a reference.
		if (currentStep < list.length)
		{
			int key = list[currentStep];
			int y = currentStep - 1;
			while (y >= 0 && list[y] > key)
			{
				steps++;
				list[y + 1] = list[y];
				y--;

			}
			list[y + 1] = key;

		}
	}

	@Override
	public int getSortingLength()
	{
		return super.list.length;

	}
}
