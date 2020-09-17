package net.eryingzhang.train.o13;

import org.junit.Test;

/***
 * 机器人运动范围 利用回溯 一个矩阵， 一个矩阵大小的 bool数组，标识能够到达的地点。 约束值 一个判断可达性方法 根据该规则可生成类似于迷宫路线
 * 
 * @author Yinjiang.Li
 *
 */
public class RobotPath {

	public static void searchCount(String testName, int constraintValue, int rows, int cols, int expected) {
		if (rows < 0 || cols < 0 || constraintValue < 0)
			throw new IllegalArgumentException("novalid parameters");

		boolean[] access = new boolean[rows * cols];
		int count = search(rows, cols, 0, 0, constraintValue, access);
		if (count == expected) {
			System.out.println(testName + " Passed");
		} else {
			System.err.println(testName + " Failed");
		}
	}

	public static int search(int rows, int cols, int row, int col, int constraintValue, boolean[] access) {
		int count = 0;
		if (access(rows, cols, row, col, constraintValue, access)) {
			access[row * cols + col] = true;
			count = 1 + search(rows, cols, row - 1, col, constraintValue, access)
					+ search(rows, cols, row + 1, col, constraintValue, access)
					+ search(rows, cols, row, col - 1, constraintValue, access)
					+ search(rows, cols, row, col + 1, constraintValue, access);

		}
		return count;
	}

	static boolean access(int rows, int cols, int row, int col, int constraintValue, boolean[] access) {
		if (row < 0 || row >= rows || col < 0 || col >= cols || access[row * cols + col]
				|| (digitSum(row) + digitSum(col)) > constraintValue)
			return false;

		return true;
	}

	static int digitSum(Object o) {

		int i = Integer.valueOf(o.toString());
		int sum = 0;
		while (i > 0) {
			sum += i % 10;
			i = i / 10;
		}
		return sum;
	}

	@Test
	public void test() {
		searchCount("方格多行多列", 5, 10, 10, 21);
		searchCount("方格多行多列", 15, 20, 20, 359);
		searchCount("方格只有一行，机器人只能到达部分方格", 10, 1, 100, 29);
		searchCount("方格只有一行，机器人能到达所有方格", 10, 1, 10, 10);
		searchCount("方格只有一列，机器人只能到达部分方格", 15, 100, 1, 79);
		searchCount("方格只有一列，机器人能到达所有方格", 15, 10, 1, 10);
		searchCount("方格只有一行一列", 15, 1, 1, 1);
		searchCount("方格只有一行一列", 0, 1, 1, 1);
		searchCount("机器人不能进入任意一个方格", -10, 10, 10, 0);
	}
}
