package net.eryingzhang.train.o18;

/**
 * 单向链表， 删除链表中节点。且时间复杂度为 O(1)
 * 
 * @author Yinjiang.Li
 *
 */
public class DeleteNode {

	/**
	 * 
	 * 常规需要从头遍历然后删除 花费O(n) 而直接用下一个节点数据覆盖到当前节点， 当前节点再指向下一个节点即可 链表中的特殊位置需要考虑。 若被删除节点是
	 * 尾节点和头节点的情况， 为避免出现野指针的情况。需要做遍历处理 该函数默认 被删除函数一定存在该链表中，若不能保证，则该函数就不够准确。
	 * 
	 * @param head
	 * @param deleteNode
	 */
	static void deleteNode(Node head, Node deleteNode) {
		if (head == null || deleteNode == null)
			throw new IllegalArgumentException("novalid parameters");

		if (deleteNode.next != null) { // 中间节点
			Node next = deleteNode.next;
			deleteNode.next = next.next;
			deleteNode.value = next.value;
			next.next = null;
			next.value = null;
		} else { // 尾节点和 头节点

			Node previous = null;
			while (head.next != null) {
				previous = head;
				head = head.next;
			}
			if (previous != null)
				previous.next = null;
			deleteNode.value = null;
			deleteNode.next = null;
		}

	}

	static void deleteMultiNode(Node head) {
		if (head == null)
			throw new IllegalArgumentException("novalid parameters");
		Node next = head;
		while (next.next != null) {
			if (next.value == next.next.value) {
				next.next.value = null;
				next.next = next.next.next;
			} else
				next = next.next;
		}
		PrintList(head);
	}

	static Node CreateListNode(int value) {
		return new Node(value);
	}

	static void ConnectListNodes(Node previous, Node next) {
		if (previous == null || next == null)
			throw new IllegalArgumentException("novalid parameters");
		previous.next = next;
	}

	// ====================测试代码====================
	static void Test(Node pListHead, Node pNode) {
		System.out.println("The original list is: ");
		PrintList(pListHead);

		System.out.println("The node to be deleted is: ");
		System.out.println(pNode.value);

		deleteNode(pListHead, pNode);

		System.out.println("The result list is: ");
		PrintList(pListHead);
	}

	static void PrintList(Node head) {
		StringBuffer sb = new StringBuffer();
		if (head == null)
			throw new IllegalArgumentException("novalid parameters");
		while (head.next != null) {
			sb.append(head.value + " ");
			head = head.next;
		}
		if (head.value != null)
			sb.append(head.value + " ");
		System.out.println(sb.toString());
	}

	// 链表中有多个结点，删除中间的结点
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

		Test(pNode1, pNode3);

	}

	// 链表中有多个结点，删除尾结点
	static void Test2() {
		Node pNode1 = CreateListNode(1);
		Node pNode2 = CreateListNode(2);
		Node pNode3 = CreateListNode(3);
		Node pNode4 = CreateListNode(4);
		Node pNode5 = CreateListNode(5);

		ConnectListNodes(pNode1, pNode2);
		ConnectListNodes(pNode2, pNode3);
		ConnectListNodes(pNode3, pNode4);
		ConnectListNodes(pNode4, pNode5);

		Test(pNode1, pNode5);

	}

	// 链表中有多个结点，删除头结点
	static void Test3() {
		Node pNode1 = CreateListNode(1);
		Node pNode2 = CreateListNode(2);
		Node pNode3 = CreateListNode(3);
		Node pNode4 = CreateListNode(4);
		Node pNode5 = CreateListNode(5);

		ConnectListNodes(pNode1, pNode2);
		ConnectListNodes(pNode2, pNode3);
		ConnectListNodes(pNode3, pNode4);
		ConnectListNodes(pNode4, pNode5);

		Test(pNode1, pNode1);

	}

	// 链表中只有一个结点，删除头结点
	static void Test4() {
		Node pNode1 = CreateListNode(1);

		Test(pNode1, pNode1);
	}

	// 链表为空
	static void Test5() {
		Test(null, null);
	}

	static void Test6() {
		Node pNode1 = CreateListNode(1);
		Node pNode2 = CreateListNode(1);
		Node pNode3 = CreateListNode(1);
		Node pNode4 = CreateListNode(1);
		Node pNode5 = CreateListNode(2);

		ConnectListNodes(pNode1, pNode2);
		ConnectListNodes(pNode2, pNode3);
		ConnectListNodes(pNode3, pNode4);
		ConnectListNodes(pNode4, pNode5);
		deleteMultiNode(pNode1);
	}

	public static void main(String[] args) {
		// Test1();
		// Test2();
		// Test3();
		// Test4();
		// Test5();
		Test6();
	}
}
