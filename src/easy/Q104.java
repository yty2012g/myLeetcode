package easy;

/*
 * 2016.5.21
 * �������ݹ�����������ǰ���Ϊnull�ڵ㣬�߶�Ϊ0���������null����Ϊ���������������и߶Ƚϴ�ļ�1
 */

import basicDataStructure.TreeNode;

public class Q104 {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.min(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
