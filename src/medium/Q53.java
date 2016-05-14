package medium;

/*
 * 2016.5.14
 * 和最大的子数组问题。
 * 使用动态规划解决，dp方程为dp[i] = nums[i] > dp[i - 1] + nums[i] ? nums[i] : dp[i - 1] + nums[i];
 * 如果第i个数大于以第i-1个数为结尾的和最大的子数组的和，那么以第i个数字为结尾的和最大的子数组就是第i个数本身
 * 否则就是将第i个数加入以第i-1个数为结尾的和最大的子数组最后。
 * 使用max变量记录最大的和。
 */
public class Q53 {
	public int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		int max = nums[0];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = nums[i] > dp[i - 1] + nums[i] ? nums[i] : dp[i - 1] + nums[i];
			max = max > dp[i] ? max : dp[i];
		}
		return max;
	}
}
