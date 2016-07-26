package medium;

/*
 * 2016.7.26
 * 和找零钱的题目的做法一致。dp的方法。
 * dp[i][j]表示，使用1到i+1的平方数构成j的最小次数。
 * 如果j>=(i+1)^2，那么dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - (i + 1) * (i + 1)] + 1);
 * 否则，dp[i][j]=dp[i-1][j];
 */
public class Q279 {
	public double sqrt(int n) {
		double k = 1.0d;
		while (Math.abs(k * k - n) > 1e-5) {
			k = 0.5 * (k + n / k);
		}
		return k;
	}

	public int numSquares(int n) {
		int m = (int) Math.sqrt(n);
		int[][] dp = new int[m][n + 1];
		for (int i = 0; i <= n; i++) {
			dp[0][i] = i;
		}
		for (int i = 0; i < m; i++) {
			dp[i][0] = 0;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j <= n; j++) {
				if (j < (i + 1) * (i + 1)) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - (i + 1) * (i + 1)] + 1);
				}
			}
		}
		return dp[m - 1][n];
	}
}
