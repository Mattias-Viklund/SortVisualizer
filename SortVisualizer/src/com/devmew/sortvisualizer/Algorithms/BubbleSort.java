package com.devmew.sortvisualizer.Algorithms;

public class BubbleSort extends AbstractAlgorithm
{
	public BubbleSort(int[] list)
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

	public void Swap(int firstIndex, int secondIndex)
	{
		int temp = list[firstIndex];
		list[firstIndex] = list[secondIndex];
		list[secondIndex] = temp;

	}

	@Override
	public String GetName()
	{
		return "Bubble Sort";

	}

	@Override
	public void Step(int currentStep)
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
	public int GetSortingLength()
	{
		return list.length - 1;

	}
}
