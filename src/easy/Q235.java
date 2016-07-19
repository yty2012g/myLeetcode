package easy;

import basicDataStructure.TreeNode;

/*
 * 2016.7.19
 * ���ȱ�֤p��ֵ��q��ֵҪС��
 * ��cur����root��
 * ���cur���ڵ���p��ֵͬʱС�ڵ���q��ֵ����cur��Ϊ�����
 * ���q��ֵ����cur��ֵ����ôcurת�����ӽڵ㡣
 * ���p��ֵ����cur��ֵ����ôcurת�����ӽڵ㡣
 */
public class Q235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val > q.val)
			return lowestCommonAncestor(root, q, p);
		TreeNode cur = root;
		while (true) {
			if (cur.val >= p.val && cur.val <= q.val)
				return cur;
			if (q.val < cur.val)
				cur = cur.left;
			if (p.val > cur.val)
				cur = cur.right;
		}
	}
}
