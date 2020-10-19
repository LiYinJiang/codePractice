package net.eryingzhang.train.o38;

import net.eryingzhang.train.Util.Util;

/**
 * 国际象棋 8 * 8 棋盘中， 放置八皇后，不能见面，即同一行列上只能有一个。且不能对角放置 转化为 八个不同字符排列的情形，
 * 
 * @author Yinjiang.Li
 *
 */
public class EightQueueArrayment {

	static void printEightQueueArrayment(int length) {
		if (length < 1)
			throw new IllegalArgumentException("novalid parameters");
		Integer[] eightQueue = new Integer[length];
		for (int i = 0; i < eightQueue.length; i++) {
			eightQueue[i] = i;
		} // init 但该排列中存在对角的情况
		printEightQueueArrayment(eightQueue, 0);

	}

	/**
	 * 先满足八皇后都在不同行(列)，再调换列(行)位置。 调换中需要 利用递归实现全排列，在排列中只要出现了对角的情况则该递归直接返回
	 * 
	 * @param eightQueue
	 * @param startIndex
	 */
	static void printEightQueueArrayment(Integer[] eightQueue, int startIndex) {
		if (startIndex == eightQueue.length - 1) { 
			for (int i = 0; i < eightQueue.length; i++) {

				for (int j = i + 1; j < eightQueue.length; j++) {
					if (i - j == eightQueue[i] - eightQueue[j] || i - j == eightQueue[j] - eightQueue[i]) {
						return;
					}
				}
			}
			Util.print(eightQueue);
		} else {
			for (int i = startIndex + 1; i < eightQueue.length; i++) {
				Util.swap(eightQueue, startIndex, i);
				printEightQueueArrayment(eightQueue, startIndex + 1);
				Util.swap(eightQueue, startIndex, i);
			}

		}

	}

	public static void main(String[] args) {
		printEightQueueArrayment(4);
	}
}
