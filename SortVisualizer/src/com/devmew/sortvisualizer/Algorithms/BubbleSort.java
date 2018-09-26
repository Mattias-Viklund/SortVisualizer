package com.devmew.sortvisualizer.Algorithms;

public class BubbleSort extends AlgorithmBase {
	public BubbleSort(int[] list) {
		super(list);

	}
	
	@Override
	public void Sort() {
		int length = list.length;
		
		// Implemented using
		// https://en.wikipedia.org/wiki/Bubble_sort, as a reference.
        for (int x = 0; x < length - 1; x++) {
            for (int y = 0; y < length - x - 1; y++) {
        		steps++;
            	
                if (list[y] > list[y+1])
                    Swap(y, y + 1);
                
            }
        }
	}
	
	public void Swap(int firstIndex, int secondIndex) {
		int temp = list[firstIndex];
		list[firstIndex] = list[secondIndex];
		list[secondIndex] = temp;
		
	}

	@Override
	public int[] GetList() {
		return list;
		
		
	}

	@Override
	public String GetName() {
		return "Bubble Sort";
		
	}
	
	@Override
	public void Step() {
		// TODO Auto-generated method stub
		
	}
}
