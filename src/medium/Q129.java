package medium;

import basicDataStructure.TreeNode;

/*
 * 2016.7.2
 * 这个题目就是典型的深度优先搜索。DFS
 * 这里写了两个版本的add函数，第一个版本是把String转换成int来做计算的。第二个是直接使用String做计算的。
 * 第二个其实通用性更强。但是要做String版本的加法就比较耗时。
 * sum方法就是DFS。如果当前结点的左右节点均为空，说明是叶子节点或者只有一个节点的树的根节点，此时将prefix加入全局变量和即可
 * 如果左右节点均不为空，则深度搜索，先计算左子树，再计算右子树。
 * 如果其中一个子节点为空，那么只需计算另外一颗子树即可。
 */
public class Q129 {
	int sum = 0;
	String sums = "0";

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		sum(root, "");
		return sum;
	}

	public void sum(TreeNode root, String prefix) {
		prefix = prefix + root.val;
		if (root.left == null && root.right == null) {
			sum = add(sum, prefix);
		} else {
			if (root.left != null && root.right != null) {
				sum(root.left, prefix);
				sum(root.right, prefix);
			} else if (root.left == null) {
				sum(root.right, prefix);
			} else {
				sum(root.left, prefix);
			}
		}
	}

	public int add(int a, String b) {
		return (a + Integer.parseInt(b));
	}

	public String add(String a, String b) {
		if (b.length() > a.length())
			return add(b, a);
		int jin = 0;
		String res = "";
		for (int i = a.length() - 1; i >= 0; i--) {
			int numb = 0;
			if (i - a.length() + b.length() >= 0)
				numb = b.charAt(i - a.length() + b.length()) - '0';
			int numa = a.charAt(i) - '0';
			int r = numa + numb + jin;
			if (r >= 10) {
				res = r - 10 + res;
				jin = 1;
			} else {
				res = r + res;
				jin = 0;
			}
		}
		if (jin == 1)
			res = "1" + res;
		return res;
	}
}
