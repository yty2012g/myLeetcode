package easy;

import java.util.*;

import basicDataStructure.TreeNode;

/*
 * 2016.5.21
 * 层序遍历。使用nlast和last两个变量，nlast指向当前行处理的节点。nlast表示上一行的最右节点
 * 首先将root放入队列。令last=root；
 * 每次弹出一个元素，如果元素的左节点非空，放入队列，nlast等于左节点，右节点非空，放入队列，nlast等于右节点。
 * 如果弹出的节点等于last，则last等于nlast，变成了当前行的最右节点，然后将当前行保存在结果中。继续遍历下一行。
 */
public class Q102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null)
			return res;
		TreeNode last = root;
		TreeNode nlast = null;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			list.add(temp.val);
			if (temp.left != null) {
				queue.offer(temp.left);
				nlast = temp.left;
			}
			if (temp.right != null) {
				queue.offer(temp.right);
				nlast = temp.right;
			}
			if (temp == last) {
				last = nlast;
				res.add((List<Integer>) list.clone());
				list = new ArrayList<Integer>();
			}
		}
		return res;
	}
}
