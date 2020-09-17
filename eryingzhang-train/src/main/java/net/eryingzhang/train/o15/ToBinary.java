package net.eryingzhang.train.o15;

import org.junit.Test;

public class ToBinary {

	/**
	 * 获取十进制整型值的二进制中1的个数 通过左移实现 --->
	 * 
	 * @param number
	 * @return 1的总数
	 */
	static void getOneCountByLeft(int number) {
		int count = 0;
		int temp = number;
		while (temp != 0) {
			if ((temp & 1) == 1)
				count++;
			temp = temp >> 1;
		}

		System.out.println(String.format("left decimal: %s binary: %s  1 count: %s", number,
				Integer.toBinaryString(number), count));
	}

	/**
	 * 考虑到负数的情况，最高位为1 <---
	 * 
	 * @param number
	 */
	static void getOneCountByRight(int number) {
		int count = 0;
		int temp = 1;
		while (temp != 0) {
			if ((temp & number) != 0)
				count++;
			temp = temp << 1;
		}

		System.out.println(String.format("right decimal: %s binary: %s  1 count: %s", number,
				Integer.toBinaryString(number), count));
	}

	/**
	 * <pre>
	 *  将 参数 -1 后和原始数据做于操作得到最右边的1为0的结果，那么有多少个 0就能执行多少次
	 *  1100   -1 =  1011 
	 *  1100 & 1011 = 1000  
	 *  1000与1100 相比，最右边的1 被抹去
	 * </pre>
	 * 
	 * @param number
	 */
	static int getOneCount(int number) {
		int temp = number;
		int count = 0;

		while (temp != 0) {
			count++;
			temp = (temp - 1 & temp);
		}
		System.out.println(
				String.format("decimal: %s binary: %s  1 count: %s", number, Integer.toBinaryString(number), count));
		return count;
	}

	/**
	 * m 要改变几个二进制位才能得到 n 分别获取1的个数， 对m 和 n 做异或操作，对于不同的位置 被置 1 求 异或后1的个数
	 * 
	 * @param m
	 * @param n
	 */
	static void get(int m, int n) {
		int common = m ^ n;
		int count = getOneCount(common);

		System.out.println(String.format("decimal: m %s n %s binary: m %s n %s differentCount: %s", m, n,
				Integer.toBinaryString(m), Integer.toBinaryString(n), count));
	}

	@Test
	public void test() {
		getOneCountByLeft(9527);
		getOneCountByRight(9527);
		getOneCount(9527);
		get(9527, 9500);
		get(10, 16);
	}
}
