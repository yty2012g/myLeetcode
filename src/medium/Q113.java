package medium;

import java.util.*;
import basicDataStructure.*;

/*
 * 2016.5.25
 * 仿照上一题的思路，分成四种情况，然后深度优先遍历即可。
 */
public class Q113 {
	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		path(root, sum, temp);
		return res;
	}

	public void path(TreeNode root, int sum, ArrayList<Integer> temp) {
		if (root == null)
			return;
		@SuppressWarnings("unchecked")
		ArrayList<Integer> copy = (ArrayList<Integer>) temp.clone();
		if (root.left == null && root.right == null) {
			if (root.val == sum) {
				copy.add(sum);
				res.add(copy);
				return;
			} else {
				return;
			}
		}
		if (root.left != null && root.right != null) {
			copy.add(root.val);
			path(root.left, sum - root.val, copy);
			path(root.right, sum - root.val, copy);
			return;
		}
		if (root.left != null) {
			copy.add(root.val);
			path(root.left, sum - root.val, copy);
		} else {
			copy.add(root.val);
			path(root.right, sum - root.val, copy);
		}
	}
}
