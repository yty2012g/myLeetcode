package easy;

/*
 * 2016.5.15
 * 典型的动态规划问题。
 * dp[i] = dp[i - 1] + dp[i - 2];
 * dp[i]表示走到第i阶台阶需要的方法数。等于从第i-1阶走一步或者从第i-2阶走两步
 * 所以所需的方法数等于走到第i-1阶的方法数加上走到第i-2阶的方法数。
 */
public class Q70 {
	public int climbStairs(int n) {
		if (n == 1 || n == 2)
			return n;
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
