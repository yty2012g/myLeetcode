package hard;

import java.util.HashMap;

import basicDataStructure.TreeNode;

/*
 * 2016.7.2
 * ���ǵ��ڵ�ֵ�Ǹ��������������ڵ�Ϊ�գ��򷵻���С�ĸ�����
 * maxPath��������root���µ����ߵ����͡�
 * ���1��root������е��Ϊ��������ôֱ�ӷ���root��valֵ
 * ���2��root����ڵ�ĵ��ߺͺ��ҽڵ�ĵ��ߺͶ�Ϊ��������Ϊ���ҽڵ�ĵ��ߺ�֮���ټ���root��val��
 * ���3��root�ڵ�ĵ��ߺ͡�
 */
public class Q124 {
	HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0x7fffffff + 1;
		int m = Math.max(root.val, Math.max(maxPath(root), maxPath(root.left) + maxPath(root.right) + root.val));
		return Math.max(Math.max(maxPathSum(root.left), maxPathSum(root.right)), m);
	}

	public int maxPath(TreeNode root) {
		if (root == null)
			return 0;
		if (map.get(root) == null)
			map.put(root, Math.max(root.val, Math.max(maxPath(root.left), maxPath(root.right)) + root.val));
		return map.get(root);
	}

}
