package medium;

/*
 * 2016.8.8
 * 这个仿照二维的做法。
 * dp[i][j]表示范围（0,0,i,j）的和
 * 那么范围(r1,c1,r2,c2)结果就是
 * dp[row2][col2] - (dp[row1 - 1][col2] + dp[row2][col1 - 1] - dp[row1 - 1][col1 - 1])
 * 如果r1或者c1小于1,则有特殊情况计算。
 */
public class Q304 {
	public class NumMatrix {
		public int[][] dp;
		public int res = 1;

		public NumMatrix(int[][] matrix) {
			int m = matrix.length;
			if (m == 0) {
				res = 0;
				return;
			}
			int n = matrix[0].length;
			if (n == 0) {
				res = 0;
				return;
			}
			dp = new int[m][n];
			dp[0][0] = matrix[0][0];
			for (int i = 1; i < n; i++) {
				dp[0][i] = dp[0][i - 1] + matrix[0][i];
			}
			for (int i = 1; i < m; i++) {
				dp[i][0] = dp[i - 1][0] + matrix[i][0];
			}
			for (int i = 1; i < m; i++) {
				for (int j = 1; j < n; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			if (res == 0)
				return 0;
			if (row1 >= 1 && col1 >= 1) {
				return dp[row2][col2] - (dp[row1 - 1][col2] + dp[row2][col1 - 1] - dp[row1 - 1][col1 - 1]);
			} else if (row1 >= 1) {
				return dp[row2][col2] - dp[row1 - 1][col2];
			} else if (col1 >= 1) {
				return dp[row2][col2] - dp[row2][col1 - 1];
			} else {
				return dp[row2][col2];
			}
		}
	}

}
