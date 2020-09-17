package net.eryingzhang.train.o7;

public class BinaryTreeNode {
	int value;
	BinaryTreeNode left;
	BinaryTreeNode right;

	public BinaryTreeNode(int value) {
		super();
		this.value = value;
	}

	static BinaryTreeNode build(int[] preArr, int[] midArr) {
		if (preArr == null || midArr == null || preArr.length == 0 || midArr.length == 0
				|| preArr.length != midArr.length)
			return null;
		BinaryTreeNode root = recusivelyBuild(preArr, 0, preArr.length - 1, midArr, 0, midArr.length - 1);
		return root;

	}

	/*
	 * 1、从前序中找到根节点。 在中序中找到根节点位置，前后分别处理 前面是做节点，从前序中前移一位作为左子树的根节点数值。
	 * 判断中序中根节点位置。对根节点处理序号后移一位，和中序节点比较 数组长度是一致的。
	 */

	static BinaryTreeNode recusivelyBuild(int[] preArr, int preStartIndex, int preEndIndex, int[] midArr,
			int midStartIndex, int midEndIndex) {
		if (preStartIndex > preEndIndex || midStartIndex > midEndIndex)
			return null;

		int rootValue = preArr[preStartIndex];
		BinaryTreeNode root = new BinaryTreeNode(rootValue);
		int midRootValueIndex = -1;
		int leftLength = -1;
		int rightLength = -1;
		for (int i = midStartIndex; i < midArr.length; i++) {
			if (midArr[i] == rootValue) {
				midRootValueIndex = i;
				leftLength = i - midStartIndex;
				rightLength = midEndIndex - i;
			}
		}

		root.left = recusivelyBuild(preArr, preStartIndex + 1, preStartIndex + leftLength, midArr, midStartIndex,
				midRootValueIndex - 1);
		root.right = recusivelyBuild(preArr, preStartIndex + leftLength, preEndIndex + leftLength, midArr,
				midRootValueIndex + 1, midEndIndex);

		return root;
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, inorder, 0, 0, inorder.length - 1);
	}

	public static TreeNode build(int[] preorder, int[] inorder, int preindex, int sInorder, int eInorder) {

		if (preindex > preorder.length - 1 || sInorder > eInorder)
			return null;

		TreeNode treeNode = new TreeNode(preorder[preindex]);

		int inRootIndex = sInorder;
		for (; inRootIndex <= eInorder; inRootIndex++)
			if (treeNode.val == inorder[inRootIndex])
				break;
		/*comment 
		 * int leftChildTreeLength = index - sInorder;
		int leftPreIndex = preindex +1;
		int rightPreIndex = leftPreIndex + leftChildTreeLength;
		 * */
		 
		treeNode.left = build(preorder, inorder, preindex + 1, sInorder, inRootIndex - 1);
		treeNode.right = build(preorder, inorder, preindex + inRootIndex - sInorder + 1, inRootIndex + 1, eInorder);

		return treeNode;

	}

	public static void main(String[] args) {
		int[] preArr = new int[] { 1, 2, 4, 7, 4, 5, 6, 8 };
		int[] midArr = new int[] { 4, 7, 2, 1, 5, 3, 8, 6 };
//		int[] preArr = new int[] {  2, 4, 7 };
//		int[] midArr = new int[] { 4, 7, 2 };
		TreeNode node = buildTree(preArr, midArr);
		System.out.println(node);
	}
}
