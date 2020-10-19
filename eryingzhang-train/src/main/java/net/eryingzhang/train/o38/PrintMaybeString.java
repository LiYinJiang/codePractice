package net.eryingzhang.train.o38;

import net.eryingzhang.train.Util.Util;

/**
 * 输入 字符串，输出乱序后可能的字串。
 * 
 * @author Yinjiang.Li
 *
 */
public class PrintMaybeString {

	static void printAllString(String origin) {
		if (origin == null)
			throw new IllegalArgumentException("novalid parameters");
		String[] data = origin.trim().split("");
		printAllString(data, 0);

	}

	/**
	 * 
	 * @param origin
	 * @param startIndex
	 */
	static void printAllString(String[] origin, int startIndex) {

		int nextStartIndex = startIndex + 1;
		int temp = startIndex + 1;
		while (temp < origin.length) {
			Util.swap(origin, startIndex, temp);
			Util.print(origin);
			Util.swap(origin, temp, startIndex);
			temp++;
		}

		if (startIndex < origin.length - 1) {
			printAllString(origin, nextStartIndex);
		}

	}



	/**
	 * 不需要改变顺序 打印字符串所有可能的组合
	 * 
	 * <pre>
	 *   in:  abc  out: a,b,c, ab,bc, abc
	 * </pre>
	 * 
	 * @param str
	 */
	static void printAllAssemble(String str) {
		if (str == null)
			throw new IllegalArgumentException("novalid parameters");
		String[] data = str.trim().split("");
		printAllAssemble(data, 0);

	}

	static void printAllAssemble(String[] content, int startIndex) {

		int assembleLength = 0;
		while (content.length > startIndex + assembleLength) {
			Util.print(content, startIndex, startIndex +assembleLength);
			assembleLength++;
		}
		startIndex++;
		if (startIndex < content.length)
			printAllAssemble(content, startIndex);
	}

	// ====================测试代码====================
	static void Test(String pStr) {
		if (pStr == null)
			System.out.println("Test for nullptr begins:");
		else
			System.out.println(String.format("Test for %s begins:", pStr));

		printAllString(pStr);

	}

	public static void main(String[] args) {

//		String string2 = "a";
//		Test(string2);
//
//		String string3 = "ab";
//		Test(string3);
//
//		String string4 = "abc";
//		Test(string4);
//
//		String string1 = "";
		//Test(string1);

		//Test(null);
		printAllAssemble("abc");
	}

}
