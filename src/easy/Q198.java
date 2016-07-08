package easy;

/*
 * 2016.7.8
 * 动态规划问题。问题的模型是，从一个非负数组中抽取一个或多个不相邻的数字，其和最大。
 * dp[i]=max(max(dp[i-1],dp[i-2]+nums[i]),dp[i-3])   当i>=3时。
 * 首先dp[i]表示以第i位为结尾的不连续元素的最大和。
 * 如果选择了nums[i]之前最大和可能是dp[i-2]也可能是dp[i-3]，为什么不可能是更前的呢？因为dp[i-3]之前是可以选择nums[i-1],而每个元素都是非负的
 * 所以之前的最大和最多只能到dp[i-3].
 * 当然，还有可能不选择nums[i]，那么之前的最大和就是dp[i-1]了。所以三个去max即可。
 */
public class Q198 {
	public int rob(int[] nums) {
		int[] dp = new int[nums.length];
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		if (nums.length == 3) {
			return Math.max(nums[1], nums[0] + nums[2]);
		}
		if (nums.length == 4) {
			return Math.max(nums[0] + nums[3], Math.max(nums[0] + nums[2], nums[1] + nums[3]));
		}
		dp[0] = nums[0];
		dp[1] = nums[1];
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
			if (i >= 3) {
				dp[i] = Math.max(dp[i], dp[i - 3] + nums[i]);
			}
		}
		return dp[nums.length - 1];
	}
}
