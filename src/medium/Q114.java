package medium;

import java.util.*;

import basicDataStructure.TreeNode;

/*
 * 2016.5.25
 * 非递归形式的先序遍历。
 * 使用roots记录新的链表。
 */
public class Q114 {
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		TreeNode roots = new TreeNode(0);
		TreeNode copy = roots;
		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(cur);
		while (!stack.empty()) {
			TreeNode temp = stack.pop();
			copy.right = temp;
			copy.left = null;
			copy = copy.right;
			if (temp.right != null)
				stack.push(temp.right);
			if (temp.left != null)
				stack.push(temp.left);
		}
		copy.left = null;
		copy.right = null;
		root = roots.right;
	}
}
