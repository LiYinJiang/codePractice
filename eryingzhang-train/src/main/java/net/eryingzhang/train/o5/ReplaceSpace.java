package net.eryingzhang.train.o5;

public class ReplaceSpace {
	
	/*
	 * 对数组内容的判断， 替换长度不同的内容并返回 新的数组
	 * */
	static char[] replaceSpace(char[] arr) {
		if (arr == null || arr.length == 0)
			return arr;

		int spaceCount = 0;
		for (char c : arr) {
			if (c == ' ')
				spaceCount++;
		}
		if(spaceCount == 0)
			return arr;
		
		char[] temp = new char[arr.length + spaceCount * 3];
		int front = arr.length - 1;
		int last = temp.length - 1;
		for (int i = arr.length - 1; i >= 0; i--) {

			if (arr[i] == ' ') {
				temp[last--] = '%';
				temp[last--] = '2';
				temp[last--] = '0';
				front--;
			} else {
				temp[last--] = arr[front--];
			}
			if (front == last)
				break;
		}

		return temp;
	}

	public static void main(String[] args) {
		char[] arr = new char[] { 'h', ' ', 'h', ' ', 'h', ' ' };
		arr = replaceSpace(arr);
		StringBuffer sb = new StringBuffer();
		for (char c : arr) {
			sb.append(c);
		}
		System.out.println("result: " + sb.toString());

	}
}
