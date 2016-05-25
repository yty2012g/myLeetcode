package medium;

import java.util.Arrays;

import basicDataStructure.TreeNode;

/*
 * 2016.5.25
 * ����һ������ƣ���������ͺ�����������Ľṹ
 * ��������������У���˸��ڵ������һ��Ԫ�ء�
 * Ȼ�����105���������ݹ����������������������ɡ�
 */
public class Q106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0)
			return null;
		return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	public TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
		if (ps == pe)
			return new TreeNode(postorder[ps]);
		TreeNode root = new TreeNode(postorder[pe]);
		int flag = 0;
		for (int i = is; i <= ie; i++) {
			if (inorder[i] == postorder[pe]) {
				flag = i;
				break;
			}
		}
		TreeNode left = null;
		TreeNode right = null;
		if (flag != is) {
			left = build(inorder, is, flag - 1, postorder, ps, ps + flag - is - 1);
		}
		if (flag != ie) {
			right = build(inorder, flag + 1, ie, postorder, ps + flag - is, pe - 1);
		}
		root.left = left;
		root.right = right;
		return root;
	}
}
