package medium;

/*
 * 2016.7.6
 * 这道题目还是很明确的，但是没有搞定时间复杂度为O(lgN)的方法，个人感觉应该是要用二分搜索。
 * 目前的做法就是遍历所有元素，找到符合要求的元素。
 * 其实，用二分搜索也不一定能保证都在O(lgN)内，应该是平均时间复杂度。
 */
public class Q162 {
	public int findPeakElement(int[] nums) {
		if (nums.length == 1)
			return 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				if (nums[i] > nums[i + 1])
					return i;
			} else if (i == nums.length - 1) {
				if (nums[i] > nums[i - 1])
					return i;
			} else {
				if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
					return i;
			}
		}
		return 0;
	}
}
