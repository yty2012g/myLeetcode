package medium;

import basicDataStructure.TreeNode;
import java.util.*;

/*
 * 2016.7.19
 * 利用二叉查找树的中序遍历是递增的原理，只要遍历了n个数字，就停止，返回列表的最后一个数字即可。
 */
public class Q230 {
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode temp = stack.pop();
				list.add(temp.val);
				cur = temp.right;
				if (list.size() == k)
					break;
			}
		}
		return list.get(list.size() - 1);
	}
}
