package easy;

import basicDataStructure.TreeNode;

/*
 * 2016.7.19
 * 这题目没啥说的，首先如果root是null，直接返回。
 * 否则，先调换root的左右子节点，然后分别对左右子节点使用invertTree方法。
 */
public class Q226 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode l = root.left;
		TreeNode r = root.right;
		root.right = l;
		root.left = r;
		invertTree(root.right);
		invertTree(root.left);
		return root;
	}
}
