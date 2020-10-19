package net.eryingzhang.train.o40;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 输出数组中第K 小的数字
 * 
 * @author Yinjiang.Li
 *
 */
public class GetLastNumber {

	/**
	 * 通过Stream
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	static Integer[] getLashNumberByStream(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k < 0)
			throw new IllegalArgumentException("novalid parameters");
		Integer[] list = Arrays.stream(arr).boxed().sorted().limit(k).toArray(size -> new Integer[size]);
		return list;

	}

	static Integer[] getLashNumberByTreeSet(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k < 0)
			throw new IllegalArgumentException("novalid parameters");
		TreeSet<Integer> tree = new TreeSet<Integer>();
		for (int i = 0; i < k; i++) {
			tree.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {
			int max = tree.last();
			if (arr[k] < max) {
				tree.remove(max);
				tree.add(arr[k]);
			}
		}
		Integer[] array = new Integer[tree.size()];
		tree.toArray(array);
		return array;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 4, 5, 1, 6, 2, 7, 3, 8 };
		Integer[] list = getLashNumberByStream(a, 4);
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
}
