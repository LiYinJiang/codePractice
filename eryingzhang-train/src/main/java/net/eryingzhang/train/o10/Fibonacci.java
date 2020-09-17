package net.eryingzhang.train.o10;

import org.junit.Test;

public class Fibonacci {
	static long low(long v) {
		if (v == 0)
			return 0;
		if (v == 1)
			return 1;
		return low(v - 1) + low(v - 2);
	}

	static long midddle(int v) {

		if (v < 2)
			return v;
		int one = 1;
		int two = 0;
		int sum = 0;
		for (int i = 2; i <= v; i++) {
			sum = one + two;
			two = one;
			one = sum;
		}
		return sum;
	}

	/**
	 * 青蛙跳台阶，
	 * 
	 */
	static long frogJump(int levelCount) {
		if (levelCount < 3)
			return levelCount;
		int one = 2;
		int two = 1;
		int sum = 0;
		for (int i = 3; i <= levelCount; i++) {
			sum = one + two;
			two = one;
			one = sum;
		}
		return sum;

	}

	@Test
	public void testFunction() {
		System.out.println(String.format("low: %s middle: %s frog: %s", low(3), midddle(5), frogJump(3)));
	}

	@Test
	public void testBoundary() {
		String.format("low: %s middle: %s frog: %s", low(0), midddle(1), frogJump(2));
	}

	@Test
	public void testPerformance() {
		long start = System.currentTimeMillis();
		low(30);
		long end = System.currentTimeMillis();
		System.out.println("interval: " + (end - start));

		midddle(30);
		start = System.currentTimeMillis();
		System.out.println("interval: " + (start - end));

		frogJump(30);
		end = System.currentTimeMillis();
		System.out.println("interval: " + (end - start));
	}

}
