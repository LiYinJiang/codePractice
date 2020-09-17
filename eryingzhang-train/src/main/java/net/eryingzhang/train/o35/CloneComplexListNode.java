package net.eryingzhang.train.o35;

import net.eryingzhang.train.Util.ComplexListNode;

/**
 * 复制复杂链表，链表中节点有一个指针会指向链表中的元素或者为空 数据为链表，先将链表完成复制，再对子节点内容进行赋值
 * 
 * @author Yinjiang.Li
 *
 */
public class CloneComplexListNode {

	static ComplexListNode clone(ComplexListNode head) {
		if (head == null)
			throw new IllegalArgumentException("novalid parameters");

		cloneNodes(head);
		connectionSiling(head);

		return reConnectionNode(head);
	}

	/**
	 * 
	 * @param head
	 *            A-->B-->C A-->A`-->B-->B`-->C-->`C
	 */
	static void cloneNodes(ComplexListNode head) {
		ComplexListNode node = head;
		while (node != null) {
			ComplexListNode temp = new ComplexListNode();
			temp.next = node.next;
			temp.value = node.value;
			temp.sibling = null;
			node.next = temp; // link
			node = temp.next;
		}

	}

	/**
	 * 
	 * @param head
	 */
	static void connectionSiling(ComplexListNode head) {
		if (head == null)
			throw new IllegalArgumentException("novalid parameters");

		ComplexListNode node = head;
		while (node != null) {
			ComplexListNode cloneNode = node.next;
			if (node.sibling != null) {
				cloneNode.sibling = node.sibling.next;
			}
			node = cloneNode.next;
		}

	}

	static ComplexListNode reConnectionNode(ComplexListNode head) {
		if (head == null)
			throw new IllegalArgumentException("novalid parameters");

		ComplexListNode originNode = head;
		ComplexListNode cloneHead = originNode.next;
		ComplexListNode cloneNode = cloneHead;
		originNode = cloneNode.next;

		while (originNode != null) {
			cloneNode.next = originNode.next;
			cloneNode = cloneNode.next;

			originNode.next = cloneNode.next;
			originNode = originNode.next;
		}
		return cloneHead;
	}

	// ====================测试代码====================
	static void Test(String testName, ComplexListNode pHead) {
		if (testName != null)
			System.out.println(String.format("%s begins:\n", testName));

		System.out.println("The original list is:");
		ComplexListNode.PrintList(pHead);

		ComplexListNode pClonedHead = clone(pHead);

		System.out.println("The cloned list is:");
		ComplexListNode.PrintList(pClonedHead);
	}

	/**
	 * <pre>
	-----------------
	\|/              |
	1-------2-------3-------4-------5
	|       |      /|\             /|\
	--------+--------               |
	 -------------------------
	 * </pre>
	 */
	static void Test1() {
		ComplexListNode pNode1 = ComplexListNode.CreateNode(1);
		ComplexListNode pNode2 = ComplexListNode.CreateNode(2);
		ComplexListNode pNode3 = ComplexListNode.CreateNode(3);
		ComplexListNode pNode4 = ComplexListNode.CreateNode(4);
		ComplexListNode pNode5 = ComplexListNode.CreateNode(5);

		ComplexListNode.BuildNodes(pNode1, pNode2, pNode3);
		ComplexListNode.BuildNodes(pNode2, pNode3, pNode5);
		ComplexListNode.BuildNodes(pNode3, pNode4, null);
		ComplexListNode.BuildNodes(pNode4, pNode5, pNode2);

		Test("Test1", pNode1);
	}

	/**
	 * <pre>
	m_pSibling指向结点自身
	  -----------------
	 \|/              |
	1-------2-------3-------4-------5
	 |       | /|\           /|\
	 |       | --             |
	 |------------------------|
	 * </pre>
	 */
	static void Test2() {
		ComplexListNode pNode1 = ComplexListNode.CreateNode(1);
		ComplexListNode pNode2 = ComplexListNode.CreateNode(2);
		ComplexListNode pNode3 = ComplexListNode.CreateNode(3);
		ComplexListNode pNode4 = ComplexListNode.CreateNode(4);
		ComplexListNode pNode5 = ComplexListNode.CreateNode(5);

		ComplexListNode.BuildNodes(pNode1, pNode2, null);
		ComplexListNode.BuildNodes(pNode2, pNode3, pNode5);
		ComplexListNode.BuildNodes(pNode3, pNode4, pNode3);
		ComplexListNode.BuildNodes(pNode4, pNode5, pNode2);

		Test("Test2", pNode1);
	}

	/**
	 * <pre>
	m_pSibling形成环
	 -----------------
	\|/              |
	1-------2-------3-------4-------5
	 |              /|\
	 |               |
	 |---------------|
	 * </pre>
	 */
	static void Test3() {
		ComplexListNode pNode1 = ComplexListNode.CreateNode(1);
		ComplexListNode pNode2 = ComplexListNode.CreateNode(2);
		ComplexListNode pNode3 = ComplexListNode.CreateNode(3);
		ComplexListNode pNode4 = ComplexListNode.CreateNode(4);
		ComplexListNode pNode5 = ComplexListNode.CreateNode(5);

		ComplexListNode.BuildNodes(pNode1, pNode2, null);
		ComplexListNode.BuildNodes(pNode2, pNode3, pNode4);
		ComplexListNode.BuildNodes(pNode3, pNode4, null);
		ComplexListNode.BuildNodes(pNode4, pNode5, pNode2);

		Test("Test3", pNode1);
	}

	// 只有一个结点
	static void Test4() {
		ComplexListNode pNode1 = ComplexListNode.CreateNode(1);
		ComplexListNode.BuildNodes(pNode1, null, pNode1);

		Test("Test4", pNode1);
	}

	// 鲁棒性测试
	static void Test5() {
		Test("Test5", null);
	}

	public static void main(String[] args) {

		Test1();
		Test2();
		Test3();
		Test4();
		Test5();

	}
}
