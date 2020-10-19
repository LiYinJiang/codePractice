package net.eryingzhang.train.o41;

import java.util.PriorityQueue;

/**
 * 從数据流中获取中位数
 * 
 * @author Yinjiang.Li
 *
 */
public class GetMidFromStream {
	// 最大堆
	private PriorityQueue<Integer> left = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);

	// 最小堆
	private PriorityQueue<Integer> right = new PriorityQueue<Integer>();

	// 添加个数
	private int count = 0;

	private void insert(int number) {
		//通过总数来分别插入不同的堆    插入数据时，将数据插入 最大堆时，插入后取出最大堆中最大值放入最小堆 对
		if ((count & 1) == 0) {
			
			
		} else {

			
		}
		count++;

	}

	private double getMid() {
		if ((count & 1) == 0) {
			
		} else {

		}
	}
}
