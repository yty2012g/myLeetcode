package hard;

import java.util.Arrays;

/*
 * 2016.7.6
 * ֱ�ӵ���sort������ʱ�临�Ӷ�nlgn������ֻҪ4ms
 */
public class Q164 {
	public int maximumGap(int[] nums) {
		Arrays.sort(nums);
		int max = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			max = Math.max(max, nums[i + 1] - nums[i]);
		}
		return max;
	}
}
