package net.eryingzhang.train.o28;

import net.eryingzhang.train.Util.BinaryTreeNode;
import net.eryingzhang.train.Util.TreeUtil;

public class SymmetryTree {

	/**
	 * 判断是否对称，可以简化为 将树镜像后。若仍一致则就是对称
	 * 
	 * @param root
	 * @return
	 */
	static boolean isSymmetrical(BinaryTreeNode root) {
		if (root == null)
			throw new IllegalArgumentException("novalid parameters");
		return isSymmetrical(root, root);
	}

	static boolean isSymmetrical(BinaryTreeNode root, BinaryTreeNode root1) {
		if (root == null && root1 == null)
			return true;
		if (root == null || root1 == null)
			return false;

		boolean symmerty = root.value == root1.value;
		if (symmerty)
			symmerty = isSymmetrical(root.left, root1.right) && isSymmetrical(root.right, root1.left);
		return symmerty;
	}

	static void Test(String testName, BinaryTreeNode pRoot, boolean expected) {
		if (testName != null)
			System.out.println(String.format("%s begins: ", testName));
		if (isSymmetrical(pRoot) == expected)
			System.out.println("Passed");
		else
			System.out.println("FAILED");
	}

	/**
	 * 
	 * <pre>
	        8
	    6      6
	   5 7    7 5
	 * </pre>
	 */
	static void Test1() {
		BinaryTreeNode pNode8 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNode61 = TreeUtil.CreateBinaryTreeNode(6);
		BinaryTreeNode pNode62 = TreeUtil.CreateBinaryTreeNode(6);
		BinaryTreeNode pNode51 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode71 = TreeUtil.CreateBinaryTreeNode(7);
		BinaryTreeNode pNode72 = TreeUtil.CreateBinaryTreeNode(7);
		BinaryTreeNode pNode52 = TreeUtil.CreateBinaryTreeNode(5);

		TreeUtil.ConnectTreeNodes(pNode8, pNode61, pNode62);
		TreeUtil.ConnectTreeNodes(pNode61, pNode51, pNode71);
		TreeUtil.ConnectTreeNodes(pNode62, pNode72, pNode52);

		Test("Test1", pNode8, true);

		TreeUtil.DestroyTree(pNode8);
	}

	/**
	 * <pre>
	        8
	    6      9
	   5 7    7 5
	 * </pre>
	 */
	static void Test2() {
		BinaryTreeNode pNode8 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNode61 = TreeUtil.CreateBinaryTreeNode(6);
		BinaryTreeNode pNode9 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNode51 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode71 = TreeUtil.CreateBinaryTreeNode(7);
		BinaryTreeNode pNode72 = TreeUtil.CreateBinaryTreeNode(7);
		BinaryTreeNode pNode52 = TreeUtil.CreateBinaryTreeNode(5);

		TreeUtil.ConnectTreeNodes(pNode8, pNode61, pNode9);
		TreeUtil.ConnectTreeNodes(pNode61, pNode51, pNode71);
		TreeUtil.ConnectTreeNodes(pNode9, pNode72, pNode52);

		Test("Test2", pNode8, false);

		TreeUtil.DestroyTree(pNode8);
	}

	/**
	 * <pre>
	        8
	    6      6
	   5 7    7
	 * </pre>
	 */
	static void Test3() {
		BinaryTreeNode pNode8 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNode61 = TreeUtil.CreateBinaryTreeNode(6);
		BinaryTreeNode pNode62 = TreeUtil.CreateBinaryTreeNode(6);
		BinaryTreeNode pNode51 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode71 = TreeUtil.CreateBinaryTreeNode(7);
		BinaryTreeNode pNode72 = TreeUtil.CreateBinaryTreeNode(7);

		TreeUtil.ConnectTreeNodes(pNode8, pNode61, pNode62);
		TreeUtil.ConnectTreeNodes(pNode61, pNode51, pNode71);
		TreeUtil.ConnectTreeNodes(pNode62, pNode72, null);

		Test("Test3", pNode8, false);

		TreeUtil.DestroyTree(pNode8);
	}

	/**
	 * 
	 * 
	 * <pre>
	           5
	          / \
	         3   3
	        /     \
	       4       4
	      /         \
	     2           2
	    /             \
	   1               1
	 * </pre>
	 */
	static void Test4() {
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode31 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNode32 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNode41 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNode42 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNode21 = TreeUtil.CreateBinaryTreeNode(2);
		BinaryTreeNode pNode22 = TreeUtil.CreateBinaryTreeNode(2);
		BinaryTreeNode pNode11 = TreeUtil.CreateBinaryTreeNode(1);
		BinaryTreeNode pNode12 = TreeUtil.CreateBinaryTreeNode(1);

		TreeUtil.ConnectTreeNodes(pNode5, pNode31, pNode32);
		TreeUtil.ConnectTreeNodes(pNode31, pNode41, null);
		TreeUtil.ConnectTreeNodes(pNode32, null, pNode42);
		TreeUtil.ConnectTreeNodes(pNode41, pNode21, null);
		TreeUtil.ConnectTreeNodes(pNode42, null, pNode22);
		TreeUtil.ConnectTreeNodes(pNode21, pNode11, null);
		TreeUtil.ConnectTreeNodes(pNode22, null, pNode12);

		Test("Test4", pNode5, true);

		TreeUtil.DestroyTree(pNode5);
	}

	/**
	 * 
	 * 
	 * <pre>
	           5
	          / \
	         3   3
	        /     \
	       4       4
	      /         \
	     6           2
	    /             \
	   1               1
	 * </pre>
	 */
	static void Test5() {
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode31 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNode32 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNode41 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNode42 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNode6 = TreeUtil.CreateBinaryTreeNode(6);
		BinaryTreeNode pNode22 = TreeUtil.CreateBinaryTreeNode(2);
		BinaryTreeNode pNode11 = TreeUtil.CreateBinaryTreeNode(1);
		BinaryTreeNode pNode12 = TreeUtil.CreateBinaryTreeNode(1);

		TreeUtil.ConnectTreeNodes(pNode5, pNode31, pNode32);
		TreeUtil.ConnectTreeNodes(pNode31, pNode41, null);
		TreeUtil.ConnectTreeNodes(pNode32, null, pNode42);
		TreeUtil.ConnectTreeNodes(pNode41, pNode6, null);
		TreeUtil.ConnectTreeNodes(pNode42, null, pNode22);
		TreeUtil.ConnectTreeNodes(pNode6, pNode11, null);
		TreeUtil.ConnectTreeNodes(pNode22, null, pNode12);

		Test("Test5", pNode5, false);

		TreeUtil.DestroyTree(pNode5);
	}

	/**
	 * 
	 * 
	 * <pre>
	       	   5
	          / \
	         3   3
	        /     \
	       4       4
	      /         \
	     2           2
	                  \
	                   1
	 * </pre>
	 */
	static void Test6() {
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode31 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNode32 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNode41 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNode42 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNode21 = TreeUtil.CreateBinaryTreeNode(2);
		BinaryTreeNode pNode22 = TreeUtil.CreateBinaryTreeNode(2);
		BinaryTreeNode pNode12 = TreeUtil.CreateBinaryTreeNode(1);

		TreeUtil.ConnectTreeNodes(pNode5, pNode31, pNode32);
		TreeUtil.ConnectTreeNodes(pNode31, pNode41, null);
		TreeUtil.ConnectTreeNodes(pNode32, null, pNode42);
		TreeUtil.ConnectTreeNodes(pNode41, pNode21, null);
		TreeUtil.ConnectTreeNodes(pNode42, null, pNode22);
		TreeUtil.ConnectTreeNodes(pNode21, null, null);
		TreeUtil.ConnectTreeNodes(pNode22, null, pNode12);

		Test("Test6", pNode5, false);

		TreeUtil.DestroyTree(pNode5);
	}

	// 只有一个结点
	static void Test7() {
		BinaryTreeNode pNode1 = TreeUtil.CreateBinaryTreeNode(1);
		Test("Test7", pNode1, true);

		TreeUtil.DestroyTree(pNode1);
	}

	// 没有结点
	static void Test8() {
		Test("Test8", null, true);
	}

	/**
	 * 
	 * 
	 * <pre>
	 所有结点都有相同的值，树对称
	           5
	          / \
	         5   5
	        /     \
	       5       5
	      /         \
	     5           5
	 * </pre>
	 */
	static void Test9() {
		BinaryTreeNode pNode1 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode21 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode22 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode31 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode32 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode41 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode42 = TreeUtil.CreateBinaryTreeNode(5);

		TreeUtil.ConnectTreeNodes(pNode1, pNode21, pNode22);
		TreeUtil.ConnectTreeNodes(pNode21, pNode31, null);
		TreeUtil.ConnectTreeNodes(pNode22, null, pNode32);
		TreeUtil.ConnectTreeNodes(pNode31, pNode41, null);
		TreeUtil.ConnectTreeNodes(pNode32, null, pNode42);
		TreeUtil.ConnectTreeNodes(pNode41, null, null);
		TreeUtil.ConnectTreeNodes(pNode42, null, null);

		Test("Test9", pNode1, true);

		TreeUtil.DestroyTree(pNode1);
	}

	/**
	 * 
	 * 
	 * <pre>
	 所有结点都有相同的值，树不对称
	           5
	          / \
	         5   5
	        /     \
	       5       5
	      /       /
	     5       5
	 * </pre>
	 */
	static void Test10() {
		BinaryTreeNode pNode1 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode21 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode22 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode31 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode32 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode41 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode42 = TreeUtil.CreateBinaryTreeNode(5);

		TreeUtil.ConnectTreeNodes(pNode1, pNode21, pNode22);
		TreeUtil.ConnectTreeNodes(pNode21, pNode31, null);
		TreeUtil.ConnectTreeNodes(pNode22, null, pNode32);
		TreeUtil.ConnectTreeNodes(pNode31, pNode41, null);
		TreeUtil.ConnectTreeNodes(pNode32, pNode42, null);
		TreeUtil.ConnectTreeNodes(pNode41, null, null);
		TreeUtil.ConnectTreeNodes(pNode42, null, null);

		Test("Test10", pNode1, false);

		TreeUtil.DestroyTree(pNode1);
	}

	public static void main(String[] args) {
		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
		Test6();
		Test7();
		Test8();
		Test9();
		Test10();
	}

}
