package medium;

import java.util.*;

/*
 * 2016.8.9
 * �ֶ�����˼�롣��ʵ�Ͷ�������������Ƶġ�
 * ���ȸ��ڵ�ķ�Χ��0��N-1��Ȼ����һ��ֵ
 * ���ӽڵ�ķ�Χ��start, (start + end) >> 1�����ӽڵ�ķ�Χ�� ((start + end) >> 1) + 1, end
 * ���Եݹ�����һ���ֶ������ڵ�Ϊ2N-1
 * ���µ�ʱ�򣬲�ȡ�ݹ�ķ�����ʱ�临�Ӷ�logN��
 * ���ҵ�ʱ�򣬵ݹ�ķ�����ʱ�临�Ӷ�logN��
 */
public class Q307 {
	public class NumArray {
		public class node {
			public int start = 0;
			public int end = 0;
			public int value = 0;
			public node left = null;
			public node right = null;
		}

		public boolean flag = true;
		public node root = null;
		public int[] nums;

		public NumArray(int[] nums) {
			this.nums = nums;
			if (nums.length == 0) {
				flag = false;
				return;
			}
			this.root = init(nums, 0, nums.length - 1);
		}

		public node init(int[] nums, int start, int end) {
			node n = new node();
			n.start = start;
			n.end = end;
			if (start == end) {
				n.value = nums[start];
				return n;
			}
			node left = init(nums, start, (start + end) >> 1);
			node right = init(nums, ((start + end) >> 1) + 1, end);
			n.left = left;
			n.right = right;
			n.value = left.value + right.value;
			return n;
		}

		void update(int i, int val) {
			if (!flag)
				return;
			update(i, val, root);
		}

		void update(int i, int val, node root) {
			int cha = val - nums[i];
			root.value += cha;
			if (root.start == root.end) {
				nums[i] = val;
				return;
			}
			if (i <= ((root.start + root.end) >> 1)) {
				update(i, val, root.left);
			} else {
				update(i, val, root.right);
			}
		}

		public int sumRange(int i, int j) {
			if (!flag)
				return 0;
			return sumRange(i, j, root);
		}

		public int sumRange(int i, int j, node root) {
			if (i == root.start && j == root.end) {
				return root.value;
			} else if (j <= ((root.start + root.end) >> 1)) {
				return sumRange(i, j, root.left);
			} else if (i > ((root.start + root.end) >> 1)) {
				return sumRange(i, j, root.right);
			} else {
				return sumRange(i, ((root.start + root.end) >> 1), root.left)
						+ sumRange(((root.start + root.end) >> 1) + 1, j, root.right);
			}
		}
	}
}
// public class NumArray {
// public int dp[];
// boolean flag = true;
// HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(5000);
//
// public NumArray(int[] nums) {
// dp = new int[nums.length];
// if (dp.length == 0) {
// flag = false;
// return;
// }
// dp[0] = nums[0];
// for (int i = 1; i < nums.length; i++) {
// dp[i] = dp[i - 1] + nums[i];
// }
// }
//
// void update(int i, int val) {
// if (!flag)
// return;
// int cha = i != 0 ? val - (dp[i] - dp[i - 1]) : val - dp[i];
// map.put(i, cha);
// }
//
// public int sumRange(int i, int j) {
// if (!flag)
// return 0;
// int base = i == 0 ? dp[j] : dp[j] - dp[i - 1];
// Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
// while (iter.hasNext()) {
// Map.Entry<Integer, Integer> entry = iter.next();
// int k = entry.getKey();
// int v = entry.getValue();
// if (k >= i && k <= j)
// base = base + v;
// }
// return base;
// }
// }