package easy;

import basicDataStructure.TreeNode;
import java.util.*;
/*
 * 2016.5.25
 * ƽ����������������£�
 * ������һ��ƽ�������
 * ��������һ��ƽ���������������Ҳ��һ��ƽ���������ͬʱ�������ĸ߶Ⱥ��������ĸ߶ȵĲ�ֵ�ľ���ֵС�ڵ���1.
 * ���ն����жϼ��ɡ�
 */
public class Q110 {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return ( Math.abs(getH(root.left) - getH(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right));
	}

	public int getH(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(getH(root.left), getH(root.right)) + 1;
	}
}
