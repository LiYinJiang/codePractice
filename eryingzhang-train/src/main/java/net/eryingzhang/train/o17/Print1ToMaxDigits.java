package net.eryingzhang.train.o17;

import java.awt.event.InputEvent;

public class Print1ToMaxDigits {

	/**
	 * 任意大数相加。 转为数组，对两个中数组进行相加。 符号位不同可以变为两数相减，
	 * 
	 * @param a
	 * @param b
	 */
	static void BigIntSum(String a, String b) {
		// 是否為整形值 參數檢查， 0值 正負。

		// 比較長度獲取較大字符，相等則去第一個。 根據长度声明数组， 从高位开始依次加入
		String bigger = a.length() >= b.length() ? a : b;
		char[] charSum = new char[bigger.length() + 1];// 考虑到 最终进位

		int takeOver = 0;
		int one = 0;
		int two = 0;

		int sum = 0;
		for (int i = 0; i < charSum.length; i++) {
			if (a.length() > i)
				one = a.charAt(a.length() - i - 1) - '0';
			else
				one = 0;
			if (b.length() > i)
				two = b.charAt(b.length() - i - 1) - '0';
			else
				two = 0;

			sum = one + two + takeOver;
			if (sum >= 10) {
				sum = sum%10; 
				takeOver = 1;
			} else {
				takeOver = 0;
			}
			charSum[charSum.length - 1 - i] = (char) (sum + '0');
		}
		StringBuffer sb = new StringBuffer();
		boolean began = true;
		for (char c : charSum) {
			if (began && c != '0')
				began = false;
			if (!began)
				sb.append(c);
		}
		System.out.println("big int add: " + sb.toString());
	}

	static String BigIntAdd(String a, String b) {
		return null;
	}

	static String BigIntSubtract(String a, String b) {
		return null;
	}

	static void print1ToMaxDigitsRecuSively(char[] number, int index) {
		if (index > number.length - 1) {
			printNumber(number);
			return;
		}
		for (int i = 0; i < 10; i++) {
			number[index] = (char) ('0' + i);
			print1ToMaxDigitsRecuSively(number, index + 1);
		}

	}

	static void print1ToMaxDigitsByRecusively(int n) {
		if (n < 0)
			throw new IllegalArgumentException("novalid parameters");

		char[] number = new char[n];
		print1ToMaxDigitsRecuSively(number, 0);

	}

	static void print1ToMaxDigits(int n) {
		if (n < 0)
			throw new IllegalArgumentException("novalid parameters");
		char[] number = new char[n];
		initCharArray(number);
		while (!increment(number)) {
			printNumber(number);
		}
	}

	/**
	 * <pre>
	 * 
	 * </pre>
	 * 
	 * @param number
	 * @return
	 */
	static boolean increment(char[] number) {
		boolean isOverFlow = false;
		int takeOver = 0;
		for (int i = number.length - 1; i >= 0; i--) { // 从个位开始判断,number[0] 即为最高位
			int sum = number[i] - '0' + takeOver; // 默认值 为 '0' 转为int值为46 ，减去 '0' 后为 0
			if (i == number.length - 1) // 只有在个位时进行 +1
				sum++;
			if (sum == 10) {
				if (i == 0) { // 若已经是最高位，则不能再+1 已经溢出了，
					isOverFlow = true;
				} else { // 本位 置0 进位置1 ，临高位 准备 加1
					sum = 0;
					takeOver = 1;
					number[i] = '0';
				}

			} else {
				number[i] = (char) (sum + '0');
			}

		}

		return isOverFlow;
	}

	static void printNumber(char[] number) {
		StringBuffer sb = new StringBuffer();
		boolean began = true;
		for (char c : number) {
			if (began && c != '0')
				began = false;
			if (!began)
				sb.append(c);
		}
		System.out.println(sb.toString());
	}

	static void initCharArray(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = '0';
		}
	}

	public static void main(String[] args) {
		// print1ToMaxDigits(2);
		// print1ToMaxDigitsByRecusively(2);

		BigIntSum("232123123213562", "932343243332388656");
	}
}
