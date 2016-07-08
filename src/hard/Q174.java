package hard;

/*
 * 2016.7.8
 * 使用动态规划的典型场景。。。脑袋太死板了。。。脑袋太死板了。。。脑袋太死板了。。。
 * 这里dp[i][j]代表从[i][j]的位置走到右下角所需的最小血量。
 * 动态规划方程如下：dp[i][j]=Math.max(1, Math.min(dp[i+1][j], dp[i][j+1])-dungeon[i][j]);
 * 如果当前位置需要扣血，则需要的血量增加，如果当前位置会加血，需要的血量会减少。由于只能向右或者向下走。
 * 因此i，j位置的血量之和i-1,j或者i，j-1有关。
 * dp[0][0]即为所求的最小血量。
 */
public class Q174 {
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		if (m == 0)
			return 0;
		int n = dungeon[0].length;
		int[][] dp = new int[m][n];
		dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
		for (int i = m - 2; i >= 0; i--) {
			dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
		}
		for (int i = n - 2; i >= 0; i--) {
			dp[m - 1][i] = Math.max(1, dp[m - 1][i + 1] - dungeon[m - 1][i]);
		}
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
			}
		}
		return dp[0][0];
	}
}
