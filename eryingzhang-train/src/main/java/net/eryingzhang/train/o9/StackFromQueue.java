package net.eryingzhang.train.o9;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class StackFromQueue {

	static Queue<Integer> s1 = new LinkedBlockingQueue<Integer>();
	static Queue<Integer> s2 = new LinkedBlockingQueue<Integer>();

	static void push(int v) {

		if (s1.isEmpty()) {
			s2.add(v);
		} else {
			s1.add(v);
		}
	}

	static int pop() {

		int result = -1;

		Queue<Integer> store = null;
		Queue<Integer> head = null;

		if (s1.isEmpty()) {
			store = s1;
			head = s2;
		} else if (s2.isEmpty()) {
			store = s2;
			head = s1;
		} else if (s2.isEmpty() && s1.isEmpty()) {
			throw new RuntimeException("exist not empty Queue");
		}
		while (head.size() > 1) {
			store.add(head.poll());
		}
		result = head.poll();

		return result;
	}

	public static void main(String[] args) {
		push(1);
		push(2);
		push(3);
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		push(4);
		System.out.println(pop());
		System.out.println(pop());
	}

}
