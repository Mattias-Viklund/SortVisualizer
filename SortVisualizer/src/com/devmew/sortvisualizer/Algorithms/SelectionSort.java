package com.devmew.sortvisualizer.Algorithms;

public class SelectionSort extends AlgorithmBase
{
	private int[] list;
	private int steps = 0;
	
	public SelectionSort(int[] list)
	{
		super(list);
		this.list = list;
		
	}

	@Override
	public void Sort()
	{
		int length = list.length;
		
		// Implemented using
		// https://en.wikipedia.org/wiki/Selection_sort, as a reference
        for (int x = 0; x < length - 1; x++) {
            int minIndex = x;
            for (int y = x + 1; y < length; y++) {
            	steps++;
            	
                if (list[y] < list[minIndex]) {
                    minIndex = y;
                    
                }
            }
            Swap(x, minIndex);
            
        }
	}
	
	public void Swap(int firstIndex, int secondIndex) {
		int temp = list[firstIndex];
		list[firstIndex] = list[secondIndex];
		list[secondIndex] = temp;
		
	}

	@Override
	public int[] GetList()
	{
		return list;
		
	}

	@Override
	public String GetName()
	{
		return "Selection Sort";
		
	}

	@Override
	public int StepsTaken()
	{
		return steps;
		
	}
}
