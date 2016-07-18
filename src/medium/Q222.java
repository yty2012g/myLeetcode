package medium;

import basicDataStructure.TreeNode;

/*
 * 2016.7.18
 * 二分搜索的应用。
 * 对于一颗完全二叉树而言，统计节点数目是可以通过满二叉树的节点数目计算方法来计算的。
 * 假设最后一行停下的点超过了一半，那么对于root而言，root的左子树是一颗满二叉树，所有节点数目就是2^h-1，h为层数。
 * 反之，root的右子树是满二叉树，然后再计算左子树即可。
 * 这里的小tips。。。计算2的幂次不要用pow。。直接用右移。速度快的飞起。。
 */
public class Q222 {
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		TreeNode cur = root.left;
		TreeNode curR = root.right;
		if (cur == null)
			return 1;
		int l = 0;
		int r = 0;
		while (cur != null && curR != null) {
			cur = cur.left;
			l++;
			curR = curR.left;
			r++;
		}
		if (cur == null && curR == null) {
			return (1 << l) + countNodes(root.right);
		} else {
			return (1 << r) + countNodes(root.left);
		}
	}
}
