package net.eryingzhang.train.o23;

/**
 * 寻找一个链表中环的入口节点
 * 
 * @author Yinjiang.Li
 *
 */
public class FindLinkRing {

	/**
	 * 两个指针，快慢步。若快指针遇到了慢指针则有环。若快指针已经到头了则无环
	 * 1、确定是否有环
	 * 2、找出环的长度
	 * 3、根据长度从头节点用两个指针找到环
	 * @param head
	 * @return
	 */
	static Node findLinkRingStart(Node head) {
		try {
			if (head == null)
				throw new IllegalArgumentException("novalid parameters");
		} catch (Exception e) {
			System.err.println("检查输入参数");
			e.printStackTrace();
		}
		// 参数检查，不为空，且有环
		Node fast = head;
		Node slow = head;
		boolean hasRing = false;
		while (slow != null) {
			if (fast.next != null && fast.next.next != null)
				fast = fast.next.next;
			else
				break;
			if (slow.next != null)
				slow = slow.next;
			if (fast == slow) {
				hasRing = true;
				break;
			}
		}
		Node ringStart = null;
		if (!hasRing) {
			System.err.println("The list does not exist ring ");
			return null;
		} else {
			int ringSize = 1;// 有环则至少有一个节点产生自旋

			while (slow.next != fast) {
				slow = slow.next;
				ringSize++;
			}

			Node ringEnd = head;
			for (int i = 0; i < ringSize; i++) {
				ringEnd = ringEnd.next;
			}
			ringStart = head;
			while (ringEnd != ringStart) {
				ringStart = ringStart.next;
				ringEnd = ringEnd.next;
				if (ringStart == ringEnd)
					break;
			}
		}
		return ringStart;
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

	static Node CreateListNode(int value) {
		return new Node(value);
	}

	static void ConnectListNodes(Node n1, Node n2) {
		n1.next = n2;
	}

	static void Test(String testName, Node pHead, Node entryNode) {
		if (testName != null)
			System.out.println("%s begins: " + testName);

		if (findLinkRingStart(pHead) == entryNode)
			System.out.println("Passed.\n");
		else
			System.out.println("FAILED.\n");
	}

	// A list has a node, without a loop
	static void Test1() {
		Node pNode1 = CreateListNode(1);

		Test("Test1", pNode1, null);

	}

	// A list has a node, with a loop
	static void Test2() {
		Node pNode1 = CreateListNode(1);
		ConnectListNodes(pNode1, pNode1);

		Test("Test2", pNode1, pNode1);

	}

	// A list has multiple nodes, with a loop
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
		ConnectListNodes(pNode5, pNode3);

		Test("Test3", pNode1, pNode3);

	}

	// A list has multiple nodes, with a loop
	static void Test4() {
		Node pNode1 = CreateListNode(1);
		Node pNode2 = CreateListNode(2);
		Node pNode3 = CreateListNode(3);
		Node pNode4 = CreateListNode(4);
		Node pNode5 = CreateListNode(5);

		ConnectListNodes(pNode1, pNode2);
		ConnectListNodes(pNode2, pNode3);
		ConnectListNodes(pNode3, pNode4);
		ConnectListNodes(pNode4, pNode5);
		ConnectListNodes(pNode5, pNode1);

		Test("Test4", pNode1, pNode1);
	}

	// A list has multiple nodes, with a loop
	static void Test5() {
		Node pNode1 = CreateListNode(1);
		Node pNode2 = CreateListNode(2);
		Node pNode3 = CreateListNode(3);
		Node pNode4 = CreateListNode(4);
		Node pNode5 = CreateListNode(5);

		ConnectListNodes(pNode1, pNode2);
		ConnectListNodes(pNode2, pNode3);
		ConnectListNodes(pNode3, pNode4);
		ConnectListNodes(pNode4, pNode5);
		ConnectListNodes(pNode5, pNode5);

		Test("Test5", pNode1, pNode5);

	}

	// A list has multiple nodes, without a loop
	static void Test6() {
		Node pNode1 = CreateListNode(1);
		Node pNode2 = CreateListNode(2);
		Node pNode3 = CreateListNode(3);
		Node pNode4 = CreateListNode(4);
		Node pNode5 = CreateListNode(5);

		ConnectListNodes(pNode1, pNode2);
		ConnectListNodes(pNode2, pNode3);
		ConnectListNodes(pNode3, pNode4);
		ConnectListNodes(pNode4, pNode5);

		Test("Test6", pNode1, null);

	}

	// Empty list
	static void Test7() {
		Test("Test7", null, null);
	}

	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
		Test6();
		Test7();
	}
}
