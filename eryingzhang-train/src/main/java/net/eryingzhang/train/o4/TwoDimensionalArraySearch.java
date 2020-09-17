package net.eryingzhang.train.o4;

public class TwoDimensionalArraySearch {

	/* 
	 * 从左下角入手找到 剔除小于目标值的行，在可能行中检索
	 */
	/**从 上到下，从左到右递增
	 *  二维矩阵 查找目标值 
	 *  
	 * @param arr
	 * @param value
	 * @return
	 */
	static boolean search(int[][] arr, int value) {
		if (arr == null || arr.length == 0 || arr[0].length == 0)
			return false;

		int xLength = arr[0].length;
		int yLength = arr.length;
		int x = 0;
		int y = yLength - 1;
		while (x < xLength && y >= 0) {

			if (arr[y][x] == value)
				return true;
			else if (arr[y][x] > value)
				y--;
			else
				x++;
		}

		return false;

	}

	public static void main(String[] args) {
		System.out.println(
				search(new int[][] { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } }, 13));
	}
}
