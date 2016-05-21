package easy;

/*
 * 2016.5.21
 * 二叉树递归遍历，如果当前结点为null节点，高度为0，如果不是null，则为左子树和右子树中高度较大的加1
 */

import basicDataStructure.TreeNode;

public class Q104 {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.min(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
