package easy;

import java.util.*;

import basicDataStructure.TreeNode;

/*
 * 2016.7.22
 * 题目比较简单，典型的dfs应用。
 * 注意只有遍历到叶子节点时，再将结果增加至res
 */
public class Q257 {
	List<String> res = new ArrayList<String>();

	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null)
			return res;
		dfs(root, "");
		return res;
	}

	public void dfs(TreeNode root, String prefix) {
		if (root.left == null && root.right == null) {
			prefix += root.val;
			res.add(prefix);
			return;
		}
		if (root.left != null) {
			dfs(root.left, prefix + root.val + "->");
		}
		if (root.right != null) {
			dfs(root.right, prefix + root.val + "->");
		}
	}
}
