package hard;

import java.util.HashMap;

import basicDataStructure.TreeNode;

/*
 * 2016.7.2
 * 考虑到节点值是负数的情况，如果节点为空，则返回最小的负数。
 * maxPath用来计算root往下单条线的最大和。
 * 情况1：root外的所有点均为负数。那么直接返回root的val值
 * 情况2：root的左节点的单线和和右节点的单线和都为正，则结果为左右节点的单线和之和再加上root的val。
 * 情况3，root节点的单线和。
 */
public class Q124 {
	HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0x7fffffff + 1;
		int m = Math.max(root.val, Math.max(maxPath(root), maxPath(root.left) + maxPath(root.right) + root.val));
		return Math.max(Math.max(maxPathSum(root.left), maxPathSum(root.right)), m);
	}

	public int maxPath(TreeNode root) {
		if (root == null)
			return 0;
		if (map.get(root) == null)
			map.put(root, Math.max(root.val, Math.max(maxPath(root.left), maxPath(root.right)) + root.val));
		return map.get(root);
	}

}
