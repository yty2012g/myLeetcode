package medium;

import java.util.Arrays;

/*
 * 2016.5.4
 * 和3sum比较类似，第一步排序
 * 第二步，固定第一个数字，然后仿照2sum的方式找。如果找到两个数字和恰好等于剩余的target，则返回target即可
 * 否则，找到与target的差值的绝对值较小的组合，每次固定的第一个数字可以找到一个绝对值最小的差值。
 * 第三个要点，如果这个剩余target比最大的两个数大或者比最小的两个数小，则直接返回差值即可。
 */
public class Q16 {
	public int threeSumClosest(int[] nums, int target) {
		int min = 0;
		boolean flag = false;
		int len = nums.length;
		int start = 0;
		int end = 0;
		Arrays.sort(nums);
		for (int i = 0; i < len - 2; i++) {
			start = i + 1;
			end = len - 1;
			int smalltarget = target - nums[i];
			int tempmin = 0;
			boolean tempflag = false;
			if (nums[end] + nums[end - 1] < smalltarget) {
				tempmin = nums[end] + nums[end - 1] - smalltarget;
				tempflag = true;
			} else if (nums[start] + nums[start + 1] > smalltarget) {
				tempmin = nums[start] + nums[start + 1] - smalltarget;
				tempflag = true;
			} else {
				while (start < end) {
					if (nums[start] + nums[end] != smalltarget) {
						if (tempflag) {
							tempmin = Math.abs(tempmin) < Math.abs(nums[start] + nums[end] - smalltarget) ? tempmin
									: nums[start] + nums[end] - smalltarget;
						} else {
							tempmin = nums[start] + nums[end] - smalltarget;
							tempflag = true;
						}
						if (nums[start] + nums[end] > smalltarget)
							end--;
						else
							start++;
					} else {
						return target;
					}
				}
			}
			if (flag) {
				min = Math.abs(min) < Math.abs(tempmin) ? min : tempmin;
			} else {
				min = tempmin;
				flag = true;
			}
		}
		return target + min;
	}
}
