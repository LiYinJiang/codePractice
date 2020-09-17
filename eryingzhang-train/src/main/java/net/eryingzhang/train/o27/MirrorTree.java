package net.eryingzhang.train.o27;

import java.util.Stack;

import net.eryingzhang.train.Util.BinaryTreeNode;
import net.eryingzhang.train.Util.TreeUtil;

public class MirrorTree {

	public static void mirrorRecursively(BinaryTreeNode root) {
		if (root != null) {
			BinaryTreeNode temp = root.left;
			root.left = root.right;
			root.right = temp;
			mirrorRecursively(root.left);
			mirrorRecursively(root.right);
		}
	}

	static void mirrorIteratively(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		if (root != null)
			stack.push(root);

		// 从根节点开始利用不断地出栈入栈，对每个节点的子节点进行调换
		while (stack.size() > 0) {

			BinaryTreeNode node = stack.pop();
			BinaryTreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			if (node.left != null)
				stack.push(node.left);
			if (node.right != null)
				stack.push(node.right);
		}

	}

	// ====================测试代码====================
	/**
	 * <pre>
	测试完全二叉树：除了叶子节点，其他节点都有两个子节点
	        8
	    6      10
	   5 7    9  11
	 * </pre>
	 */

	static void Test1() {
		System.out.println("=====Test1 starts:=====");
		BinaryTreeNode pNode8 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNode6 = TreeUtil.CreateBinaryTreeNode(6);
		BinaryTreeNode pNode10 = TreeUtil.CreateBinaryTreeNode(10);
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode7 = TreeUtil.CreateBinaryTreeNode(7);
		BinaryTreeNode pNode9 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNode11 = TreeUtil.CreateBinaryTreeNode(11);

		TreeUtil.ConnectTreeNodes(pNode8, pNode6, pNode10);
		TreeUtil.ConnectTreeNodes(pNode6, pNode5, pNode7);
		TreeUtil.ConnectTreeNodes(pNode10, pNode9, pNode11);

		TreeUtil.PrintTree(pNode8);

		System.out.println("=====Test1: mirrorRecursively=====");
		mirrorRecursively(pNode8);
		TreeUtil.PrintTree(pNode8);

		System.out.println("=====Test1: //mirrorIteratively=====");
		mirrorIteratively(pNode8);
		TreeUtil.PrintTree(pNode8);

		TreeUtil.DestroyTree(pNode8);
	}

	/**
	 * /**
	 * 
	 * <pre>
	
	测试二叉树：出叶子结点之外，左右的结点都有且只有一个左子结点
	        8
	      7   
	    6 
	  5
	4
	 * </pre>
	 */

	static void Test2() {
		System.out.println("=====Test2 starts:=====");
		BinaryTreeNode pNode8 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNode7 = TreeUtil.CreateBinaryTreeNode(7);
		BinaryTreeNode pNode6 = TreeUtil.CreateBinaryTreeNode(6);
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode4 = TreeUtil.CreateBinaryTreeNode(4);

		TreeUtil.ConnectTreeNodes(pNode8, pNode7, null);
		TreeUtil.ConnectTreeNodes(pNode7, pNode6, null);
		TreeUtil.ConnectTreeNodes(pNode6, pNode5, null);
		TreeUtil.ConnectTreeNodes(pNode5, pNode4, null);

		TreeUtil.PrintTree(pNode8);

		System.out.println("=====Test2: mirrorRecursively=====");
		mirrorRecursively(pNode8);
		TreeUtil.PrintTree(pNode8);

		System.out.println("=====Test2: //mirrorIteratively=====");
		mirrorIteratively(pNode8);
		TreeUtil.PrintTree(pNode8);

		TreeUtil.DestroyTree(pNode8);
	}

	/**
	 * <pre>
	测试二叉树：出叶子结点之外，左右的结点都有且只有一个右子结点
	        8
	         7   
	          6 
	           5
	            4
	 * </pre>
	 */
	static void Test3() {
		System.out.println("=====Test3 starts:=====");
		BinaryTreeNode pNode8 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNode7 = TreeUtil.CreateBinaryTreeNode(7);
		BinaryTreeNode pNode6 = TreeUtil.CreateBinaryTreeNode(6);
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode4 = TreeUtil.CreateBinaryTreeNode(4);

		TreeUtil.ConnectTreeNodes(pNode8, null, pNode7);
		TreeUtil.ConnectTreeNodes(pNode7, null, pNode6);
		TreeUtil.ConnectTreeNodes(pNode6, null, pNode5);
		TreeUtil.ConnectTreeNodes(pNode5, null, pNode4);

		TreeUtil.PrintTree(pNode8);

		System.out.println("=====Test3: mirrorRecursively=====");
		mirrorRecursively(pNode8);
		TreeUtil.PrintTree(pNode8);

		System.out.println("=====Test3: //mirrorIteratively=====");
		mirrorIteratively(pNode8);
		TreeUtil.PrintTree(pNode8);

		TreeUtil.DestroyTree(pNode8);
	}

	// 测试空二叉树：根结点为空指针
	static void Test4() {
		System.out.println("=====Test4 starts:=====");
		BinaryTreeNode pNode = null;

		TreeUtil.PrintTree(pNode);

		System.out.println("=====Test4: mirrorRecursively=====");
		mirrorRecursively(pNode);
		TreeUtil.PrintTree(pNode);

		System.out.println("=====Test4: //mirrorIteratively=====");
		mirrorIteratively(pNode);
		TreeUtil.PrintTree(pNode);
	}

	// 测试只有一个结点的二叉树
	static void Test5() {
		System.out.println("=====Test5 starts:=====");
		BinaryTreeNode pNode8 = TreeUtil.CreateBinaryTreeNode(8);

		TreeUtil.PrintTree(pNode8);

		System.out.println("=====Test4: mirrorRecursively=====");
		mirrorRecursively(pNode8);
		TreeUtil.PrintTree(pNode8);

		System.out.println("=====Test4: //mirrorIteratively=====");
		mirrorIteratively(pNode8);
		TreeUtil.PrintTree(pNode8);
	}

	public static void main(String[] args) {

		Test1();
		Test2();
		Test3();
		Test4();
		Test5();

	}
}
