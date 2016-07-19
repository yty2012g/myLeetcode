package easy;

import basicDataStructure.TreeNode;

/*
 * 2016.7.19
 * 首先保证p的值比q的值要小。
 * 令cur等于root。
 * 如果cur大于等于p的值同时小于等于q的值，则cur即为所求点
 * 如果q的值大于cur的值，那么cur转向左子节点。
 * 如果p的值大于cur的值，那么cur转向右子节点。
 */
public class Q235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val > q.val)
			return lowestCommonAncestor(root, q, p);
		TreeNode cur = root;
		while (true) {
			if (cur.val >= p.val && cur.val <= q.val)
				return cur;
			if (q.val < cur.val)
				cur = cur.left;
			if (p.val > cur.val)
				cur = cur.right;
		}
	}
}
