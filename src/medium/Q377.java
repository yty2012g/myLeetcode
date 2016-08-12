package medium;

/*
 * 2016.8.12
 * dp[i]表示当和为i的时候有多少种组合。
 * dp[i]=dp[i-nums[k]]{k=0...k.length-1}
 * 这个意思是，每次只确定最后一个数。
 * 例如当k等于1的时候，表示整个序列最后一个数字是1，然后之前的和是i-1，所以只要知道之前的次数，那么最后一位是1的次数也就知道了。
 * 
 */

public class Q377 {
	public int combinationSum4(int[] nums, int target) {
		int dp[] = new int[target + 1];
		for (int i = 0; i <= target; i++) {
			for (int k = 0; k < nums.length; k++) {
				if (i - nums[k] > 0) {
					dp[i] += dp[i - nums[k]];
				} else if (i - nums[k] == 0) {
					dp[i] += 1;
				}

			}
		}
		return dp[target];
	}
}
