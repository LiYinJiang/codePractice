package net.eryingzhang.train.o12;

public class MatriPath {

	static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if (matrix == null || matrix.length != rows * cols || str == null || str.length == 0)
			throw new IllegalArgumentException("novalid parameters");

		boolean[] visited = new boolean[rows * cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (hasCorePath(matrix, rows, cols, i, j, str, 0, visited))
					return true;
			}
		}

		return false;
	}

	static boolean hasCorePath(char[] matrix, int rows, int cols, int row, int col, char[] str, int strIndex,
			boolean[] visited) {
		// 字符已经匹配完毕
		if (str.length == strIndex)
			return true;
		boolean has = false;
		if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col]
				&& matrix[row * cols + col] == str[strIndex]) {
			visited[row * cols + col] = true;
			strIndex++;

			has = hasCorePath(matrix, rows, cols, row - 1, col, str, strIndex, visited) // up
					|| hasCorePath(matrix, rows, cols, row + 1, col, str, strIndex, visited) // down
					|| hasCorePath(matrix, rows, cols, row, col - 1, str, strIndex, visited) // left
					|| hasCorePath(matrix, rows, cols, row, col + 1, str, strIndex, visited); // right

			// 回溯，如果四个方向都没有则回溯
			if (!has) {
				visited[row * cols + col] = false;
				strIndex--;
			}
		}
		return has;

	}

	public static void main(String[] args) {
		char[] matrix = new char[] { 'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e' };
		char[] str = new char[] { 'b', 'f', 'c', 'e' };
		char[] strFalse = new char[] { 'a', 'b', 'f', 'b' };

		System.out.println(hasPath(matrix, 3, 4, strFalse));
	}
}
