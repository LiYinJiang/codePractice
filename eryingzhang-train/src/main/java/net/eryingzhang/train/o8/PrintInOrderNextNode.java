package net.eryingzhang.train.o8;

/**
<pre>前序 中左右
1、 是否有左节点 找到最左子节点
2、是否有父节点，找到父节点的右节点
后序 左右中
 1、是否有左节点 找到最左子节点
 2、有父节点，找到父节点的最左子节点，没有就是父节点
 中序 左中右
 1、有右节点，找到最左自己点
 2、找到父节点中的最左子节点的，
 </pre>
 * */
public class PrintInOrderNextNode {

	static TreeNode getNext(TreeNode node) {
		TreeNode next = null;
		if (node == null)
			return null;

		if (node.right != null) {
			next = node.right;

			while (next.left != null) {
				next = next.left;
			}

		} else { // 包含节点位置 为中和右节点
			TreeNode parent = node.parent;
			while (parent != null) {
				if (parent.left == node)
					next = parent;
				parent = parent.parent;
			}
		}

		return next;
	}

	/**
	 * <br>
	 * tree <br>
	 * a <br>
	 * b c <br>
	 * d e f g <br>
	 * h i <br>
	 * mid{d,b,h,e,i,a,f,c,g} <br>
	 * <br>
	 */
	public static void main(String[] args) {

	}
}
