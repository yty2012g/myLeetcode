package medium;

import basicDataStructure.TreeNode;
import java.util.*;

/*
 * 2016.7.8
 * 二叉树层序遍历的应用。
 * 层序遍历，每次换行的时候就是二叉树在该行的最右节点。
 */
public class Q199 {
	public List<Integer> rightSideView(TreeNode root) {
		TreeNode cur = root;
		TreeNode ncur = null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp.left != null) {
				queue.offer(temp.left);
				ncur = temp.left;
			}
			if (temp.right != null) {
				queue.offer(temp.right);
				ncur = temp.right;
			}
			if (temp == cur) {
				cur = ncur;
				res.add(temp.val);
			}
		}
		return res;
	}
}
