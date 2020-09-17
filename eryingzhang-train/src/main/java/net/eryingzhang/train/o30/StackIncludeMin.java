package net.eryingzhang.train.o30;

import java.util.Stack;

/**
 * 实现一个栈， 取出最小值、 push、 pop 时间复杂度皆为1 建立一个辅助栈，和数据栈同进同出。保证在同一时刻。辅助栈栈顶元素为当前数据栈中的最小值
 * 
 * @author Yinjiang.Li
 *
 */
public class StackIncludeMin<T> {
	private Stack<T> dataStack = new Stack<T>();
	private Stack<T> assistStack = new Stack<T>();

	public void push(T v) {
		synchronized (StackIncludeMin.class) {
			dataStack.push(v);
			T min = v;
			if (!assistStack.isEmpty() && !max(assistStack.lastElement(), v)) {
				min = assistStack.lastElement();
			}
			assistStack.push(min);
		}
	}

	public T pop() {
		if (dataStack.isEmpty())
			throw new IllegalArgumentException("stack is null");
		synchronized (StackIncludeMin.class) {
			assistStack.pop();
			return dataStack.pop();
		}
	}

	public T min() {
		if (assistStack.isEmpty())
			throw new IllegalArgumentException("stack is null");
		return assistStack.lastElement();
	}

	private boolean max(T t1, T t2) {
		if (t1 instanceof Integer) {
			return (Integer) t1 > (Integer) t2;
		}
		return false;
	}

	static void Test(String testName, StackIncludeMin<Integer> stack, int expected) {
		if (testName != null)
			System.out.println(String.format("%s begins: ", testName));

		if (stack.min() == expected)
			System.out.println("Passed.");
		else
			System.out.println("Failed.");
	}

	public static void main(String[] args) {

		StackIncludeMin<Integer> stack = new StackIncludeMin<Integer>();

		stack.push(3);
		Test("Test1", stack, 3);

		stack.push(4);
		Test("Test2", stack, 3);

		stack.push(2);
		Test("Test3", stack, 2);

		stack.push(3);
		Test("Test4", stack, 2);

		stack.pop();
		Test("Test5", stack, 2);

		stack.pop();
		Test("Test6", stack, 3);

		stack.pop();
		Test("Test7", stack, 3);

		stack.push(0);
		Test("Test8", stack, 0);

	}

}
