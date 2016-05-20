package medium;

import basicDataStructure.TreeNode;
import java.util.*;

/*
 * 2016.5.20
 * 非递归的二叉树中序遍历。
 * 使用一个cur代表当前的节点，一开始令cur等于root节点。
 * 使用一个栈。
 * 如果cur不等于null，则将cur压入栈中，cur等于cur.left
 * 如果cur等于null，弹栈并记录，cur等于弹出的节点的右节点。
 * 终止条件是栈为空同时cur为空
 */
public class Q94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		if (root.left == null && root.right == null) {
			res.add(root.val);
			return res;
		}
		TreeNode cur = root;
		while (!stack.empty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode temp = stack.pop();
				res.add(temp.val);
				cur = temp.right;
			}
		}
		return res;
	}
}
