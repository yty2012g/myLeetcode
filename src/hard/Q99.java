package hard;

import basicDataStructure.TreeNode;
import java.util.*;

/*
 * 2016.5.21
 * ���Ƕ�������������ķǵݹ���ʽ��Ӧ�á�
 * ������������������Ԫ�أ������ֿ��ܡ�
 * ����1��������Ԫ�����������������������
 * ����2��������Ԫ������������������в�����
 * ���ڿ���1����ô����������������У������һ�ε�ǰԪ��С��ǰһ��Ԫ�ص���������磺1��3��2��4��5.����2��3����
 * ���ڿ���2����ô����������������У���������ε�ǰԪ��С��ǰһ��Ԫ�ص���������磺5��2��3��4��1,����1��5����
 * �������һ�δ����򽫳����Ԫ�غ�ǰһ��Ԫ�ص�Ԫ��ֵ������
 * ����������δ���������Ԫ��Ϊ��һ�������Ԫ�ص�ǰһ��Ԫ�غ͵ڶ������Ԫ�أ�����ֵ���ɡ�
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
