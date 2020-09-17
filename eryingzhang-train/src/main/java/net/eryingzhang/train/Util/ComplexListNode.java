package net.eryingzhang.train.Util;

public class ComplexListNode {
	public int value;
	public ComplexListNode next;
	public ComplexListNode sibling;

	public static ComplexListNode CreateNode(int nValue) {
		ComplexListNode pNode = new ComplexListNode();

		pNode.value = nValue;
		pNode.next = null;
		pNode.sibling = null;
		return pNode;
	}

	public static void BuildNodes(ComplexListNode pNode, ComplexListNode pNext, ComplexListNode pSibling) {
		if (pNode != null) {
			pNode.next = pNext;
			pNode.sibling = pSibling;
		}
	}

	public static void PrintList(ComplexListNode pHead) {
		ComplexListNode pNode = pHead;
		StringBuffer sb = new StringBuffer();
		while (pNode != null) {
			sb.append(" " + pNode.value);

			if (pNode.sibling != null)
				sb.append(" sibling is " + pNode.sibling.value);
			else
				sb.append("sibling null");
			pNode = pNode.next;
		}
		System.out.println(sb.toString());
	}
}
