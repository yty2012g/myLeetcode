package medium;

/*
 * 2016.5.15
 * 动态规划方法，dp[i][j]表示走到第i行第j列的路径的种类
 * dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
 * 表示走到第i行第j列，要么是从第i-1行第j列向下走一步，要么是从第i行第j-1列项右走一步。因此是两种情况相加即可。
 */
public class Q62 {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		dp[0][0] = 0;
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + 1;
		}
		for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i - 1] + 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
}
