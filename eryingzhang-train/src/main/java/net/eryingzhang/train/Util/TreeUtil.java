package net.eryingzhang.train.Util;

public class TreeUtil {
	public static BinaryTreeNode CreateBinaryTreeNode(int value) {
		BinaryTreeNode pNode = new BinaryTreeNode();
		pNode.value = value;
		pNode.left = null;
		pNode.right = null;

		return pNode;
	}

	public static void ConnectTreeNodes(BinaryTreeNode pParent, BinaryTreeNode pLeft, BinaryTreeNode pRight) {
		if (pParent != null) {
			pParent.left = pLeft;
			pParent.right = pRight;
		}
	}

	public static void DestroyTree(BinaryTreeNode pRoot) {
		if (pRoot != null) {
			BinaryTreeNode pLeft = pRoot.left;
			BinaryTreeNode pRight = pRoot.right;

			pRoot = null;

			DestroyTree(pLeft);
			DestroyTree(pRight);
		}
	}

	public static void PrintTree(BinaryTreeNode root) {
		BTreePrinter.printBinaryTreeNode(root);
	}

	public static BinaryTreeNode cloneTree(BinaryTreeNode root) {
		BinaryTreeNode clone = null;
		if (root != null) {
			clone = new BinaryTreeNode(root.value);
			if (root.left != null)
				clone.left = cloneTree(root.left);
			if (root.right != null)
				clone.right = cloneTree(root.right);
		}
		return clone;
	}
}
