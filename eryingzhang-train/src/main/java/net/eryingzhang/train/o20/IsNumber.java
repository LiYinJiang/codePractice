package net.eryingzhang.train.o20;

public class IsNumber {
	static int NUMBER_INDEX;

	static boolean isNumberByReg(String number) {
		if (number == null || number.isEmpty())
			return false;
		return number.matches("[+-]?\\d*.*(\\d+)?([eE]*[+-]?\\d+)?");
	}
	
	
	/**
	 *  从头到尾进行模式匹配 
	 *  [A] --> [A.] --> A[.[B]] --> [A.[B] e|E C]  
	 * @param number
	 * @return
	 */
	static boolean isNumber(String number) {
		NUMBER_INDEX = 0;
		if (number == null || number.isEmpty())
			return false;
		//A
		boolean hasNumber = scanInt(number);
		
		//B
		if (NUMBER_INDEX < number.length() && number.charAt(NUMBER_INDEX) == '.') {
			NUMBER_INDEX++;

			// 小数点后可以没有数字
			hasNumber = scanUnsignInt(number) || hasNumber;
		}
		
		//C
		if (NUMBER_INDEX < number.length()
				&& (number.charAt(NUMBER_INDEX) == 'e' || number.charAt(NUMBER_INDEX) == 'E')) {
			NUMBER_INDEX++;
			// e or E 后面必须有数字
			hasNumber = scanInt(number) && hasNumber;
		}
		return hasNumber && NUMBER_INDEX == number.length();
	}

	static boolean scanInt(String number) {
		if (NUMBER_INDEX < number.length()
				&& (number.charAt(NUMBER_INDEX) == '+' || number.charAt(NUMBER_INDEX) == '-'))
			NUMBER_INDEX++;
		return scanUnsignInt(number);
	}

	static boolean scanUnsignInt(String number) {
		int scanIndex = NUMBER_INDEX;
		while (NUMBER_INDEX < number.length() && (number.charAt(NUMBER_INDEX) >= '0' && number.charAt(NUMBER_INDEX) <= '9')) {
			NUMBER_INDEX++;
		}
		return scanIndex < NUMBER_INDEX;
	}

	static void Test(String testName, String number, boolean expected) {
		if (testName != null)
			System.out.println("%s begins: " + testName);

		if (isNumber(number) == expected)
			System.out.println("Passed.");
		else
			System.out.println("=======FAILED.==========");
	}

	public static void main(String[] args) {
		Test("Test1", "100", true);
		Test("Test2", "123.45e+6", true);
		Test("Test3", "+500", true);
		Test("Test4", "5e2", true);
		Test("Test5", "3.1416", true);
		Test("Test6", "600.", true);
		Test("Test7", "-.123", true);
		Test("Test8", "-1E-16", true);
		Test("Test9", "1.79769313486232E+308", true);

		Test("Test10", "12e", false);
		Test("Test11", "1a3.14", false);
		Test("Test12", "1+23", false);
		Test("Test13", "1.2.3", false);
		Test("Test14", "+-5", false);
		Test("Test15", "12e+5.4", false);
		Test("Test16", ".", false);
		Test("Test17", ".e1", false);
		Test("Test18", "e1", false);
		Test("Test19", "+.", false);
		Test("Test20", "", false);
		Test("Test21", null, false);
	}
}
