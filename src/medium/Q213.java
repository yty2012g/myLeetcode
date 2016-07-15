package medium;

/*
 * 2016.7.15
 * 和Q198类似，不同的是，这里的房子是环形结构，也就是第一个和最后一个不能同时抢。
 * 这里分成两种情况。
 * 情况1，抢第0间房子，那么第1间房子不能抢，dp[2]=dp[0]+nums[2]，然后除了最后一件房子，dp公式为
 *        dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]))。
 *        最后一间房子不能抢，所以dp[nums.length-1] = Math.max(dp[i - 1], dp[i - 2]);
 * 情况2，不抢第0间房子。所以dp[1]=nums[1]，但是第1间房子可以抢也可以不抢，所以dp[2]=Math.max(dp[1], nums[2]);
 *        然后剩下的房子都可以用上面的dp公式来计算。
 * 返回两种情况中，结果较大的那一个。
 */
public class Q213 {
	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		if (nums.length == 3)
			return Math.max(nums[0], Math.max(nums[1], nums[2]));
		if (nums.length == 4)
			return Math.max(nums[0] + nums[2], nums[1] + nums[3]);
		int[] dp = new int[nums.length];
		int max = 0;
		dp[0] = nums[0];
		dp[1] = dp[0];
		dp[2] = dp[1] + nums[2];
		for (int i = 3; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]));
			if (i == nums.length - 1) {
				dp[i] = Math.max(dp[i - 1], dp[i - 2]);
			}
		}
		max = Math.max(max, dp[nums.length - 1]);
		dp = new int[nums.length];
		dp[0] = 0;
		dp[1] = nums[1];
		dp[2] = Math.max(dp[1], nums[2]);
		for (int i = 3; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]));
		}
		max = Math.max(max, dp[nums.length - 1]);
		return max;
	}
}
