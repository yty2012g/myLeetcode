package medium;

/*
 * 2016.5.15
 * 典型的动态规划的问题。
 * dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
 * dp[i][j]表示走到第i行第j列的最小开销。
 * 由于只能向下走或者向右走
 * 那么第i行第j列只能由第i行第j-1列向右走，或者第i-1行第j列向下走得到，选取两个较小的开销在加上当前位置的开销，得到最终开销。
 */
public class Q64 {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		if (m == 0)
			return 0;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}
		return dp[m - 1][n - 1];
	}
}
