package medium;

import basicDataStructure.TreeNode;
import java.util.*;

/*
 * 2016.7.22
 * �����Ŀ�û���union-find�ķ����ڴ����ݼ��޷�ͨ������Ϊ�ݹ���ȵ���������ȣ������������������ֶ�ջ�����
 * �����Ŀ���뷨�ܼ򵥣����p��q���ǶԷ��Ĺ������ȣ���ôһ���ֲ��ڹ������ȵ����ࡣ
 * ���ԣ�DFS�����������ǰ������p����q���򷵻ص�ǰ��㣬����dfs�������������������������������p����q������᷵��null����ʱ����null
 * ��������������ؽ��������null����˵����ǰ������p��q�Ĺ������ȡ�
 * �����������ֻ������p����q����ô���س��ֵĽڵ㡣
 */
public class Q236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root == p || root == q)
			return root;
		TreeNode L = lowestCommonAncestor(root.left, p, q);
		TreeNode R = lowestCommonAncestor(root.right, p, q);
		if (L != null && R != null)
			return root;
		return L != null ? L : R;
	}

}
