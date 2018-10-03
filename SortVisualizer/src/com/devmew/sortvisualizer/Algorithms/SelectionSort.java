package com.devmew.sortvisualizer.Algorithms;

public class SelectionSort extends AbstractAlgorithm
{
	public SelectionSort(int[] list)
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
		return "Selection Sort";

	}

	@Override
	public void Step(int currentStep)
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
		Swap(currentStep, minIndex);

	}

	@Override
	public int GetSortingLength()
	{
		return super.list.length - 1;

	}
}
