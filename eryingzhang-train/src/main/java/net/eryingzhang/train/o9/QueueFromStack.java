package net.eryingzhang.train.o9;

import java.util.Stack;

public class QueueFromStack {

	static void appendTail(int v) {	
			qTail.push(v);
	}

	static int deleteHead(){
		if(qHead.isEmpty()) {
			if(qTail.isEmpty())
				throw new RuntimeException("queue is null");
			while(!qTail.isEmpty()) {
				qHead.push(qTail.pop());
			}
		}
		
		return qHead.pop();
	}

	private static Stack<Integer> qHead = new Stack<Integer>();
	private static Stack<Integer> qTail = new Stack<Integer>();
	
	public static void main(String[] args) {
		appendTail(1);
		appendTail(2);
		appendTail(3);
		System.out.println(deleteHead());
		System.out.println(deleteHead());
		System.out.println(deleteHead());
		appendTail(4);
		System.out.println(deleteHead());
		System.out.println(deleteHead());
	}
	
}
