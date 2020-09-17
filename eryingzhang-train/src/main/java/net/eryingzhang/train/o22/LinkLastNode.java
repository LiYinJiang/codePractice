package net.eryingzhang.train.o22;

import java.util.Stack;

/**
 * 返回链表中倒数第 m 个元素 1-2-3-4-5-6 m = 3 return 4
 * 
 * 巧用栈数据结构，或者用两个指针，一个作为遍历在前，另一个相隔 m 个单位，当访问到尾部时，相隔m的指针就返回数据
 * 而对于中链表中间数，当链表长度为偶数或奇数返回中间位置的节点时，就只能通过指针来实现。根据步频不同来获得中间值。
 * @author Yinjiang.Li
 */
public class LinkLastNode {

	/**
	 * 空间复杂度O(1) 时间复杂度 0(n)
	 * @param head
	 * @param lastIndex
	 *            链表尾部计数 为 1
	 * @return
	 */
	public static Node FindKthToTail(Node head, int m) {

		try {
			if (head == null || head.next == null || m <= 0)
				throw new IllegalArgumentException("novalid parameters");
		} catch (Exception e) {
			System.err.println("检查输入参数");
			e.printStackTrace();
		}
		// 根据m 数量获取尾节点
		Node tail = head.next;
		for (int i = 1; i < m; i++) {
			if (tail.next == null)
				System.err.println("链表中不存在倒数第m个节点。");
			tail = tail.next;
		}

		Node mNode = head;
		while (tail != null) {
			mNode = mNode.next;
			tail = tail.next;
		}

		return mNode;
	}

	/**
	 * 空间复杂度O(n) 时间复杂度 0(n)
	 * @param head
	 * @param m
	 * @return
	 */
	public static Node FindKthToTailByStack(Node head, int m) {
		try {
			if (head == null || head.next == null || m <= 0)
				throw new IllegalArgumentException("novalid parameters");
		} catch (Exception e) {
			System.err.println("检查输入参数");
			e.printStackTrace();
		}

		Stack<Node> stack = new Stack<Node>();
		while (head != null) {
			stack.push(head);
			head = head.next;
		}
		if (stack.size() < m)
			System.err.println("链表中不存在倒数第m个节点。");
		Node mNode = null;
		for (int i = m; i > 1; i--) {
			stack.pop();
		}
		mNode = stack.pop();
		return mNode;
	}

	static Node CreateListNode(int value) {
		return new Node(value);
	}

	static void ConnectListNodes(Node n1, Node n2) {
		n1.next = n2;
	}

	static void PrintListNode(Node head) {
		StringBuffer sb = new StringBuffer();
		if (head == null)
			return;
		sb.append(head.value);
		while (head.next != null) {
			sb.append(head.next.value);
			head = head.next;
		}

		System.out.println(sb.toString());
	}

	static void Test1() {
		System.out.println("=====Test1 starts:=====");
		Node pNode1 = CreateListNode(1);
		Node pNode2 = CreateListNode(2);
		Node pNode3 = CreateListNode(3);
		Node pNode4 = CreateListNode(4);
		Node pNode5 = CreateListNode(5);

		ConnectListNodes(pNode1, pNode2);
		ConnectListNodes(pNode2, pNode3);
		ConnectListNodes(pNode3, pNode4);
		ConnectListNodes(pNode4, pNode5);

		Node pNode = FindKthToTailByStack(pNode1, 2);
		System.out.println("m=2 expected result: 4.");
		PrintListNode(pNode);

	}

	// 测试要找的结点是链表的尾结点
	static void Test2() {
		System.out.println("=====Test2 starts:=====");
		Node pNode1 = CreateListNode(1);
		Node pNode2 = CreateListNode(2);
		Node pNode3 = CreateListNode(3);
		Node pNode4 = CreateListNode(4);
		Node pNode5 = CreateListNode(5);

		ConnectListNodes(pNode1, pNode2);
		ConnectListNodes(pNode2, pNode3);
		ConnectListNodes(pNode3, pNode4);
		ConnectListNodes(pNode4, pNode5);

		Node pNode = FindKthToTailByStack(pNode1, 1);
		System.out.println("m =1 expected result: 5.");
		PrintListNode(pNode);

	}

	// 测试要找的结点是链表的头结点
	static void Test3() {
		System.out.println("=====Test3 starts:=====");
		Node pNode1 = CreateListNode(1);
		Node pNode2 = CreateListNode(2);
		Node pNode3 = CreateListNode(3);
		Node pNode4 = CreateListNode(4);
		Node pNode5 = CreateListNode(5);

		ConnectListNodes(pNode1, pNode2);
		ConnectListNodes(pNode2, pNode3);
		ConnectListNodes(pNode3, pNode4);
		ConnectListNodes(pNode4, pNode5);

		Node pNode = FindKthToTailByStack(pNode1, 5);
		System.out.println("m= 5 expected result: 1.");
		PrintListNode(pNode);

	}

	// 测试空链表
	static void Test4() {
		System.out.println("=====Test4 starts:=====");
		System.out.println("expected result: nullptr.");
		Node pNode = FindKthToTailByStack(null, 100);
		PrintListNode(pNode);
	}

	// 测试输入的第二个参数大于链表的结点总数
	static void Test5() {
		System.out.println("=====Test5 starts:=====");
		Node pNode1 = CreateListNode(1);
		Node pNode2 = CreateListNode(2);
		Node pNode3 = CreateListNode(3);
		Node pNode4 = CreateListNode(4);
		Node pNode5 = CreateListNode(5);

		ConnectListNodes(pNode1, pNode2);
		ConnectListNodes(pNode2, pNode3);
		ConnectListNodes(pNode3, pNode4);
		ConnectListNodes(pNode4, pNode5);

		System.out.println("expected result: nullptr.");
		Node pNode = FindKthToTailByStack(pNode1, 6);
		PrintListNode(pNode);

	}

	// 测试输入的第二个参数为0
	static void Test6() {
		System.out.println("=====Test6 starts:=====");
		Node pNode1 = CreateListNode(1);
		Node pNode2 = CreateListNode(2);
		Node pNode3 = CreateListNode(3);
		Node pNode4 = CreateListNode(4);
		Node pNode5 = CreateListNode(5);

		ConnectListNodes(pNode1, pNode2);
		ConnectListNodes(pNode2, pNode3);
		ConnectListNodes(pNode3, pNode4);
		ConnectListNodes(pNode4, pNode5);

		System.out.println("expected result: nullptr.");
		Node pNode = FindKthToTailByStack(pNode1, 0);
		PrintListNode(pNode);

	}

	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
		Test6();
	}
}
