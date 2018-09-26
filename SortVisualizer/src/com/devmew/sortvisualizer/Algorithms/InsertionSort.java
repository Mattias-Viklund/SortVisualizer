package com.devmew.sortvisualizer.Algorithms;

public class InsertionSort extends AlgorithmBase {
	private int[] list;

	private int steps = 0;

	public InsertionSort(int[] list) {
		super(list);
		this.list = list;

	}

	@Override
	public void Sort() {
		int length = list.length;

		// Implemented using
		// https://en.wikipedia.org/wiki/Insertion_sort, as a reference.
		for (int i = 0; i < length; i++) {
			int key = list[i];
			int j = i - 1;
			while (j >= 0 && list[j] > key) {
				steps++;
				list[j + 1] = list[j];
				j--;

			}
			list[j + 1] = key;

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
	public int StepsTaken() {
		return steps;

	}

}
