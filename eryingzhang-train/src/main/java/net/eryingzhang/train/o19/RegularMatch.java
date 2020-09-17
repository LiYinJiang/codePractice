package net.eryingzhang.train.o19;

public class RegularMatch {

	/**
	 * <pre>
	 *  . 表示匹配任意一个字符，，  * 匹配上一个字符，有0个或多个 
	 *  example: content =aaa 
	 *	match pattern = a.a  aab*c*a 
	 *  un mathch  aa.a ab*a
	 * </pre>
	 * 
	 * @param content
	 * @param pattern
	 * @return 是否完全匹配
	 */
	static boolean isMath(String content, String pattern) {
		if (content == null || pattern == null || pattern.startsWith("*"))
			return false;

		char[] chContent = new char[content.length()];
		for (int i = 0; i < chContent.length; i++) {
			chContent[i] = content.charAt(i);
		}

		char[] chPatternt = new char[pattern.length()];
		for (int i = 0; i < chPatternt.length; i++) {
			chPatternt[i] = pattern.charAt(i);

		}

		return matchCore(chContent, 0, chPatternt, 0);

	}

	/**
	 * 
	 * 根据索引位置判断是否 是否是提前结束 先对 通配符 * 做判断 在对 . 做判断。 顺序调换会有逻辑错误。
	 * 
	 * @param content
	 * @param contentIndex
	 * @param pattern
	 * @param patternIndex
	 * @return
	 */
	static boolean matchCore(char[] content, int contentIndex, char[] pattern, int patternIndex) {
		if (contentIndex == content.length && patternIndex == pattern.length) // 都匹配完成
			return true;

		if (contentIndex < content.length && patternIndex == pattern.length) // 模式已经匹配完，字串还未结束
			return false;

		if (pattern.length > patternIndex + 1 && pattern[patternIndex + 1] == '*') { // 下一个字符是 *
			if (contentIndex != content.length && (pattern[patternIndex] == content[contentIndex] // 当前字符一致
					|| pattern[patternIndex] == '.')) // 当前字符是 . 而内容匹配还未结束
				return matchCore(content, contentIndex + 1, pattern, patternIndex + 2) // 对于字符一致的情况，
						|| matchCore(content, contentIndex + 1, pattern, patternIndex) // * 可以匹配多位，继续向后匹配
						|| matchCore(content, contentIndex, pattern, patternIndex + 2); // * 可以表示0位，而模式和内容不同的情况 。直接跳过  当前位和*  只要出现* 就应该符合 
																						
			else
				return matchCore(content, contentIndex, pattern, patternIndex + 2);// * 可以表示0位，而模式和内容不同的情况 。直接跳过 当前位和*

		}

		if (contentIndex <= content.length - 1
				&& (content[contentIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) // 字符相同或存在 .
			return matchCore(content, contentIndex + 1, pattern, patternIndex + 1);

		return false;
	}

	static void Test(String testName, String string, String pattern, boolean expected) {
		if (testName != null)
			System.out.println("%s begins: " + testName);

		if (isMath(string, pattern) == expected)
			System.out.println("Passed.\n");
		else
			System.err.println("FAILED.\n");
	}

	public static void main(String[] args) {

		Test("Test01", "", "", true);
		Test("Test02", "", ".*", true);
		Test("Test03", "", ".", false);
		Test("Test04", "", "c*", true);
		Test("Test05", "a", ".*", true);
		Test("Test06", "a", "a.", false);
		Test("Test07", "a", "", false);
		Test("Test08", "a", ".", true);
		Test("Test09", "a", "ab*", true);
		Test("Test10", "a", "ab*a", false);
		Test("Test11", "aa", "aa", true);
		Test("Test12", "aa", "a*", true);
		Test("Test13", "aa", ".*", true);
		Test("Test14", "aa", ".", false);
		Test("Test15", "ab", ".*", true);
		Test("Test16", "ab", ".*", true);
		Test("Test17", "aaa", "aa*", true);
		Test("Test18", "aaa", "aa.a", false);
		Test("Test19", "aaa", "a.a", true);
		Test("Test20", "aaa", ".a", false);
		Test("Test21", "aaa", "a*a", true);
		Test("Test22", "aaa", "ab*a", false);
		Test("Test23", "aaa", "ab*ac*a", true);
		Test("Test24", "aaa", "ab*a*c*a", true);
		Test("Test25", "aaa", ".*", true);
		Test("Test26", "aab", "c*a*b", true);
		Test("Test27", "aaca", "ab*a*c*a", true);
		Test("Test28", "aaba", "ab*a*c*a", false);
		Test("Test29", "bbbba", ".*a*a", true);
		Test("Test30", "bcbbabab", ".*a*a", false);
	}
}
