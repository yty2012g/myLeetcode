package medium;

/*
 * 2016.5.17
 * 简单的二分搜索，首先找到分界点，然后对分界点的两边进行搜索
 * 由于不能并行，所以一定是先检查一边，再检查另一边。
 * 一个简单的优化剪枝就是，如果一边已经检查出来有结果了，另一边就没有必要检查了。
 */
public class Q81 {
	public boolean search(int[] nums, int target) {
		if (nums.length == 0)
			return false;
		if (nums.length == 1)
			return nums[0] == target ? true : false;
		int num = du(nums);
		int beforestart = 0;
		int beforeend = num - 1;
		int afterstart = num;
		int afterend = nums.length - 1;
		int bres = find(nums, target, beforestart, beforeend);
		if (bres != -1)
			return true;
		int ares = find(nums, target, afterstart, afterend);
		if (ares != -1)
			return true;
		return false;
	}

	public int find(int[] nums, int target, int start, int end) {
		int res = -1;
		while (start <= end) {
			if (nums[(end + start) / 2] == target) {
				return (end + start) / 2;
			} else if (nums[(end + start) / 2] > target) {
				end = (end + start) / 2 - 1;
			} else {
				start = (end + start) / 2 + 1;
			}
		}
		return res;
	}

	public int du(int[] nums) {
		int dp = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				dp = i;
				break;
			}
		}
		return dp;
	}
}
