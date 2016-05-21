package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import basicDataStructure.TreeNode;

/*
 * 2016.5.21
 * 利用二叉查找树中序遍历是递增序列的原理。
 * 每一次使用old记录上一次结果，如果出现新的元素小于等于old，则不是递增序列，返回false
 * 遍历的过程利用非递归形式的中序遍历。
 */
public class Q98 {
	public boolean isValidBST(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int old = -1;
		TreeNode cur = root;
		while (cur != null || !stack.empty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode temp = stack.pop();
				if (old != -1 && temp.val <= old) {
					return false;
				} else {
					old = temp.val;
				}
				cur = temp.right;
			}
		}
		return true;
	}
}
