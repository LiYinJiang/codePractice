package net.eryingzhang.train.o39;

/**
 * 打印出数组中出现的重复次数超过一半的数字，不存在则抛出异常
 * 
 * @author Yinjiang.Li
 *
 */
public class PrintHalfRepeatNumber {

	public static int PrintHalfRepeatNumber(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int result = array[0];
		int times = 1;
		for (int i = 1; i < array.length; i++) {
			if (times == 0) {
				result = array[i];
				times = 1;
			}

			if (array[i] == result) {
				times++;
			} else {
				times--;
			}
		}
		if (checkMoreThanHalf(array, result)) {
			return result;
		} else {
			return 0;
		}

	}

	/**
	 * 检查result是不是在array出现次数超过一半
	 * 
	 * @param array
	 * @param result
	 * @return
	 */
	public static boolean checkMoreThanHalf(int[] array, int result) {
		boolean isMoreThanHalf = false;
		int times = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == result) {
				times++;
			}
		}
		if (times > (array.length >> 1)) {
			isMoreThanHalf = true;
		}
		return isMoreThanHalf;

	}

	// ====================测试代码====================
	static void Test(String testName, int[] numbers, int expectedValue, boolean expectedFlag) {
		if (testName != null)
			System.out.println(String.format("%s begins: \n", testName));

		int[] copy = new int[numbers.length];
		for (int i = 0; i < copy.length; ++i)
			copy[i] = numbers[i];

		System.out.println("Test for solution1: ");
		int result = PrintHalfRepeatNumber(numbers);
		if (result == expectedValue)
			System.out.println("Passed.\n");
		else
			System.out.println("Failed.\n");

	}

	// 存在出现次数超过数组长度一半的数字
	static void Test1() {
		int numbers[] = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		Test("Test1", numbers, 2, false);
	}

	// 不存在出现次数超过数组长度一半的数字
	static void Test2() {
		int numbers[] = { 1, 2, 3, 2, 4, 2, 5, 2, 3 };
		Test("Test2", numbers, 0, true);
	}

	// 出现次数超过数组长度一半的数字都出现在数组的前半部分
	static void Test3() {
		int numbers[] = { 2, 2, 2, 2, 2, 1, 3, 4, 5 };
		Test("Test3", numbers, 2, false);
	}

	// 出现次数超过数组长度一半的数字都出现在数组的后半部分
	static void Test4() {
		int numbers[] = { 1, 3, 4, 5, 2, 2, 2, 2, 2 };
		Test("Test4", numbers, 2, false);
	}

	// 输入空指针
	static void Test5() {
		int numbers[] = { 1 };
		Test("Test5", numbers, 1, false);
	}

	// 输入空指针
	static void Test6() {
		Test("Test6", null, 0, true);
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
