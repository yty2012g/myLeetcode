package medium;

/*
 * 2016.7.18
 * 动态规划的典型做法。dp[i][j]表示以[i,j]为右下角的正方形的变长。
 * 对于[i,j]而言，如果其左上，左，上三个点其中有0的话，则只能以[i,j]点构成正方形，所以dp[i][j]=1
 * 否则的话，取三个点较小的变长，可以加上[i，j]构成大的正方形。
 * 所以dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
 * 
 * 最终求面积，则返回变长的平方即可。
 */
public class Q221 {
	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;
		if (n == 0)
			return 0;
		int[][] dp = new int[m][n];
		int max = 0;
		dp[0][0] = matrix[0][0] == '1' ? 1 : 0;
		max = dp[0][0];
		for (int i = 1; i < n; i++) {
			dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
			max = Math.max(max, dp[0][i]);
		}
		for (int i = 1; i < m; i++) {
			dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
			max = Math.max(max, dp[i][0]);
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '1') {
					if (dp[i - 1][j] == 0 || dp[i][j - 1] == 0 || dp[i - 1][j - 1] == 0)
						dp[i][j] = 1;
					else {
						dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					}
				} else
					dp[i][j] = 0;
				max = Math.max(max, dp[i][j]);
			}
		}
		return max * max;
	}
}
