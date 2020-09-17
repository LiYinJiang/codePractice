package net.eryingzhang.train.o36;

import net.eryingzhang.train.Util.BinaryTreeNode;
import net.eryingzhang.train.Util.TreeUtil;

/**
 * 二叉排序树 转为 排序的双向链表 通过例子脑补, 二叉排序树做中序遍历即得到节点顺序 就为 排序的结果 通过递归来 tree link / \ left
 * right front <---> post
 * 
 * @author Yinjiang.Li
 *
 */
public class BinarySortTreeToLinkList {

	static void binarySortTreeToLinkList(BinaryTreeNode root) {
		if (root == null)
			throw new IllegalArgumentException("novalid parameters");
		BinaryTreeNode tail = toLink(root);

		while (tail.left != null) { // 获得最左值，即头部
			tail = tail.left;
		}
		printLink(tail);
	}

	/**
	 * 不通过成员变量，而是返回尾部指针
	 * 
	 * <pre>
	 *			2  
	 *  	1		3   -->   1->2->3
	 * </pre>
	 * 
	 * @param root
	 * @return link tail
	 */
	static BinaryTreeNode toLink(BinaryTreeNode root) {
		BinaryTreeNode tail = null;
		if (root == null)
			return tail;// 根不为空。

		tail = root;
		if (root.left != null) {
			BinaryTreeNode front = toLink(root.left);
			if (front != null) {
				root.left = front;
				front.right = root;
			}
		}

		if (root.right != null) {
			BinaryTreeNode post = toLink(root.right);
			if (post != null) {
				while (post.left != null) {
					post = post.left;
				} // get postHead
				root.right = post;
				post.left = root;
				tail = root.right;
			}
		}

		return tail;
	}

	/**
	 * 通过一个成员变量
	 * 
	 * @param root
	 */
	private static BinaryTreeNode LinkTail = null;

	static void convertNode(BinaryTreeNode root) {
		if (root == null)
			return;
		BinaryTreeNode current = root;

		if (current.left != null)
			convertNode(current.left); 

		current.left = LinkTail; 
		if (LinkTail != null)
			LinkTail.right = current;
		LinkTail = current; 
		if (current.right != null)
			convertNode(current.right);

	}

	static BinaryTreeNode convert(BinaryTreeNode root) {
		convertNode(root);
		BinaryTreeNode head = LinkTail;
		while (head != null && head.left != null) {
			head = head.left;
		}
		return head;
	}

	static void printLink(BinaryTreeNode head) {
		StringBuffer sb = new StringBuffer();
		while (head != null) {
			sb.append(" " + head.value);
			head = head.right;
		}
		System.out.println(sb.toString());
	}

	static void Test(String testName, BinaryTreeNode pRootOfTree) {
		if (testName != null)
			System.out.println(String.format("%s begins:\n", testName));

		TreeUtil.PrintTree(pRootOfTree);

		// BinaryTreeNode pHeadOfList = Convert(pRootOfTree);
		// binarySortTreeToLinkList(pRootOfTree);

		pRootOfTree = convert(pRootOfTree);
		printLink(pRootOfTree);
	}

	/**
	 * <pre>
	          	10
	         /      \
	        6        14
	       /\        /\
	      4  8     12  16
	 * </pre>
	 */
	static void Test1() {
		BinaryTreeNode pNode10 = TreeUtil.CreateBinaryTreeNode(10);
		BinaryTreeNode pNode6 = TreeUtil.CreateBinaryTreeNode(6);
		BinaryTreeNode pNode14 = TreeUtil.CreateBinaryTreeNode(14);
		BinaryTreeNode pNode4 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNode8 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNode12 = TreeUtil.CreateBinaryTreeNode(12);
		BinaryTreeNode pNode16 = TreeUtil.CreateBinaryTreeNode(16);

		TreeUtil.ConnectTreeNodes(pNode10, pNode6, pNode14);
		TreeUtil.ConnectTreeNodes(pNode6, pNode4, pNode8);
		TreeUtil.ConnectTreeNodes(pNode14, pNode12, pNode16);

		Test("Test1", pNode10);

	}

	/**
	 * <pre>
	 * 5 / 4 / 3 / 2 / 1
	 * </pre>
	 */
	static void Test2() {
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode4 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNode3 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNode2 = TreeUtil.CreateBinaryTreeNode(2);
		BinaryTreeNode pNode1 = TreeUtil.CreateBinaryTreeNode(1);

		TreeUtil.ConnectTreeNodes(pNode5, pNode4, null);
		TreeUtil.ConnectTreeNodes(pNode4, pNode3, null);
		TreeUtil.ConnectTreeNodes(pNode3, pNode2, null);
		TreeUtil.ConnectTreeNodes(pNode2, pNode1, null);

		Test("Test2", pNode5);

	}

	/**
	 * <pre>
	 1
	  \
	   2
	    \
	     3
	      \
	       4
	        \
	         5
	 * </pre>
	 */
	static void Test3() {
		BinaryTreeNode pNode1 = TreeUtil.CreateBinaryTreeNode(1);
		BinaryTreeNode pNode2 = TreeUtil.CreateBinaryTreeNode(2);
		BinaryTreeNode pNode3 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNode4 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);

		TreeUtil.ConnectTreeNodes(pNode1, null, pNode2);
		TreeUtil.ConnectTreeNodes(pNode2, null, pNode3);
		TreeUtil.ConnectTreeNodes(pNode3, null, pNode4);
		TreeUtil.ConnectTreeNodes(pNode4, null, pNode5);

		Test("Test3", pNode1);

	}

	// 树中只有1个结点
	static void Test4() {
		BinaryTreeNode pNode1 = TreeUtil.CreateBinaryTreeNode(1);
		Test("Test4", pNode1);

	}

	// 树中没有结点
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
