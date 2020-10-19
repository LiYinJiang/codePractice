package net.eryingzhang.train.o11;

import org.junit.Test;

import net.eryingzhang.train.Util.Util;

public class QuickSort {

	static int partition(Integer[] arr, int start, int end) {
		if (arr == null || arr.length == 0 || start < 0 || end >= arr.length)
			throw new IllegalArgumentException("invalid parameters");

		int base = arr.length / 2;
		Util.swap(arr, end, base);

		int small = start - 1;
		for (int i = start; i < arr.length; i++) {
			if (arr[i] < arr[end]) {
				++small;
				if (small != i)
					Util.swap(arr, i, small);

			}
		}
		++small;
		Util.swap(arr, small, end);
		return small;
	}

	static void quickSort(Integer[] arr, int start, int end) {
		if (start == end)
			return;

		int index = partition(arr, start, end);
		if (index > start)
			quickSort(arr, start, index - 1);
		if (index < end)
			quickSort(arr, index + 1, end);

	}

	static <T> void printArr(T[] arr) {
		StringBuffer sb = new StringBuffer();
		for (T t : arr) {
			sb.append(" " + t.toString());
		}
		System.out.println(sb.toString());
	}

	@Test
	public void test() {
		Integer arr[] = new Integer[] { 1, 2, 5, 4, 3 };// { 5,4,3,2,1 };
		quickSort(arr, 0, arr.length - 1);
		printArr(arr);
	}
}
