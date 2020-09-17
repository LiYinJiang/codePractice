package net.eryingzhang.train.o31;

import java.util.Stack;

/**
 * 传入 入栈和出栈序列， 根据入栈序列判断出栈序列是否合理
 * 
 * @author Yinjiang.Li
 *
 */
public class StackSequence {

	/**
	 * 入栈序列压入栈中，直到栈顶元素和出栈序列第一个一致，若全压入仍和入栈序列第一个不同则 返回false 找到匹配的出栈元素后，
	 * 建立循环，结束条件为出栈序列为空。 判断栈顶元素是否等于出栈序列。等于则出栈。序列-1 不等则做入栈操作。若入栈元素已为空则放回false
	 * 
	 * @param pushSequence
	 * @param popSequence
	 * @return
	 */
	static boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
		if (pushSequence == null || popSequence == null || pushSequence.length != popSequence.length
				|| pushSequence.length == 0)
			throw new IllegalArgumentException("novalid parameters");
		Stack<Integer> stack = new Stack<Integer>();
		int pushIndex = 0;
		int popIndex = 0;
		
		

		while (popIndex < popSequence.length) {
			while (!stack.isEmpty() && stack.lastElement() == popSequence[popIndex]) { 
				popIndex++;
				stack.pop();
			}
			if (popIndex == popSequence.length) //出栈序列为空，完成
				return true;
			if (stack.isEmpty() || stack.lastElement() != popSequence[popIndex]) {
				if (pushIndex >= pushSequence.length) {
					return false;
				} else {
					stack.push(pushSequence[pushIndex]);
					pushIndex++;
				}
			}
		} // 出栈 over 
		return true;
	}

	static void Test(String testName, int[] pPush, int[] pPop, boolean expected) {
		if (testName != null)
			System.out.println(String.format("%s begins: ", testName));

		if (IsPopOrder(pPush, pPop) == expected)
			System.out.println("Passed.");
		else
			System.out.println("failed.");
	}

	static void Test1() {
		int push[] = { 1, 2, 3, 4, 5 };
		int pop[] = { 4, 5, 3, 2, 1 };

		Test("Test1", push, pop, true);
	}

	static void Test2() {
		int push[] = { 1, 2, 3, 4, 5 };
		int pop[] = { 3, 5, 4, 2, 1 };

		Test("Test2", push, pop, true);
	}

	static void Test3() {
		int push[] = { 1, 2, 3, 4, 5 };
		int pop[] = { 4, 3, 5, 1, 2 };

		Test("Test3", push, pop, false);
	}

	static void Test4() {
		int push[] = { 1, 2, 3, 4, 5 };
		int pop[] = { 3, 5, 4, 1, 2 };

		Test("Test4", push, pop, false);
	}

	// push和pop序列只有一个数字
	static void Test5() {
		int push[] = { 1 };
		int pop[] = { 2 };

		Test("Test5", push, pop, false);
	}

	static void Test6() {
		int push[] = { 1 };
		int pop[] = { 1 };

		Test("Test6", push, pop, true);
	}

	static void Test7() {
		Test("Test7", null, null, false);
	}

	public static void main(String[] args) {

		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
		Test6();
		Test7();

	}
}
