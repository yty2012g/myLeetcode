package medium;

/*
 * 2016.5.15
 * 还是动态规划，和Q62的方程一样，需要注意的是有障碍的点，到达路径直接设置为0
 */
public class Q63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m == 0)
			return 0;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
		for (int i = 1; i < n; i++) {
			if (obstacleGrid[0][i] == 1) {
				break;
			}
			dp[0][i] = dp[0][i - 1];
		}
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				break;
			}
			dp[i][0] = dp[i - 1][0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
					continue;
				}
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
}
