package net.eryingzhang.train.o25;

/**
 * <pre>
 *  两个有序链表的合并，
 *  从链表头判断大小然后取出大节点，作为头部， 这一过程可以持续进行。直到其中一个节点为空。 
 *  那就可以通过递归做出实现
 * </pre>
 * 
 * @author Yinjiang.Li
 *
 */
public class MergeSortLink {

	static Node merge(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		Node mergeHead = null;
		if (head1.value < head2.value) {
			mergeHead = head1;
			mergeHead.next = merge(head1.next, head2);
		} else {
			mergeHead = head2;
			mergeHead.next = merge(head1, head2.next);
		}
		return mergeHead;
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

	static Node Test(String testName, Node pHead1, Node pHead2) {
		if (testName != null)
			System.out.println("%s begins:" + testName);

		System.out.println("The first list is:");
		PrintList(pHead1);

		System.out.println("The second list is:");
		PrintList(pHead2);

		System.out.println("The merged list is:");
		Node pMergedHead = merge(pHead1, pHead2);
		PrintList(pMergedHead);

		System.out.println("");

		return pMergedHead;
	}

	// list1: 1->3->5
	// list2: 2->4->6
	static void Test1() {
		Node pNode1 = CreateListNode(1);
		Node pNode3 = CreateListNode(3);
		Node pNode5 = CreateListNode(5);

		ConnectListNodes(pNode1, pNode3);
		ConnectListNodes(pNode3, pNode5);

		Node pNode2 = CreateListNode(2);
		Node pNode4 = CreateListNode(4);
		Node pNode6 = CreateListNode(6);

		ConnectListNodes(pNode2, pNode4);
		ConnectListNodes(pNode4, pNode6);

		Node pMergedHead = Test("Test1", pNode1, pNode2);

	}

	// 两个链表中有重复的数字
	// list1: 1->3->5
	// list2: 1->3->5
	static void Test2() {
		Node pNode1 = CreateListNode(1);
		Node pNode3 = CreateListNode(3);
		Node pNode5 = CreateListNode(5);

		ConnectListNodes(pNode1, pNode3);
		ConnectListNodes(pNode3, pNode5);

		Node pNode2 = CreateListNode(1);
		Node pNode4 = CreateListNode(3);
		Node pNode6 = CreateListNode(5);

		ConnectListNodes(pNode2, pNode4);
		ConnectListNodes(pNode4, pNode6);

		Node pMergedHead = Test("Test2", pNode1, pNode2);

	}

	// 两个链表都只有一个数字
	// list1: 1
	// list2: 2
	static void Test3() {
		Node pNode1 = CreateListNode(1);
		Node pNode2 = CreateListNode(2);

		Node pMergedHead = Test("Test3", pNode1, pNode2);

	}

	// 一个链表为空链表
	// list1: 1->3->5
	// list2: 空链表
	static void Test4() {
		Node pNode1 = CreateListNode(1);
		Node pNode3 = CreateListNode(3);
		Node pNode5 = CreateListNode(5);

		ConnectListNodes(pNode1, pNode3);
		ConnectListNodes(pNode3, pNode5);

		Node pMergedHead = Test("Test4", pNode1, null);

	}

	// 两个链表都为空链表
	// list1: 空链表
	// list2: 空链表
	static void Test5() {
		Node pMergedHead = Test("Test5", null, null);
	}

	public static void main(String[] args) {

		Test1();
		Test2();
		Test3();
		Test4();
		Test5();

	}

}
