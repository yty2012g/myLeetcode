package easy;

import basicDataStructure.TreeNode;
/*
 * 2016.5.21
 * ˼·�Ƚϼ򵥣���������ڵ㶼��null����ȣ�ֻ��һ����null������ȣ�����������null�����ҽ���Ԫ��ֵ��ͬ��������������������ȡ�
 * �ݹ��������ˡ�
 */

public class Q100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if ((p == null && q != null) || (q == null && p != null))
			return false;
		if (isSameTree(p.left, q.left) && (p.val == q.val) && isSameTree(p.right, q.right))
			return true;
		return false;
	}
}
