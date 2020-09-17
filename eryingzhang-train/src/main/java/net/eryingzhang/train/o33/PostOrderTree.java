package net.eryingzhang.train.o33;

/**
 * 判断 数组是否是一棵二叉搜索树的后序遍历结果 根据二叉搜索树的特性。 即 根节点下左值小 右值大
 * 
 * @author Yinjiang.Li
 *
 */
public class PostOrderTree {

	/**
	 * 从数组的尾部访问元素。取得根节点。 根据根节点大小 取得左子树和右子树 对子树的根做判断。符合要求后进行递归。直到子树为空
	 * 
	 * @param postArr
	 * @return
	 */
	static boolean postOrderTree(int[] postArr) {
		if (postArr == null || postArr.length <= 0)
			throw new IllegalArgumentException("novalid parameters");
		return postOrderTreeByRecusive(postArr, 0, postArr.length - 1);
	}

	static boolean postOrderTreeByRecusive(int[] postArr, int start, int end) {
		if (start > end || postArr.length - 1 < end)
			return false;
		if (start == end) // 不能再拆分
			return true;

		// 根节点
		int root = postArr[end];

		// 在数组中找到左右子树 可能只有一边
		int leftEndIndex = start;
		while (postArr[leftEndIndex] < root && leftEndIndex < end) {
			leftEndIndex++;
		} //获得左子树结束闭环位置

		int rightStartIndex = leftEndIndex;
		while (rightStartIndex < end) {
			if (postArr[rightStartIndex] < root) // 右子树中节点比根节点小 不符合二叉搜索树规范
				return false;
			rightStartIndex++;
		}//获得右子树开始环位置

		boolean postOrder = true;
		if (leftEndIndex - 1 > start) //存在左子树
			postOrder = postOrder && postOrderTreeByRecusive(postArr, start, leftEndIndex - 1);
		if (end - 1 > leftEndIndex) //存在右子树 
			postOrder = postOrder && postOrderTreeByRecusive(postArr, leftEndIndex, end -1);
		return postOrder;
	}

	// ====================测试代码====================
	static void Test(String testName, int sequence[], boolean expected) {
		if (testName != null)
			System.out.println(String.format("%s begins: ", testName));

		if (postOrderTree(sequence) == expected)
			System.out.println("passed.");
		else
			System.out.println("failed.");
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
		int data[] = { 4, 8, 6, 12, 16, 14, 10 };
		Test("Test1", data, true);
	}

	/**
	 * <pre>
	 *     5
	      / \
	     4   7
	        /
	       6
	 * </pre>
	 */
	static void Test2() {
		int data[] = { 4, 6, 7, 5 };
		Test("Test2", data, true);
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
	 * </pre>
	 */
	static void Test3() {
		int data[] = { 1, 2, 3, 4, 5 };
		Test("Test3", data, true);
	}

	/**
	 * <pre>
	 * 
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
	static void Test4() {
		int data[] = { 5, 4, 3, 2, 1 };
		Test("Test4", data, true);
	}

	// 树中只有1个结点
	static void Test5() {
		int data[] = { 5 };
		Test("Test5", data, true);
	}

	/**
	 * <pre>
	 * 
	 * </pre>
	 */
	static void Test6() {
		int data[] = { 7, 4, 6, 5 };
		Test("Test6", data, false);
	}

	/**
	 * <pre>
	 * 
	 * </pre>
	 */
	static void Test7() {
		int data[] = { 4, 6, 12, 8, 16, 14, 10 };
		Test("Test7", data, false);
	}

	/**
	 * <pre>
	 * 
	 * </pre>
	 */
	static void Test8() {
		Test("Test8", null, false);
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

	}

}
