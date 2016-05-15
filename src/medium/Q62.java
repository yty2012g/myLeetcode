package medium;

/*
 * 2016.5.15
 * ��̬�滮������dp[i][j]��ʾ�ߵ���i�е�j�е�·��������
 * dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
 * ��ʾ�ߵ���i�е�j�У�Ҫô�Ǵӵ�i-1�е�j��������һ����Ҫô�Ǵӵ�i�е�j-1��������һ������������������Ӽ��ɡ�
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
