package medium;

import basicDataStructure.TreeNode;
import java.util.*;

/*
 * 2016.7.19
 * ���ö������������������ǵ�����ԭ��ֻҪ������n�����֣���ֹͣ�������б�����һ�����ּ��ɡ�
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
