package medium;

/*
 * 2016.5.8
 * 应用两次二分搜索
 * 对于范围的头边界而言，头边界对应的下标i，一定符合nums[i]==target,nums[i-1]<target,在i>0的情况下
 * 同样的，尾边界也是这样，nums[i]==target,nums[i+1]>target，在i<nums.length-1的情况下。
 * 最后就是总体的边界问题，如果i等于数组的头或者尾的处理方法。
 */
public class Q34 {
	public int[] searchRange(int[] nums, int target) {
		int si = findsmall(nums, target);
		int bi = findbig(nums, target);
		int[] res = { si, bi };
		return res;
	}

	public int findsmall(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int num = (start + end) / 2;
			if (nums[num] == target) {
				if (num == 0 || nums[num - 1] < target)
					return num;
				if (nums[num - 1] == target)
					end = num - 1;
				continue;
			}
			if (nums[num] > target) {
				end = num - 1;
			} else {
				start = num + 1;
			}
		}
		return -1;
	}

	public int findbig(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int num = (start + end) / 2;
			if (nums[num] == target) {
				if (num == nums.length - 1 || nums[num + 1] > target)
					return num;
				if (nums[num + 1] == target)
					start = num + 1;
				continue;
			}
			if (nums[num] > target) {
				end = num - 1;
			} else {
				start = num + 1;
			}
		}
		return -1;
	}
}
