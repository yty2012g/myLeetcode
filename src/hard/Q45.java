package hard;

import java.util.*;

public class Q45 {
	public int jump(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 1; j <= nums[i]; j++) {
				if (i + j < nums.length) {
					dp[i + j] = dp[i + j] == 0 ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + j]);
				}
			}
		}
		return dp[nums.length - 1];
	}
}
