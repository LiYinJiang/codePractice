package net.eryingzhang.train.o26;

import net.eryingzhang.train.Util.BinaryTreeNode;
import net.eryingzhang.train.Util.TreeUtil;

/**
 * 树A 和树B 判断B树是否是A树的子树
 * 
 * @author Yinjiang.Li
 *
 */
public class ContainTree {

	static boolean same(BinaryTreeNode a, BinaryTreeNode b) {
		if (b == null)
			return true;
		if (a == null)
			return false;
		if (a.value != b.value)
			return false;

		return same(a.left, b.left) && same(a.right, b.right);
	}

	/**
	 * <pre>
	 * 1、寻找parent 的子节点，是否于child 根节点一致
	 * 2、然后通过回溯的递归查找。不满足则继续向下查找。直到其中一颗树子节点为空。
	 * </pre>
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static boolean hasSubTree(BinaryTreeNode parent, BinaryTreeNode child) {
		boolean result = false;
		if (parent != null && child != null) {
			if (parent.value == child.value) // 找到相同节点
				result = same(parent, child); // 判断左右节点是否一致

			if (!result)
				result = hasSubTree(parent.left, child); // 从父节点左节点查找
			if (!result)
				result = hasSubTree(parent.right, child);// 从父节点右节点查找
		}
		return result;
	}

	

	// ====================测试代码====================
	static void Test(String testName, BinaryTreeNode pRoot1, BinaryTreeNode pRoot2, boolean expected) {
		if (hasSubTree(pRoot1, pRoot2) == expected)
			System.out.println(String.format("%s passed.\n", testName));
		else
			System.err.println(String.format("%s failed.\n", testName));
	}

	/**
	 * <pre>
	 *  树中结点含有分叉，树B是树A的子结构
	              8                8
	          /       \           / \
	         8         7         9   2
	       /   \
	      9     2
	           / \
	          4   7
	 * </pre>
	 */
	static void Test1() {
		BinaryTreeNode pNodeA1 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeA2 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeA3 = TreeUtil.CreateBinaryTreeNode(7);
		BinaryTreeNode pNodeA4 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNodeA5 = TreeUtil.CreateBinaryTreeNode(2);
		BinaryTreeNode pNodeA6 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNodeA7 = TreeUtil.CreateBinaryTreeNode(7);

		TreeUtil.ConnectTreeNodes(pNodeA1, pNodeA2, pNodeA3);
		TreeUtil.ConnectTreeNodes(pNodeA2, pNodeA4, pNodeA5);
		TreeUtil.ConnectTreeNodes(pNodeA5, pNodeA6, pNodeA7);

		BinaryTreeNode pNodeB1 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeB2 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNodeB3 = TreeUtil.CreateBinaryTreeNode(2);

		TreeUtil.ConnectTreeNodes(pNodeB1, pNodeB2, pNodeB3);

		Test("Test1", pNodeA1, pNodeB1, true);

		TreeUtil.DestroyTree(pNodeA1);
		TreeUtil.DestroyTree(pNodeB1);
	}

	/**
	 * <pre>
	 *  树中结点含有分叉，树B不是树A的子结构
	              8                8
	          /       \           / \
	         8         7         9   2
	       /   \
	      9     3
	           / \
	          4   7
	 * </pre>
	 */
	static void Test2() {
		BinaryTreeNode pNodeA1 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeA2 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeA3 = TreeUtil.CreateBinaryTreeNode(7);
		BinaryTreeNode pNodeA4 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNodeA5 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNodeA6 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNodeA7 = TreeUtil.CreateBinaryTreeNode(7);

		TreeUtil.ConnectTreeNodes(pNodeA1, pNodeA2, pNodeA3);
		TreeUtil.ConnectTreeNodes(pNodeA2, pNodeA4, pNodeA5);
		TreeUtil.ConnectTreeNodes(pNodeA5, pNodeA6, pNodeA7);

		BinaryTreeNode pNodeB1 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeB2 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNodeB3 = TreeUtil.CreateBinaryTreeNode(2);

		TreeUtil.ConnectTreeNodes(pNodeB1, pNodeB2, pNodeB3);

		Test("Test2", pNodeA1, pNodeB1, false);

		TreeUtil.DestroyTree(pNodeA1);
		TreeUtil.DestroyTree(pNodeB1);
	}

	/**
	 * <pre>
	 *  树中结点只有左子结点，树B是树A的子结构
	            8                  8
	          /                   / 
	         8                   9   
	       /                    /
	      9                    2
	     /      
	    2        
	   /
	  5
	 * </pre>
	 */
	static void Test3() {
		BinaryTreeNode pNodeA1 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeA2 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeA3 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNodeA4 = TreeUtil.CreateBinaryTreeNode(2);
		BinaryTreeNode pNodeA5 = TreeUtil.CreateBinaryTreeNode(5);

		TreeUtil.ConnectTreeNodes(pNodeA1, pNodeA2, null);
		TreeUtil.ConnectTreeNodes(pNodeA2, pNodeA3, null);
		TreeUtil.ConnectTreeNodes(pNodeA3, pNodeA4, null);
		TreeUtil.ConnectTreeNodes(pNodeA4, pNodeA5, null);

		BinaryTreeNode pNodeB1 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeB2 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNodeB3 = TreeUtil.CreateBinaryTreeNode(2);

		TreeUtil.ConnectTreeNodes(pNodeB1, pNodeB2, null);
		TreeUtil.ConnectTreeNodes(pNodeB2, pNodeB3, null);

		Test("Test3", pNodeA1, pNodeB1, true);

		TreeUtil.DestroyTree(pNodeA1);
		TreeUtil.DestroyTree(pNodeB1);
	}

	/**
	 * <pre>
	 *  树中结点只有左子结点，树B不是树A的子结构
	            8                  8
	          /                   / 
	         8                   9   
	       /                    /
	      9                    3
	     /      
	    2        
	   /
	  5
	 * </pre>
	 */
	static void Test4() {
		BinaryTreeNode pNodeA1 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeA2 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeA3 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNodeA4 = TreeUtil.CreateBinaryTreeNode(2);
		BinaryTreeNode pNodeA5 = TreeUtil.CreateBinaryTreeNode(5);

		TreeUtil.ConnectTreeNodes(pNodeA1, pNodeA2, null);
		TreeUtil.ConnectTreeNodes(pNodeA2, pNodeA3, null);
		TreeUtil.ConnectTreeNodes(pNodeA3, pNodeA4, null);
		TreeUtil.ConnectTreeNodes(pNodeA4, pNodeA5, null);

		BinaryTreeNode pNodeB1 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeB2 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNodeB3 = TreeUtil.CreateBinaryTreeNode(3);

		TreeUtil.ConnectTreeNodes(pNodeB1, pNodeB2, null);
		TreeUtil.ConnectTreeNodes(pNodeB2, pNodeB3, null);

		Test("Test4", pNodeA1, pNodeB1, false);

		TreeUtil.DestroyTree(pNodeA1);
		TreeUtil.DestroyTree(pNodeB1);
	}

	/**
	 * <pre>
	 *  树中结点只有右子结点，树B是树A的子结构
	   8                   8
	    \                   \ 
	     8                   9   
	      \                   \
	       9                   2
	        \      
	         2        
	          \
	           5
	 * </pre>
	 */
	static void Test5() {
		BinaryTreeNode pNodeA1 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeA2 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeA3 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNodeA4 = TreeUtil.CreateBinaryTreeNode(2);
		BinaryTreeNode pNodeA5 = TreeUtil.CreateBinaryTreeNode(5);

		TreeUtil.ConnectTreeNodes(pNodeA1, null, pNodeA2);
		TreeUtil.ConnectTreeNodes(pNodeA2, null, pNodeA3);
		TreeUtil.ConnectTreeNodes(pNodeA3, null, pNodeA4);
		TreeUtil.ConnectTreeNodes(pNodeA4, null, pNodeA5);

		BinaryTreeNode pNodeB1 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeB2 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNodeB3 = TreeUtil.CreateBinaryTreeNode(2);

		TreeUtil.ConnectTreeNodes(pNodeB1, null, pNodeB2);
		TreeUtil.ConnectTreeNodes(pNodeB2, null, pNodeB3);

		Test("Test5", pNodeA1, pNodeB1, true);

		TreeUtil.DestroyTree(pNodeA1);
		TreeUtil.DestroyTree(pNodeB1);
	}

	/**
	 * <pre>
	 * 树A中结点只有右子结点，树B不是树A的子结构
	   8                   8
	    \                   \ 
	     8                   9   
	      \                 / \
	       9               3   2
	        \      
	         2        
	          \
	           5
	 * </pre>
	 */
	static void Test6() {
		BinaryTreeNode pNodeA1 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeA2 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeA3 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNodeA4 = TreeUtil.CreateBinaryTreeNode(2);
		BinaryTreeNode pNodeA5 = TreeUtil.CreateBinaryTreeNode(5);

		TreeUtil.ConnectTreeNodes(pNodeA1, null, pNodeA2);
		TreeUtil.ConnectTreeNodes(pNodeA2, null, pNodeA3);
		TreeUtil.ConnectTreeNodes(pNodeA3, null, pNodeA4);
		TreeUtil.ConnectTreeNodes(pNodeA4, null, pNodeA5);

		BinaryTreeNode pNodeB1 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeB2 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNodeB3 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNodeB4 = TreeUtil.CreateBinaryTreeNode(2);

		TreeUtil.ConnectTreeNodes(pNodeB1, null, pNodeB2);
		TreeUtil.ConnectTreeNodes(pNodeB2, pNodeB3, pNodeB4);

		Test("Test6", pNodeA1, pNodeB1, false);

		TreeUtil.DestroyTree(pNodeA1);
		TreeUtil.DestroyTree(pNodeB1);
	}

	// 树A为空树
	static void Test7() {
		BinaryTreeNode pNodeB1 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeB2 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNodeB3 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNodeB4 = TreeUtil.CreateBinaryTreeNode(2);

		TreeUtil.ConnectTreeNodes(pNodeB1, null, pNodeB2);
		TreeUtil.ConnectTreeNodes(pNodeB2, pNodeB3, pNodeB4);

		Test("Test7", null, pNodeB1, false);

		TreeUtil.DestroyTree(pNodeB1);
	}

	// 树B为空树
	static void Test8() {
		BinaryTreeNode pNodeA1 = TreeUtil.CreateBinaryTreeNode(8);
		BinaryTreeNode pNodeA2 = TreeUtil.CreateBinaryTreeNode(9);
		BinaryTreeNode pNodeA3 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNodeA4 = TreeUtil.CreateBinaryTreeNode(2);

		TreeUtil.ConnectTreeNodes(pNodeA1, null, pNodeA2);
		TreeUtil.ConnectTreeNodes(pNodeA2, pNodeA3, pNodeA4);

		Test("Test8", pNodeA1, null, false);

		TreeUtil.DestroyTree(pNodeA1);
	}

	// 树A和树B都为空
	static void Test9() {
		Test("Test9", null, null, false);
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

	}

}
