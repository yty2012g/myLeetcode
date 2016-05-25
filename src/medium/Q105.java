package medium;

import basicDataStructure.TreeNode;

/*
 *2016.5.25
 *������Ǹ���������������������������Ľṹ
 *��������������ң���������������ҡ�
 *�����������ĵ�һ��Ԫ�ؾ��ǵ�ǰ����ͷ�ڵ㣬���ڲ������ظ������֣�������������ҵ�ͷ�ڵ��Ӧ��λ�ã���벿�������������Ұ벿����������
 *Ȼ��ݹ�����������������ɡ� 
 */
public class Q105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	public TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
		if (pe - ps == 0)
			return new TreeNode(preorder[ps]);
		TreeNode root = new TreeNode(preorder[ps]);
		int flag = 0;
		for (int i = is; i <= ie; i++) {
			if (inorder[i] == root.val) {
				flag = i;
				break;
			}
		}
		TreeNode left = null;
		TreeNode right = null;
		if (flag == is) {
			left = null;
		} else {
			left = build(preorder, ps + 1, ps + flag - is, inorder, is, flag - 1);
		}
		if (flag == ie) {
			right = null;
		} else {
			right = build(preorder, ps + flag - is + 1, pe, inorder, flag + 1, ie);
		}
		root.left = left;
		root.right = right;
		return root;
	}
}
