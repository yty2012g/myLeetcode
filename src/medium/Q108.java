package medium;

import java.util.*;

import basicDataStructure.TreeNode;

public class Q108 {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0)
			return null;
		return build(nums, 0, nums.length - 1);
	}

	public TreeNode build(int[] nums, int start, int end) {
		int num = end - start + 1;
		if (num == 1)
			return new TreeNode(nums[start]);
		else if (num == 2) {
			TreeNode root = new TreeNode(nums[start]);
			TreeNode right = new TreeNode(nums[end]);
			root.right = right;
			return root;
		} else if (num == 3) {
			TreeNode root = new TreeNode(nums[start + 1]);
			TreeNode left = new TreeNode(nums[start]);
			TreeNode right = new TreeNode(nums[end]);
			root.left = left;
			root.right = right;
			return root;
		}
		int wei = Integer.toBinaryString(num).length();
		if (num == (int) Math.pow(2, wei) - 1) {
			TreeNode root = new TreeNode(nums[num / 2]);
			TreeNode left = build(nums, start, num / 2 - 1);
			TreeNode right = build(nums, num / 2 + 1, end);
			root.left = left;
			root.right = right;
			return root;
		} else {
			if (num - (int) Math.pow(2, wei - 1) + 1 == (int) Math.pow(2, wei) - 1 - num) {
				TreeNode root = new TreeNode(nums[end - (int) Math.pow(2, wei - 2) + 1]);
				TreeNode left = build(nums, start, start + (int) Math.pow(2, wei - 1) - 2);
				TreeNode right = build(nums, end - (int) Math.pow(2, wei - 2) + 2, end);
				root.left = left;
				root.right = right;
				return root;
			} else if (num - (int) Math.pow(2, wei - 1) + 1 < (int) Math.pow(2, wei) - 1 - num) {
				TreeNode root = new TreeNode(nums[end - (int) Math.pow(2, wei - 2) + 1]);
				TreeNode left = build(nums, start, end - (int) Math.pow(2, wei - 2));
				TreeNode right = build(nums, end - (int) Math.pow(2, wei - 2) + 2, end);
				root.left = left;
				root.right = right;
				return root;
			} else {
				TreeNode root = new TreeNode(nums[start + (int) Math.pow(2, wei - 1) - 1]);
				TreeNode left = build(nums, start, start + (int) Math.pow(2, wei - 1) - 2);
				TreeNode right = build(nums, start + (int) Math.pow(2, wei - 1), end);
				root.left = left;
				root.right = right;
				return root;
			}
		}
	}
}
