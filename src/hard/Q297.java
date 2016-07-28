package hard;

import basicDataStructure.TreeNode;
import java.util.*;

public class Q297 {
	public String serialize(TreeNode root) {
		String res = "";
		if (root == null)
			return "null";
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (stack != null || cur != null) {
			if (cur != null) {
				stack.push(cur);
				res += cur.val;
				res += ",";
				cur = cur.left;
				res += "l,";
			} else {
				TreeNode temp = stack.pop();
				res += null;
				res += ",";
				res += "r,";
				cur = temp.right;
			}
		}
		return res;
	}
	public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			String res = "";
			if (root == null)
				return "null";
			Stack<TreeNode> stack = new Stack<TreeNode>();
			TreeNode cur = root;
			while (stack != null || cur != null) {
				if (cur != null) {
					stack.push(cur);
					res += cur.val;
					res += ",";
					cur = cur.left;
					res += "l,";
				} else {
					TreeNode temp = stack.pop();
					res += null;
					res += ",";
					res += "r,";
					cur = temp.right;
				}
			}
			return res;
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			return null;
		}
	}
}
