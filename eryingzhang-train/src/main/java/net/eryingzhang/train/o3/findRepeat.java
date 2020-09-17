package net.eryingzhang.train.o3;

public class findRepeat {

	/*
	 * 查询数组中的重复值， 时间复杂度 O(n) 空间复杂度O(n) 返回 包含重复的数字和出现的次数
	 */
	static int[] find(int[] arr) {
		if (arr.length == 0)
			return arr;

		int[] temp = new int[arr.length];
		int max = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				System.err.println("输入数组值超出约束");
				return arr;
			}
			temp[arr[i]] = temp[arr[i]] + 1;
		}

		System.out.println("repeat: ");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] > 1)
				sb.append(i + " ");
		}
		System.out.println(sb.toString());
		return temp;
	}

	/*
	 * 查询数组中的重复值， 时间复杂度 O(n) 空间复杂度O(1) 返回 第一个重复的数字
	 */
	/**
	 *  二分法 
	 *  在 起始索引还未大于等于 结尾索引始终执行
	 *  根据q
	 * @param arr
	 * @return
	 */
	static int binarySearch(int[] arr) {
		int start = 1;
		int end = arr.length - 1;
		while (end >= start) {
			int middle = (end - start) / 2 + start;
			int count = findCount(arr, start, middle);
			if (end == start) {
				if (count > 1) {
					return start;
				} else
					break;

			}

			if (count > middle - start) {
				end = middle;
			} else {
				start = middle + 1;
			}

		}
		return -1;
	}

	static int findCount(int[] arr, int start, int end) {
		int count = 0;
		if (arr == null || arr.length == 0)
			return count;
		if (start < 0 || end > arr.length - 1)
			return count;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= start && arr[i] <= end)
				count++;
		}
		return count;

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 4, 2, 5, 6, 4, 5,1,1 };
		System.out.println(binarySearch(arr));
	}
}
