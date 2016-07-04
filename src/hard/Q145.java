package hard;

import basicDataStructure.TreeNode;
import java.util.*;

/*
 * 2016.7.4
 * 典型的递归方法。递归后序遍历二叉树。
 */
public class Q145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		res.addAll(postorderTraversal(root.left));
		res.addAll(postorderTraversal(root.right));
		res.add(root.val);
		return res;
	}
}
