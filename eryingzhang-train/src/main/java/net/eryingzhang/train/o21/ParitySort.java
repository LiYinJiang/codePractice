package net.eryingzhang.train.o21;

import java.util.Arrays;

/**
 * 对数组进行排序，要求奇数在前，偶数在后
 * 
 * @author Yinjiang.Li
 *
 */
public class ParitySort {

	static void paritySort(int[] arr) {
		if (arr == null || arr.length == 0)
			return;

		recusiveSort(arr, 0, arr.length - 1);

	}

	/**
	 * 通过比较头尾指针的值
	 * 
	 * @param arr
	 * @param headIndex
	 * @param tailIndex
	 */
	static void recusiveSort(int[] arr, int headIndex, int tailIndex) {

		if (headIndex == tailIndex)
			return;

		// 如果头节点能被2 整除则是偶数，需要和头部的奇数交换位置
		while (!isEven(arr[headIndex])) {
			headIndex++;
		}

		while (isEven(arr[tailIndex])) {
			tailIndex--;
		}

		if (headIndex < tailIndex) {
			if (isEven(arr[headIndex]) && !isEven(arr[tailIndex]))
				swap(arr, headIndex, tailIndex);
			recusiveSort(arr, headIndex + 1, tailIndex - 1);
		}
	}
	
	/**
	 *  判斷是否為负数的条件，也可根据题目改为其他判断。框架不需要改变
	 *  做进一步抽象可以 通过接口、 类 做不同的实现。不需要改变调用
	 * @param value
	 * @return
	 */
	static boolean isEven(int value) {
		return (value & 1) == 0;
	}

	static void swap(int[] arr, int indexA, int indexB) {
		if (arr == null || indexA < 0 || indexA > arr.length || indexB < 0 || indexB > arr.length)
			return;
		int temp = arr[indexA];
		arr[indexA] = arr[indexB];
		arr[indexB] = temp;

	}

	// ====================测试代码====================
	static void printArray(int[] numbers) {
		if (numbers == null || numbers.length < 0)
			return;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numbers.length; ++i)
			sb.append(numbers[i]);

		System.out.println(sb.toString());
	}

	static void Test(String testName, int numbers[]) {
		if (testName != null)
			System.out.println("%s begins:" + testName);

		System.out.println("Test for solution 1:");
		printArray(numbers);
		paritySort(numbers);
		printArray(numbers);

	}

	static void Test1() {
		int numbers[] = { 1, 2, 3, 4, 5, 6, 7 };
		Test("Test1", numbers);
	}

	static void Test2() {
		int numbers[] = { 2, 4, 6, 1, 3, 5, 7 };
		Test("Test2", numbers);
	}

	static void Test3() {
		int numbers[] = { 1, 3, 5, 7, 2, 4, 6 };
		Test("Test3", numbers);
	}

	static void Test4() {
		int numbers[] = { 1 };
		Test("Test4", numbers);
	}

	static void Test5() {
		int numbers[] = { 2 };
		Test("Test5", numbers);
	}

	static void Test6() {
		Test("Test6", null);
	}

	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
		Test6();
	}
}
