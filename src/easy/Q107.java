package easy;

import java.util.*;

import basicDataStructure.TreeNode;

/*
 * 2016.5.25
 * 这个和层序遍历是一样的，无非就是最后多了一步将结果反序的步骤
 */
public class Q107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		TreeNode last = root;
		TreeNode nlast = root;
		Queue<TreeNode> Queue = new LinkedList<TreeNode>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		ArrayList<Integer> t = new ArrayList<Integer>();
		Queue.offer(root);
		while (!Queue.isEmpty()) {
			TreeNode temp = Queue.poll();
			t.add(temp.val);
			if (temp.left != null) {
				Queue.offer(temp.left);
				nlast = temp.left;
			}
			if (temp.right != null) {
				Queue.offer(temp.right);
				nlast = temp.right;
			}
			if (temp == last) {
				last = nlast;
				res.add(t);
				t = new ArrayList<Integer>();
			}
		}
		for (int i = 0; i < res.size() / 2; i++) {
			List<Integer> tem = res.get(i);
			res.set(i, res.get(res.size() - 1 - i));
			res.set(res.size() - 1 - i, tem);
		}
		return res;
	}
}
