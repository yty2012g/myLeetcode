package easy;

import basicDataStructure.TreeNode;

/*
 * 2016.5.25
 * ���������
 * 1.�սڵ㣬false��
 * 2.Ҷ�ӽ�㣬�Ƚϵ�ǰֵ�͵�ǰsum��ֵ�����true������false��
 * 3����������ӽڵ㶼��Ϊ�գ���������������������һ�����Ծ��С�
 * 4�������һ������Ϊ�գ���ֻ������һ���������㡣
 */
public class Q112 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) {
			return sum == root.val;
		}
		if (root.left != null && root.right != null) {
			return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
		}
		if (root.left == null)
			return hasPathSum(root.right, sum - root.val);
		else
			return hasPathSum(root.left, sum - root.val);
	}
}
