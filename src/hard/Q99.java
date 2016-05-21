package hard;

import basicDataStructure.TreeNode;
import java.util.*;

/*
 * 2016.5.21
 * 还是二叉树中序遍历的非递归形式的应用。
 * 如果其中有两个错误的元素，有两种可能。
 * 可能1，这两个元素在中序遍历的序列中相邻
 * 可能2，这两个元素在中序遍历的序列中不相邻
 * 对于可能1，那么在中序遍历的序列中，会出现一次当前元素小于前一个元素的情况，例如：1，3，2，4，5.其中2和3错误。
 * 对于可能2，那么在中序遍历的序列中，会出现两次当前元素小于前一个元素的情况，例如：5，2，3，4，1,其中1和5错误。
 * 如果出现一次错误，则将出错的元素和前一个元素的元素值交换。
 * 如果出现两次错误，则出错的元素为第一个错误的元素的前一个元素和第二错误的元素，交换值即可。
 */
public class Q99 {
	public void recoverTree(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		TreeNode old = null;
		int times = 0;
		TreeNode prev = new TreeNode(0);
		TreeNode first = new TreeNode(0);
		TreeNode second = new TreeNode(0);
		while (cur != null || !stack.empty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode temp = stack.pop();
				if (old != null && temp.val < old.val) {
					if (times == 0) {
						times++;
						prev = old;
						first = temp;
					} else {
						times++;
						second = temp;
						break;
					}
				}
				old = temp;
				cur = temp.right;
			}
		}
		if (times == 1) {
			int temp = prev.val;
			prev.val = first.val;
			first.val = temp;
		} else {
			int temp = second.val;
			second.val = prev.val;
			prev.val = temp;
		}
	}
}
