package net.eryingzhang.train.o16;

import java.math.BigDecimal;

/**
 * 错误检查和返回模式采用全局变量，且为静态，测试时就放在最后并且没有在函数中有置0操作  
 * @author Yinjiang.Li
 *
 */
public class LogN {

	static boolean gInvalidInput = false;

	static double powerLow(double value, long exponent) {
		if (value == 0 && exponent < 0) {
			gInvalidInput = true;
			throw new IllegalArgumentException("novalid parameters");
		}
		if (value == 0)
			return 0;
		if (value == 1)
			return 1;
		long absExponent = exponent;
		if (exponent < 0)
			absExponent = -exponent;

		while (absExponent > 1) {
			value = value * value;
			absExponent--;
		}
		if (exponent < 0)
			value = 1 / value;
		return value;
	}

	/**
	 * <pre>
	 * 判断传入参数 尝试对 value值做拆分处理
	 * 符合 斐波那契数列
	 * 
	 * 
	 * </pre>
	 * 
	 * @param value
	 * @param logCount
	 * @return
	 */
	static double powerMiddle(double value, long exponent) {

		if (exponent == 0)
			return 1;
		if (exponent == 1)
			return value;

		double result = powerMiddle(value, exponent >> 1); // 通过位移符替换 /2 操作。效率更快
		result = result * result;
		if ((exponent & 0x1) == 1) // 判断 exponent 是否为奇数
			result = result * value;

		return result;

	}

	static double power(double value, long exponent) {
		if (compart(value, 0.0) == 0 && exponent < 0) {
			gInvalidInput = true;
			return 0.0;
		}
		long absExponent = Math.abs(exponent);
		double result = powerMiddle(value, absExponent);
		if (exponent < 0)
			result = 1.0 / result;
		return result;
	}

	static int compart(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.compareTo(b2);
	}

	static void test(String name, double value, long exponent, double expect, boolean flag) {
		if (expect == power(value, exponent) && flag == gInvalidInput)
			System.out.println(String.format("success name: %s value: %s exponent: %s ", name, value, expect));
		else
			System.err.println(String.format("fail name: %s value: %s exponent: %s ", name, value, expect));
	}

	public static void main(String[] args) {
		// 底数、指数都为正数
		test("test1", 2, 3, 8, false);

		// 底数为负数、指数为正数
		test("test2", -2, 3, -8, false);

		// 指数为负数
		test("test3", 2, -3, 0.125, false);

		// 指数为0
		test("test4", 2, 0, 1, false);

		// 底数、指数都为0
		test("test5", 0, 0, 1, false);

		// 底数为0、指数为正数
		test("test6", 0, 4, 0, false);

		// 底数为0、指数为负数
		test("test7", 0, -4, 0, true);
	}
}
