package easy;

import java.util.*;

import basicDataStructure.TreeNode;

/*
 * 2016.7.22
 * ��Ŀ�Ƚϼ򵥣����͵�dfsӦ�á�
 * ע��ֻ�б�����Ҷ�ӽڵ�ʱ���ٽ����������res
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
