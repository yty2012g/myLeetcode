package easy;

import java.util.*;

import basicDataStructure.TreeNode;

/*
 * 2016.5.21
 * ���������ʹ��nlast��last����������nlastָ��ǰ�д���Ľڵ㡣nlast��ʾ��һ�е����ҽڵ�
 * ���Ƚ�root������С���last=root��
 * ÿ�ε���һ��Ԫ�أ����Ԫ�ص���ڵ�ǿգ�������У�nlast������ڵ㣬�ҽڵ�ǿգ�������У�nlast�����ҽڵ㡣
 * ��������Ľڵ����last����last����nlast������˵�ǰ�е����ҽڵ㣬Ȼ�󽫵�ǰ�б����ڽ���С�����������һ�С�
 */
public class Q102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null)
			return res;
		TreeNode last = root;
		TreeNode nlast = null;
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
				res.add((List<Integer>) list.clone());
				list = new ArrayList<Integer>();
			}
		}
		return res;
	}
}
