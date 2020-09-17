package net.eryingzhang.train.o6;

import java.util.Stack;

/*
 * 默认不修改原数据
 * */
public class LinkNode {
	Object value;
	LinkNode next;

	public LinkNode(Object v) {
		value = v;
	}

	static void addToTail(LinkNode node, Object v) {
		if (node == null) {
			node = new LinkNode(v);

			return;
		}

		while (node.next != null) {
			node = node.next;
		}
		LinkNode nextNode = new LinkNode(v);
		node.next = nextNode;
	}

	/*
	 * 通过栈来实现，先进后出
	 */
	static void printNodeFromTail(LinkNode nodeHead) {
		if (nodeHead == null)
			return;

		Stack<LinkNode> stack = new Stack<LinkNode>();
		stack.push(nodeHead);
		while (nodeHead.next != null) {
			stack.push(nodeHead.next);
			nodeHead = nodeHead.next;
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop().value + "-");
		}
	}

	static void printNodeFromTailRecurisively(LinkNode nodeHead) {
		if (nodeHead == null)
			return;

		if (nodeHead.next != null) {
			printNodeFromTailRecurisively(nodeHead.next);

		}
		System.out.println(nodeHead.value + "-");
	}

	public static void main(String[] args) {
		LinkNode listNode = new LinkNode(2);
		LinkNode listNode1 = new LinkNode(3);
		listNode.next = listNode1;
		printNodeFromTail(listNode);

	}
}
