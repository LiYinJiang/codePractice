package net.eryingzhang.train.o34;

import net.eryingzhang.train.Util.BinaryTreeNode;
import net.eryingzhang.train.Util.TreeUtil;

/**
 * 从树的根节点找寻路径，每个节点值的和等于传入整形值 即存在这条路径
 * 
 * @author Yinjiang.Li
 *
 */
public class ExistPathFromTree {

	/**
	 * 从根节点出发，寻找是否存在节点和 等于count 的路径
	 * 
	 * @param count
	 * @param root
	 * @return
	 */
	static boolean existPathFromTree(int count, BinaryTreeNode root) {
		if (count <= 0 || root == null)
			throw new IllegalArgumentException("novalid parameters");
		return existPathFromTree(count, root, 0);
	}

	static boolean existPathFromTree(int count, BinaryTreeNode root, int sum) {
		sum = root.value + sum;
		if (sum == count && root.left == null && root.right == null)
			return true;
		else if (sum > count)
			return false;
		boolean exist = false;
		if (root.left != null)
			exist = exist || existPathFromTree(count, root.left, sum);
		if (root.right != null)
			exist = exist || existPathFromTree(count, root.right, sum);
		return exist;
	}

	static void printPath(BinaryTreeNode root, int expectedSum) {
		if (expectedSum <= 0 || root == null)
			throw new IllegalArgumentException("novalid parameters");
		printPath(root, expectedSum, 0, new StringBuffer());
	}

	static void printPath(BinaryTreeNode root, int expectedSum, int currentSum, StringBuffer record) {
		record.append(" " + root.value);

		currentSum = root.value + currentSum;
		if (currentSum == expectedSum && root.left == null && root.right == null) { // 是否返回的判断， 节点数相等； 不存在根节点
			System.out.println(record.toString());
			return;
		} else if (currentSum > expectedSum) {
			return;
		}
		if (root.left != null)
			printPath(root.left, expectedSum, currentSum, new StringBuffer(record));

		if (root.right != null)
			printPath(root.right, expectedSum, currentSum, new StringBuffer(record));
	}

	// ====================测试代码====================
	static void Test(String testName, BinaryTreeNode pRoot, int expectedSum) {
		if (testName != null)
			System.out.println(String.format("%s begins:\n", testName));
		System.out.println("exist: " + existPathFromTree(expectedSum, pRoot));
		printPath(pRoot, expectedSum);
	}

	/**
	 * <pre>
	            			10
				         /      \
				        5        12
				       /\        
				      4  7     
				 有两条路径上的结点和为22
	 * </pre>
	 */
	static void Test1() {
		BinaryTreeNode pNode10 = TreeUtil.CreateBinaryTreeNode(10);
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode12 = TreeUtil.CreateBinaryTreeNode(12);
		BinaryTreeNode pNode4 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNode7 = TreeUtil.CreateBinaryTreeNode(7);

		TreeUtil.ConnectTreeNodes(pNode10, pNode5, pNode12);
		TreeUtil.ConnectTreeNodes(pNode5, pNode4, pNode7);

		System.out.println("Two paths should be found in Test1.\n");
		Test("Test1", pNode10, 22);

		TreeUtil.DestroyTree(pNode10);
	}

	/**
	 * <pre>
				            10
				         /      \
				        5        12
				       /\        
				      4  7     
				 没有路径上的结点和为15
	 * </pre>
	 */

	static void Test2() {
		BinaryTreeNode pNode10 = TreeUtil.CreateBinaryTreeNode(10);
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode12 = TreeUtil.CreateBinaryTreeNode(12);
		BinaryTreeNode pNode4 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNode7 = TreeUtil.CreateBinaryTreeNode(7);

		TreeUtil.ConnectTreeNodes(pNode10, pNode5, pNode12);
		TreeUtil.ConnectTreeNodes(pNode5, pNode4, pNode7);

		System.out.println("No paths should be found in Test2.\n");
		Test("Test2", pNode10, 15);

		TreeUtil.DestroyTree(pNode10);
	}

	/**
	 * <pre>
	
				               5
				              /
				             4
				            /
				           3
				          /
				         2
				        /
				       1
				 有一条路径上面的结点和为15
	 * </pre>
	 */

	static void Test3() {
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode4 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNode3 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNode2 = TreeUtil.CreateBinaryTreeNode(2);
		BinaryTreeNode pNode1 = TreeUtil.CreateBinaryTreeNode(1);

		TreeUtil.ConnectTreeNodes(pNode5, pNode4, null);
		TreeUtil.ConnectTreeNodes(pNode4, pNode3, null);
		TreeUtil.ConnectTreeNodes(pNode3, pNode2, null);
		TreeUtil.ConnectTreeNodes(pNode2, pNode1, null);

		System.out.println("One path should be found in Test3.\n");
		Test("Test3", pNode5, 15);

		TreeUtil.DestroyTree(pNode5);
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
				没有路径上面的结点和为16
	 * </pre>
	 */

	static void Test4() {
		BinaryTreeNode pNode1 = TreeUtil.CreateBinaryTreeNode(1);
		BinaryTreeNode pNode2 = TreeUtil.CreateBinaryTreeNode(2);
		BinaryTreeNode pNode3 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNode4 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);

		TreeUtil.ConnectTreeNodes(pNode1, null, pNode2);
		TreeUtil.ConnectTreeNodes(pNode2, null, pNode3);
		TreeUtil.ConnectTreeNodes(pNode3, null, pNode4);
		TreeUtil.ConnectTreeNodes(pNode4, null, pNode5);

		System.out.println("No paths should be found in Test4.\n");
		Test("Test4", pNode1, 16);

		TreeUtil.DestroyTree(pNode1);
	}

	// 树中只有1个结点
	static void Test5() {
		BinaryTreeNode pNode1 = TreeUtil.CreateBinaryTreeNode(1);

		System.out.println("One path should be found in Test5.\n");
		Test("Test5", pNode1, 1);

		TreeUtil.DestroyTree(pNode1);
	}

	// 树中没有结点
	static void Test6() {
		System.out.println("No paths should be found in Test6.\n");
		Test("Test6", null, 0);
	}

	public static void main(String[] args) {

		Test1();
		Test2();
		Test3();
		Test4();
		Test5();
		Test6();

	}

}
