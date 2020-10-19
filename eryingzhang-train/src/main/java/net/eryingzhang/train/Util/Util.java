package net.eryingzhang.train.Util;

public class Util {

	public static <T> void swap(T[] arr, int a, int b) {
		if (a == b)
			return;
		if (a < 0 || b > arr.length - 1)
			return;
		T temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static <T> void print(T[] arr) {
		print(arr, 0, arr.length - 1);
	}

	public static <T> void print(T[] arr, int start, int end) {
		if (arr == null || start < 0 || end > arr.length)
			return;
		StringBuffer sb = new StringBuffer();
		for (int i = start; i <= end; i++) {

			sb.append(arr[i]);
		}
		System.out.println(sb.toString());
	}
}
