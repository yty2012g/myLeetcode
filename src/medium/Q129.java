package medium;

import basicDataStructure.TreeNode;

/*
 * 2016.7.2
 * �����Ŀ���ǵ��͵��������������DFS
 * ����д�������汾��add��������һ���汾�ǰ�Stringת����int��������ġ��ڶ�����ֱ��ʹ��String������ġ�
 * �ڶ�����ʵͨ���Ը�ǿ������Ҫ��String�汾�ļӷ��ͱȽϺ�ʱ��
 * sum��������DFS�������ǰ�������ҽڵ��Ϊ�գ�˵����Ҷ�ӽڵ����ֻ��һ���ڵ�����ĸ��ڵ㣬��ʱ��prefix����ȫ�ֱ����ͼ���
 * ������ҽڵ����Ϊ�գ�������������ȼ������������ټ�����������
 * �������һ���ӽڵ�Ϊ�գ���ôֻ���������һ���������ɡ�
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
