package easy;

import basicDataStructure.TreeNode;
/*
 * 2016.5.21
 * 思路比较简单，如果两个节点都是null，相等；只有一个是null，不相等；两个都不是null，当且仅当元素值相同并且左子树和右子数相等。
 * 递归做就行了。
 */

public class Q100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if ((p == null && q != null) || (q == null && p != null))
			return false;
		if (isSameTree(p.left, q.left) && (p.val == q.val) && isSameTree(p.right, q.right))
			return true;
		return false;
	}
}
