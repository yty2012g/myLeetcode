package easy;

import basicDataStructure.TreeNode;
import java.util.*;

/*
 * 2016.5.21
 * Ŀǰ�ķ����о��ܱ���
 * �����ò�������ķ�ʽȷ��ÿһ�㶼��Ԫ�ضԳƵģ������ܱ�֤�ṹ�Գơ�
 * Ȼ������������ķ�ʽ��֤��ÿһ��Ԫ�ضԳƵ�ǰ���£��ṹ�ǶԳƵġ�
 */
public class Q101 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		TreeNode nlast = null;
		TreeNode last = root;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			list.add(temp.val);
			if (temp.left != null) {
				queue.offer(temp.left);
				nlast = temp.left;
			}
			if (temp.right != null) {
				queue.offer(temp.right);
				nlast = temp.right;
			}
			if (temp == last) {
				last = nlast;
				if (!check(list))
					return false;
				list = new ArrayList<Integer>();
			}
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		TreeNode cur = root;
		while (cur != null || !stack.empty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode temp = stack.pop();
				res.add(temp.val);
				cur = temp.right;
			}
		}
		return check(res);
	}

	public boolean check(ArrayList<Integer> list) {
		if (list.size() == 0 || list.size() == 1)
			return true;
		for (int i = 0; i < list.size() / 2; i++) {
			if (list.get(i) != list.get(list.size() - i - 1))
				return false;
		}
		return true;
	}
}
