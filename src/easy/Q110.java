package easy;

import basicDataStructure.TreeNode;
import java.util.*;
/*
 * 2016.5.25
 * 平衡二叉树，定义如下：
 * 空树是一颗平衡二叉树
 * 左子树是一颗平衡二叉树，右子树也是一颗平衡二叉树，同时左子树的高度和右子树的高度的差值的绝对值小于等于1.
 * 按照定义判断即可。
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
