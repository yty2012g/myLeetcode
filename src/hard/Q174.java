package hard;

/*
 * 2016.7.8
 * ʹ�ö�̬�滮�ĵ��ͳ����������Դ�̫�����ˡ������Դ�̫�����ˡ������Դ�̫�����ˡ�����
 * ����dp[i][j]�����[i][j]��λ���ߵ����½��������СѪ����
 * ��̬�滮�������£�dp[i][j]=Math.max(1, Math.min(dp[i+1][j], dp[i][j+1])-dungeon[i][j]);
 * �����ǰλ����Ҫ��Ѫ������Ҫ��Ѫ�����ӣ������ǰλ�û��Ѫ����Ҫ��Ѫ������١�����ֻ�����һ��������ߡ�
 * ���i��jλ�õ�Ѫ��֮��i-1,j����i��j-1�йء�
 * dp[0][0]��Ϊ�������СѪ����
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
