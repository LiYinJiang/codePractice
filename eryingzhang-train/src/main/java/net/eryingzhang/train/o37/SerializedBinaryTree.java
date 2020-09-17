package net.eryingzhang.train.o37;

import java.util.ArrayList;
import java.util.List;

import net.eryingzhang.train.Util.BinaryTreeNode;
import net.eryingzhang.train.Util.TreeUtil;

/**
 * 对一棵树实现序列化和反序列化。 字串和树的转化 层序遍历后存为字串或者字节数组，
 * 
 * @author Yinjiang.Li
 *
 */
public class SerializedBinaryTree {
	static String SIGN_NULL = "&";
	static String SIGN_INTERVAL = ",";

	static String seriailize(BinaryTreeNode root) {
		if (root == null)
			return SIGN_NULL;

		return root.value + SIGN_INTERVAL + seriailize(root.left) + SIGN_INTERVAL + seriailize(root.right);
	}

	static BinaryTreeNode deserialize(String data) {
		String[] content = data.split(",");
		mIndex = -1;
		return deserialize(content);
	}

	static int mIndex = 0;

	static BinaryTreeNode deserialize(String[] data) {
		BinaryTreeNode node = null;
		mIndex++;
		if (data.length > mIndex && !data[mIndex].equals(SIGN_NULL)) {

			node = new BinaryTreeNode(Integer.valueOf(data[mIndex]));
			node.left = deserialize(data);
			node.right = deserialize(data);
		}
		return node;
	}

	// ==================== Test Code ====================
	static boolean isSameTree(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2) {
		if (pRoot1 == null && pRoot2 == null)
			return true;

		if (pRoot1 == null || pRoot2 == null)
			return false;

		if (pRoot1.value != pRoot2.value)
			return false;

		return isSameTree(pRoot1.left, pRoot2.left) && isSameTree(pRoot1.right, pRoot2.right);
	}

	static void Test(String testName, BinaryTreeNode pRoot) {
		if (testName != null)
			System.out.println(String.format("%s begins: \n", testName));

		TreeUtil.PrintTree(pRoot);
		String content = seriailize(pRoot);
		BinaryTreeNode pNewRoot = deserialize(content);

		TreeUtil.PrintTree(pNewRoot);

		if (isSameTree(pRoot, pNewRoot))
			System.out.println("The deserialized tree is same as the oritinal tree.\n\n");
		else
			System.out.println("The deserialized tree is NOT same as the oritinal tree.\n\n");

		TreeUtil.DestroyTree(pNewRoot);
	}

	/**
	 * <pre>
		8
	  6      10
	 5 7    9  11
	 * </pre>
	 */
	static void Test1() {
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

		Test("Test1", pNode8);

		TreeUtil.DestroyTree(pNode8);
	}

	/**
	 * <pre>
	       5
	     4
	   3
	 2
	 * </pre>
	 */
	static void Test2() {
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode4 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNode3 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNode2 = TreeUtil.CreateBinaryTreeNode(2);

		TreeUtil.ConnectTreeNodes(pNode5, pNode4, null);
		TreeUtil.ConnectTreeNodes(pNode4, pNode3, null);
		TreeUtil.ConnectTreeNodes(pNode3, pNode2, null);

		Test("Test2", pNode5);

		TreeUtil.DestroyTree(pNode5);
	}

	/**
	 * <pre>
	5
	4
	3
	 2
	 * </pre>
	 */
	static void Test3() {
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode4 = TreeUtil.CreateBinaryTreeNode(4);
		BinaryTreeNode pNode3 = TreeUtil.CreateBinaryTreeNode(3);
		BinaryTreeNode pNode2 = TreeUtil.CreateBinaryTreeNode(2);

		TreeUtil.ConnectTreeNodes(pNode5, null, pNode4);
		TreeUtil.ConnectTreeNodes(pNode4, null, pNode3);
		TreeUtil.ConnectTreeNodes(pNode3, null, pNode2);

		Test("Test3", pNode5);

		TreeUtil.DestroyTree(pNode5);
	}

	/**
	 * <pre>
	 * 
	 * </pre>
	 */
	static void Test4() {
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);

		Test("Test4", pNode5);

		TreeUtil.DestroyTree(pNode5);
	}

	static void Test5() {
		Test("Test5", null);
	}

	/**
	 * <pre>
				        5
				         5
				          5
				         5
				        5
				       5 5
				      5   5
	 * </pre>
	 */

	static void Test6() {
		BinaryTreeNode pNode1 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode2 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode3 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode4 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode5 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode61 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode62 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode71 = TreeUtil.CreateBinaryTreeNode(5);
		BinaryTreeNode pNode72 = TreeUtil.CreateBinaryTreeNode(5);

		TreeUtil.ConnectTreeNodes(pNode1, null, pNode2);
		TreeUtil.ConnectTreeNodes(pNode2, null, pNode3);
		TreeUtil.ConnectTreeNodes(pNode3, pNode4, null);
		TreeUtil.ConnectTreeNodes(pNode4, pNode5, null);
		TreeUtil.ConnectTreeNodes(pNode5, pNode61, pNode62);
		TreeUtil.ConnectTreeNodes(pNode61, pNode71, null);
		TreeUtil.ConnectTreeNodes(pNode62, null, pNode72);

		Test("Test6", pNode1);

		TreeUtil.DestroyTree(pNode1);
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
