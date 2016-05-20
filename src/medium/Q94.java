package medium;

import basicDataStructure.TreeNode;
import java.util.*;

/*
 * 2016.5.20
 * �ǵݹ�Ķ��������������
 * ʹ��һ��cur����ǰ�Ľڵ㣬һ��ʼ��cur����root�ڵ㡣
 * ʹ��һ��ջ��
 * ���cur������null����curѹ��ջ�У�cur����cur.left
 * ���cur����null����ջ����¼��cur���ڵ����Ľڵ���ҽڵ㡣
 * ��ֹ������ջΪ��ͬʱcurΪ��
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
