package hard;

/*
 * 2016.5.16
 * ���͵Ķ�̬�滮����
 * ����ɾ�����ֲ�����������Ϊ1
 * dp[i][j]��ʾ��word1[0..i-1]ת����word2[0..j-1]�Ŀ���
 * ���������
 * ��һ�֣�����word1[0..i-1]ת����word2[0..j-2]��Ȼ�����word2[j-1]
 * �ڶ��֣�����word1[0..i-2]ת����word2[0..j-1]��Ȼ��ɾ��word1[i-1]
 * �����֣����word1[i-1]����word2[j-1]����ôֱ�ӽ�word1[0..i-2]ת����word2[0..j-2]���ɣ�����Ļ�����Ҫ��word1[i-1]�ĳ�word2[j-1]
 * dp[i][j] = Math.min(zeng, Math.min(shan, gai));
 * ����ȡ��С��
 */
public class Q72 {
	public int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		dp[0][0] = 0;
		for (int i = 1; i <= word2.length(); i++) {
			dp[0][i] = dp[0][i - 1] + 1;
		}
		for (int i = 1; i <= word1.length(); i++) {
			dp[i][0] = dp[i - 1][0] + 1;
		}
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				int zeng = dp[i][j - 1] + 1;
				int shan = dp[i - 1][j] + 1;
				int gai = word1.charAt(i - 1) == word2.charAt(i - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
				dp[i][j] = Math.min(zeng, Math.min(shan, gai));
			}
		}
		return dp[word1.length()][word2.length()];
	}
}
