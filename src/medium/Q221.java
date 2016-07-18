package medium;

/*
 * 2016.7.18
 * ��̬�滮�ĵ���������dp[i][j]��ʾ��[i,j]Ϊ���½ǵ������εı䳤��
 * ����[i,j]���ԣ���������ϣ�����������������0�Ļ�����ֻ����[i,j]�㹹�������Σ�����dp[i][j]=1
 * ����Ļ���ȡ�������С�ı䳤�����Լ���[i��j]���ɴ�������Ρ�
 * ����dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
 * 
 * ������������򷵻ر䳤��ƽ�����ɡ�
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
