package medium;

import basicDataStructure.TreeNode;

/*
 * 2016.7.18
 * ����������Ӧ�á�
 * ����һ����ȫ���������ԣ�ͳ�ƽڵ���Ŀ�ǿ���ͨ�����������Ľڵ���Ŀ���㷽��������ġ�
 * �������һ��ͣ�µĵ㳬����һ�룬��ô����root���ԣ�root����������һ���������������нڵ���Ŀ����2^h-1��hΪ������
 * ��֮��root��������������������Ȼ���ټ������������ɡ�
 * �����Сtips����������2���ݴβ�Ҫ��pow����ֱ�������ơ��ٶȿ�ķ��𡣡�
 */
public class Q222 {
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		TreeNode cur = root.left;
		TreeNode curR = root.right;
		if (cur == null)
			return 1;
		int l = 0;
		int r = 0;
		while (cur != null && curR != null) {
			cur = cur.left;
			l++;
			curR = curR.left;
			r++;
		}
		if (cur == null && curR == null) {
			return (1 << l) + countNodes(root.right);
		} else {
			return (1 << r) + countNodes(root.left);
		}
	}
}
