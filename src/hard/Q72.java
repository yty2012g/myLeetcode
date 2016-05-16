package hard;

/*
 * 2016.5.16
 * 典型的动态规划问题
 * 有增删改三种操作，开销都为1
 * dp[i][j]表示由word1[0..i-1]转换到word2[0..j-1]的开销
 * 有三种情况
 * 第一种，先由word1[0..i-1]转换到word2[0..j-2]，然后加上word2[j-1]
 * 第二种，先由word1[0..i-2]转换到word2[0..j-1]，然后删掉word1[i-1]
 * 第三种，如果word1[i-1]等于word2[j-1]，那么直接将word1[0..i-2]转换到word2[0..j-2]即可，否则的话，需要将word1[i-1]改成word2[j-1]
 * dp[i][j] = Math.min(zeng, Math.min(shan, gai));
 * 三者取最小。
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
