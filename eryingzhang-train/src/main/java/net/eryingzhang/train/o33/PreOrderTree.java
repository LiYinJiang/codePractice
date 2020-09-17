package net.eryingzhang.train.o33;

/**
 * 判断数组是否是前序遍历树
 * 
 * @author Yinjiang.Li
 *
 */
public class PreOrderTree {
	static boolean postOrderTree(int[] postArr) {
		if (postArr == null || postArr.length <= 0)
			throw new IllegalArgumentException("novalid parameters");
		return postOrderTreeByRecusive(postArr, 0, postArr.length - 1);
	}

	static boolean postOrderTreeByRecusive(int[] postArr, int start, int end) {

		int root = postArr[start];
		int leftEnd = start + 1;
		while (postArr[leftEnd] < root && leftEnd < end) {
			leftEnd++;
		}
		int rightStart = leftEnd;
		while (rightStart < end) {
			if (postArr[rightStart] < root)
				return false;
			rightStart++;
		}
		boolean preOrder = true;
		if (leftEnd - 1 > start)
			preOrder = preOrder && postOrderTreeByRecusive(postArr, start + 1, leftEnd - 1);
		if (leftEnd < end)
			preOrder = preOrder && postOrderTreeByRecusive(postArr, leftEnd, end);
		return preOrder;

	}

	// ====================测试代码====================
	static void Test(String testName, int sequence[], boolean expected) {
		if (testName != null)
			System.out.println(String.format("%s begins: ", testName));

		if (postOrderTree(sequence) == expected)
			System.out.println("passed.");
		else
			System.out.println("failed.");
	}

	/**
	 * <pre>
	   		10
	     /      \
	    6        14
	   /\        /\
	  4  8     12  16
	 * </pre>
	 */
	static void Test1() {
		int data[] = { 10, 6, 4, 8, 14, 12, 16 };
		Test("Test1", data, true);
	}

	/**
	 * <pre>
	 *     5
	      / \
	     4   7
	        /
	       6
	 * </pre>
	 */
	static void Test2() {
		int data[] = { 5, 4, 7, 6 };
		Test("Test2", data, true);
	}

	/**
	 * <pre>
	 * 5 / 4 / 3 / 2 / 1
	 * </pre>
	 */
	static void Test3() {
		int data[] = { 5, 4, 3, 2, 1 };
		Test("Test3", data, true);
	}

	/**
	 * <pre>
	 * 
	1
	\
	2
	\
	 3
	  \
	   4
	    \
	     5
	 * </pre>
	 */
	static void Test4() {
		int data[] = { 1, 2, 3, 4, 5 };
		Test("Test4", data, true);
	}

	// 树中只有1个结点
	static void Test5() {
		int data[] = { 5 };
		Test("Test5", data, true);
	}

	static void Test6() {
		int data[] = { 7, 4, 6, 5 };
		Test("Test6", data, false);
	}

	static void Test7() {
		int data[] = { 4, 6, 12, 8, 16, 14, 10 };
		Test("Test7", data, false);
	}

	static void Test8() {
		Test("Test8", null, false);
	}

	public static void main(String[] args) {

		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
		Test6();
		Test7();
		Test8();

	}

}
