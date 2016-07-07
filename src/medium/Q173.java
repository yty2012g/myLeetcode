package medium;

import basicDataStructure.TreeNode;
import java.util.*;

/*
 * 2016.7.7
 * 在构造函数中，使用了二叉树非递归形式的中序遍历。得到了一个arraylist。
 * 由于BST的中序遍历结果是递增的。所以使用cur指针指向最小的元素。
 * hasNext方法，判断cur是否在list下标内。
 * next方法，首先得到最小值，cur自增指向下一个最小值，然后返回最小值即可。
 */
public class Q173 {
	public class BSTIterator {
		public ArrayList<Integer> list;
		public int cur;

		public BSTIterator(TreeNode root) {
			this.list = new ArrayList<Integer>();
			this.cur = 0;
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode c = root;
			while (c != null || !stack.empty()) {
				if (c != null) {
					stack.push(c);
					c = c.left;
				} else {
					c = stack.pop();
					list.add(c.val);
					c = c.right;
				}
			}
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return cur < list.size();
		}

		/** @return the next smallest number */
		public int next() {
			int res = list.get(cur);
			cur++;
			return res;
		}
	}
}
