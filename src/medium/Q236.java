package medium;

import basicDataStructure.TreeNode;
import java.util.*;

/*
 * 2016.7.22
 * 这个题目用基于union-find的方法在大数据集无法通过，因为递归深度等于树的深度，如果树变成链表，则会出现堆栈溢出。
 * 这个题目的想法很简单，如果p和q不是对方的公共祖先，那么一定分布在公共祖先的两侧。
 * 所以，DFS遍历，如果当前结点就是p或者q，则返回当前结点，否则dfs继续遍历，如果后续的子树都不包含p或者q，则均会返回null，此时返回null
 * 如果左右子树返回结果均不是null，则说明当前结点就是p和q的公共祖先。
 * 如果左右子树只出现了p或者q，那么返回出现的节点。
 */
public class Q236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root == p || root == q)
			return root;
		TreeNode L = lowestCommonAncestor(root.left, p, q);
		TreeNode R = lowestCommonAncestor(root.right, p, q);
		if (L != null && R != null)
			return root;
		return L != null ? L : R;
	}

}
