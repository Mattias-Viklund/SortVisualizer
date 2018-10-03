package com.devmew.sortvisualizer.Algorithms;

public class InsertionSort extends AbstractAlgorithm
{
	public InsertionSort(int[] list)
	{
		super(list);

	}

	@Override
	public void Sort()
	{
		for (int x = 0; x < GetSortingLength(); x++)
		{
			Step(x);

		}
	}

	@Override
	public String GetName()
	{
		return "Insertion Sort";
	}

	@Override
	public void Step(int currentStep)
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
	public int GetSortingLength()
	{
		return super.list.length;

	}
}
