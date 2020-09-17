package net.eryingzhang.train.o32;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

import net.eryingzhang.train.Util.BinaryTreeNode;
import net.eryingzhang.train.Util.TreeUtil;

/**
 * 层级遍历并打印节点 将三层二叉树进行模拟 打印，可知。先存入的节点。先打印。通过队列存储，
 * 
 * @author Yinjiang.Li
 *
 */
public class PrintSequenceTree {

	/**
	 * 按层级打印出树节点
	 * 
	 * @param root
	 */
	static void printSequenceTree(BinaryTreeNode root) {
		if (root == null)
			throw new IllegalArgumentException("novalid parameters");

		Queue<BinaryTreeNode> queue = new LinkedBlockingQueue<BinaryTreeNode>();
		queue.add(root);

		StringBuffer sb = new StringBuffer();
		while (!queue.isEmpty()) {
			BinaryTreeNode head = queue.poll();
			sb.append(" " + head.value);

			if (head.left != null)
				queue.add(head.left);
			if (head.right != null)
				queue.add(head.right);
		}
		System.out.println(sb.toString());

	}

	/**
	 * 逐行打印出树形节点 前提条件: 该树为完整二叉树
	 * 
	 * @param root
	 */
	static void printSequenceTreeCRLF(BinaryTreeNode root) {
		if (root == null)
			throw new IllegalArgumentException("novalid parameters");

		Queue<BinaryTreeNode> queue = new LinkedBlockingQueue<BinaryTreeNode>();
		queue.add(root);
		int nextCount = 0;
		int toBePrinted = 1;
		StringBuffer sb = new StringBuffer();
		while (!queue.isEmpty()) {
			BinaryTreeNode head = queue.poll();
			sb.append(" " + head.value);

			if (head.left != null) {
				queue.add(head.left);
				nextCount++;
			}
			if (head.right != null) {
				queue.add(head.right);
				nextCount++;
			}

			toBePrinted--;
			if (toBePrinted == 0) {
				sb.append("\n");
				toBePrinted = nextCount;
				nextCount = 0;
			}

		}
		System.out.println(sb.toString());

	}

	/**
	 * 之字形打印， 行间顺序错乱
	 * 
	 * @param root
	 */
	static void printSequenceTreeReverse(BinaryTreeNode root) {
		Stack<BinaryTreeNode> evenStack = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> oddStack = new Stack<BinaryTreeNode>();

		oddStack.add(root);

		Stack<BinaryTreeNode> currentStack = oddStack;
		StringBuffer sb = new StringBuffer();
		BinaryTreeNode first = null;
		BinaryTreeNode second = null;
		Stack<BinaryTreeNode> addStack = null;
		while (!evenStack.isEmpty() || !oddStack.isEmpty()) {
			BinaryTreeNode head = currentStack.pop();
			sb.append(" " + head.value);

			addStack = currentStack == oddStack ? evenStack : oddStack;
			
			// 保存寄数层的节点，save = <-- print =-->
			// 保存偶数层的节点，save = --> print = <--
			first = currentStack == oddStack ? head.left : head.right;
			second = currentStack == oddStack ? head.right : head.left;
			if (first != null)
				addStack.push(first);
			if (second != null)
				addStack.push(second);

			if (evenStack.isEmpty() && currentStack == evenStack) {
				sb.append("\n");
				currentStack = oddStack;
			} else if (oddStack.isEmpty() && currentStack == oddStack) {
				currentStack = evenStack;
				sb.append("\n");
			}

		}
		System.out.println(sb.toString());

	}

	// ====================测试代码====================
	static void Test(String testName, BinaryTreeNode pRoot) {
		if (testName != null)
			System.out.println(String.format("%s begins: \n", testName));

		TreeUtil.PrintTree(pRoot);

		System.out.println("The nodes from top to bottom, from left to right are: ");
		printSequenceTree(pRoot);
		// printSequenceTreeCRLF(pRoot);
		printSequenceTreeReverse(pRoot);
	}

	/**
	 * 
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

		TreeUtil.DestroyTree(pNode10);
	}

	/**
	 * /**
	 * 
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

		TreeUtil.DestroyTree(pNode5);
	}

	/**
	 * /**
	 * 
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

		TreeUtil.DestroyTree(pNode1);
	}

	// 树中只有1个结点
	static void Test4() {
		BinaryTreeNode pNode1 = TreeUtil.CreateBinaryTreeNode(1);
		Test("Test4", pNode1);

		TreeUtil.DestroyTree(pNode1);
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
