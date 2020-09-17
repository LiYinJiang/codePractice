package net.eryingzhang.train.o29;

public class ClockWisePrintREC {

	static void clockWiseRec(int[][] rec, int recWidth, int recHeight) {
		if (rec == null || recWidth < 0 || recHeight < 0 || rec.length != recHeight || rec[0].length != recWidth) {
			System.err.println("novalid parameters");
			return;
		}
		int start = 0;
		while (recWidth > start * 2 && recHeight > start * 2) {
			clockWisePrintREC(rec, recWidth, recHeight, start);
			start++;
		}
	}

	/**
	 * 
	 * @param rec
	 * @param recWidth
	 * @param recHeight
	 * @param start
	 *            表示开始打印的位置 start= 0 --> (0,0) 1-->(1,1)
	 */
	static void clockWisePrintREC(int[][] rec, int recWidth, int recHeight, int start) {
		StringBuffer sb = new StringBuffer();

		int endX = recWidth - start - 1; // 开环
		int endY = recHeight - start - 1; // 开环
		// 从左到右 start,start--> start,endX
		for (int i = start; i <= endX; i++) {
			sb.append(" " + rec[start][i]);
		}

		// 向下移动 start +1, endX --> endY, endX
		if (start < endY) {
			for (int i = start +1; i <= endY; i++) {
				sb.append(" " + rec[i][endX]);
			}
		} else {
			System.out.println(sb.toString());
			return;
		}

		// 向左移动 endY, endX --> endY,start
		if (start < endX && start < endY) {
			for (int i = endX - 1; i >= start; i--) {
				sb.append(" " + rec[endY][i]);
			}
		} else {
			System.out.println(sb.toString());
			return;
		}

		// 从下到上 Y 轴为闭环。 x为开环 endY,start --> start +1, start
		if (endY - 1 > start && endX > start) {
			for (int i = endY - 1; i > start; i--) {
				sb.append(" " + rec[i][start]);
			}
		} else {
			System.out.println(sb.toString());
			return;
		}
		System.out.println(sb.toString());
	}

	// ====================测试代码====================
	static void Test(int columns, int rows) {
		System.out.println(String.format("Test Begin: %d columns, %d rows.\n", columns, rows));

		if (columns < 1 || rows < 1)
			return;

		int[][] numbers = new int[rows][columns];
		for (int i = 0; i < rows; ++i) {
			numbers[i] = new int[columns];
			for (int j = 0; j < columns; ++j) {
				numbers[i][j] = i * columns + j + 1;
			}
		}

		clockWiseRec(numbers, columns, rows);

	}

	public static void main(String[] args) {
		 /*
	    1    
	    */
	    Test(1, 1);

	    /*
	    1    2
	    3    4
	    */
	    Test(2, 2);

	    /*
	    1    2    3    4
	    5    6    7    8
	    9    10   11   12
	    13   14   15   16
	    */
	    Test(4, 4);

	    /*
	    1    2    3    4    5
	    6    7    8    9    10
	    11   12   13   14   15
	    16   17   18   19   20
	    21   22   23   24   25
	    */
	    Test(5, 5);

	    /*
	    1
	    2
	    3
	    4
	    5
	    */
	    Test(1, 5);

	    /*
	    1    2
	    3    4
	    5    6
	    7    8
	    9    10
	    */
	    Test(2, 5);

	    /*
	    1    2    3
	    4    5    6
	    7    8    9
	    10   11   12
	    13   14   15
	    */
	    Test(3, 5);

	    /*
	    1    2    3    4
	    5    6    7    8
	    9    10   11   12
	    13   14   15   16
	    17   18   19   20
	    */
	    Test(4, 5);

	    /*
	    1    2    3    4    5
	    */
	    Test(5, 1);

	    /*
	    1    2    3    4    5
	    6    7    8    9    10
	    */
	    Test(5, 2);

	    /*
	    1    2    3    4    5
	    6    7    8    9    10
	    11   12   13   14    15
	    */
	    Test(5, 3);

	    /*
	    1    2    3    4    5
	    6    7    8    9    10
	    11   12   13   14   15
	    16   17   18   19   20
	    */
	    Test(5, 4);	
	    }

}
