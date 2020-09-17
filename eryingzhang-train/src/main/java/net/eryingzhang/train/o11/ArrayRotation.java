package net.eryingzhang.train.o11;

import org.junit.Test;

/**
 * <pre>
 * 求递增数组旋转后最小值，最简单的设定一个最小值指针，遍历获得，
 * 但不能利用递增数组的特性，采用二分法可更快速的得到最小值
 * 	有两个情况需要考虑， 1、旋转了0个长度   2、 存在重复值使二分法中 前后值和比较值都相同的
 * </pre>
 * */
public class ArrayRotation {

	static int getRatationArrayMinValue(int[] arr) {
		if (arr == null || arr.length == 0)
			throw new IllegalArgumentException("invalid parameters");
		int start = 0;
		int end = arr.length - 1;
		int minIndex = start; // 旋转了0个数组的情况，首元素就是最小值的情况
		while (arr[start] >= arr[end]) {
			if (end - start == 1) {
				minIndex = end;
				break;
			}

			/**
			 * <pre>
			 * 旋转后三个数字都相同，则无法判断最小值所在位置需要顺序查找
			 * origin: {0,1,1,1,1,}
			 * rotation: {1,0,1,1,1}、{1,1,1,0,1}
			 * </pre>
			 */
			if (arr[start] == arr[end] && arr[minIndex] == arr[start]) {
				return inorderFindMin(arr, start, end);
			}

			// same minIndex = (end - start) / 2 + start;
			minIndex = (start + end) / 2;
			if (arr[minIndex] <= arr[end]) {
				end = minIndex;
			} else if (arr[minIndex] >= arr[start]) {
				start = minIndex;
			}

		}

		return arr[minIndex];

	}

	static int inorderFindMin(int[] arr, int start, int end) {
		int min = arr[start];
		for (int i : arr) {
			if (i < min)
				min = i;
		}
		return min;
	}

	@Test
	public void test() {
		int[] arr = { 1, 0, 1, 1, 1 };
		System.out.println(getRatationArrayMinValue(arr));
	}
}
