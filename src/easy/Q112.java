package easy;

import basicDataStructure.TreeNode;

/*
 * 2016.5.25
 * 四种情况：
 * 1.空节点，false；
 * 2.叶子结点，比较当前值和当前sum的值，相等true，否则false；
 * 3。如果左右子节点都不为空，则左子树或者右子树有一个可以就行。
 * 4，如果有一个子树为空，则只能用另一个子树计算。
 */
public class Q112 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) {
			return sum == root.val;
		}
		if (root.left != null && root.right != null) {
			return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
		}
		if (root.left == null)
			return hasPathSum(root.right, sum - root.val);
		else
			return hasPathSum(root.left, sum - root.val);
	}
}
