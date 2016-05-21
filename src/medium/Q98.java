package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import basicDataStructure.TreeNode;

/*
 * 2016.5.21
 * ���ö����������������ǵ������е�ԭ��
 * ÿһ��ʹ��old��¼��һ�ν������������µ�Ԫ��С�ڵ���old�����ǵ������У�����false
 * �����Ĺ������÷ǵݹ���ʽ�����������
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
