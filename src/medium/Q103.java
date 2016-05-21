package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import basicDataStructure.TreeNode;

/*
 * 2016.5.21
 * 还是层序遍历。
 * 这里将下标为奇数的行的结果进行反序
 */
public class Q103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		return re(levelOrder(root));
	}

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

	public List<List<Integer>> re(List<List<Integer>> list) {
		for (int i = 0; i < list.size(); i++) {
			if (i % 2 != 0) {
				for (int j = 0; j < list.get(i).size() / 2; j++) {
					int temp = list.get(i).get(j);
					list.get(i).set(j, list.get(i).get(list.get(i).size() - 1 - j));
					list.get(i).set(list.get(i).size() - 1 - j, temp);
				}
			}
		}
		return list;
	}
}
