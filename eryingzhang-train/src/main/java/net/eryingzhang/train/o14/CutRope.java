package net.eryingzhang.train.o14;

import org.junit.Test;

public class CutRope {

	static int dynamicProgramming(int length) {

		if (length == 2)
			return 1;
		if (length == 3)
			return 2;
		int[] products = new int[length + 1];
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;
		int max = 0;
		for (int i = 4; i <= length; i++) {
			max = 0;
			for (int j = 1; j <= i / 2; j++) {
				int product = products[j] * products[i - j];
				if (max < product)
					max = product;

				products[i] = max;
			}

		}
		return max;
	}

	static int greedyCut(int length) {
		if (length == 0)
			return 0;
		if (length == 1)
			return 1;
		if (length == 2)
			return 2;
		if (length == 3)
			return 3;
		int count3 = length / 3;

		if (length - length / 3 == 1) // 如果尽可能让3整除后余数为1 则减少一个 留出余数 4 让2整除
			count3--;
		int count2 = (length - count3 * 3) / 2;
		return 2 * count2 * 3 * count3;

	}

	@Test
	public void test() {
		System.out.println(dynamicProgramming(4));
	}
}
