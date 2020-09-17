package net.eryingzhang.train.o24;

/**
 * 对链表做出反转，并返回反转后的链表头节点 即原来的尾节点
 * 
 * @author Yinjiang.Li
 *
 */
public class ReverseLink {

	static Node reverseLink(Node head) {
		try {
			if (head == null)
				throw new IllegalArgumentException("novalid parameters");
		} catch (Exception e) {
			System.err.println("检查输入参数");
			e.printStackTrace();
		}
		Node previous = null;
		Node current = head;
		Node reverseHead = null;
		while (current != null) {
			Node next = current.next; // 先保存下一个节点
			if (next == null) // 如果下一个节点为空则当前节点就是反转后的尾部节点
				reverseHead = current;

			current.next = previous; // 由 previous->current 转为 previous<-- current
			previous = current;
			current = next; // 将断开的链表 链接回来

		}

		return reverseHead;
	}

	static Node reverseLinkByRecursion(Node head) {
		try {
			if (head == null)
				throw new IllegalArgumentException("novalid parameters");
		} catch (Exception e) {
			System.err.println("检查输入参数");
			e.printStackTrace();
		}

		return reverseLinkRecursion(head, null);
	}

	static Node reverseLinkRecursion(Node current, Node previous) {
		if (current == null) // 当前值为空，则上一个节点就是尾节点
			return previous;

		Node next = current.next;
		current.next = previous; // 反转方向

		return reverseLinkRecursion(next, current);
	}

	static void PrintList(Node head) {
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

	static Node CreateListNode(int value) {
		return new Node(value);
	}

	static void ConnectListNodes(Node n1, Node n2) {
		n1.next = n2;
	}

	// ====================测试代码====================
	static Node Test(Node pHead) {
		System.out.println("The original list is: \n");
		PrintList(pHead);

		Node pReversedHead = reverseLinkByRecursion(pHead);

		System.out.println("The reversed list is: \n");
		PrintList(pReversedHead);

		return pReversedHead;
	}

	// 输入的链表有多个结点
	static void Test1() {
		Node pNode1 = CreateListNode(1);
		Node pNode2 = CreateListNode(2);
		Node pNode3 = CreateListNode(3);
		Node pNode4 = CreateListNode(4);
		Node pNode5 = CreateListNode(5);

		ConnectListNodes(pNode1, pNode2);
		ConnectListNodes(pNode2, pNode3);
		ConnectListNodes(pNode3, pNode4);
		ConnectListNodes(pNode4, pNode5);

		Node pReversedHead = Test(pNode1);

	}

	// 输入的链表只有一个结点
	static void Test2() {
		Node pNode1 = CreateListNode(1);

		Node pReversedHead = Test(pNode1);

	}

	// 输入空链表
	static void Test3() {
		Test(null);
	}

	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
	}

}
