package medium;

import basicDataStructure.TreeNode;
import java.util.*;

/*
 * 2016.7.4
 * 非递归方法的先序遍历。
 * 利用stack。每次先放入右节点，再放入左节点。每次弹出一个节点，并记录节点值。
 */
public class Q144 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode temp = stack.pop();
			res.add(temp.val);
			if (temp.right != null) {
				stack.push(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
		return res;
	}
}
