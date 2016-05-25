package easy;

import java.util.*;

import basicDataStructure.TreeNode;

/*
 * 2016.5.25
 * ���ò�����������һ���ڵ�ͬʱû�������ӽڵ㣬˵���ýڵ�ΪҶ�ӽڵ㣬��¼�ýڵ�Ĳ������ɡ�
 */
public class Q111 {
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int height = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode last = root, nlast = root;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp.left == null && temp.right == null) {
				break;
			}
			if (temp.left != null) {
				queue.offer(temp.left);
				nlast = temp.left;
			}
			if (temp.right != null) {
				queue.offer(temp.right);
				nlast = temp.right;
			}
			if (temp == last) {
				height++;
				last = nlast;
			}
		}
		return height + 1;
	}
}
