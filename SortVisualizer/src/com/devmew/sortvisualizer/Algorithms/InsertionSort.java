package com.devmew.sortvisualizer.Algorithms;

public class InsertionSort extends AlgorithmBase {
	public InsertionSort(int[] list) {
		super(list);

	}

	@Override
	public void Sort() {
		int length = list.length;

		// Implemented using
		// https://en.wikipedia.org/wiki/Insertion_sort, as a reference.
		for (int x = 0; x < length; x++) {
			int key = list[x];
			int y = x - 1;
			while (y >= 0 && list[y] > key) {
				steps++;
				list[y + 1] = list[y];
				y--;

			}
			list[y + 1] = key;

		}
	}

	@Override
	public int[] GetList() {
		return list;

	}

	@Override
	public String GetName() {
		return "Insertion Sort";
	}

	@Override
	public void Step() {
		// TODO Auto-generated method stub
		
	}

}
