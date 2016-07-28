package easy;
/*
 * 2016.7.28
 * 这里利用了dp的思想。
 * dp[i]代表，从[0..i-1]的和。
 * 所以如果求a到b的和，记为dp[b+1]-dp[a]。
 */
public class Q303 {
	public class NumArray {
		int[] dp;

		public NumArray(int[] nums) {
			dp = new int[nums.length + 1];
			dp[0] = 0;
			for (int i = 1; i <= nums.length; i++) {
				dp[i] = dp[i - 1] + nums[i - 1];
			}
		}

		public int sumRange(int i, int j) {
			return dp[j + 1] - dp[i];
		}
	}
}
