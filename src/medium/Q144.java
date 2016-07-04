package medium;

import basicDataStructure.TreeNode;
import java.util.*;

/*
 * 2016.7.4
 * �ǵݹ鷽�������������
 * ����stack��ÿ���ȷ����ҽڵ㣬�ٷ�����ڵ㡣ÿ�ε���һ���ڵ㣬����¼�ڵ�ֵ��
 */
public class Q144 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode temp = stack.pop();
			res.add(temp.val);
			if (temp.right != null) {
				stack.push(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
		return res;
	}
}
