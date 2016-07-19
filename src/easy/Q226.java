package easy;

import basicDataStructure.TreeNode;

/*
 * 2016.7.19
 * ����Ŀûɶ˵�ģ��������root��null��ֱ�ӷ��ء�
 * �����ȵ���root�������ӽڵ㣬Ȼ��ֱ�������ӽڵ�ʹ��invertTree������
 */
public class Q226 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode l = root.left;
		TreeNode r = root.right;
		root.right = l;
		root.left = r;
		invertTree(root.right);
		invertTree(root.left);
		return root;
	}
}
