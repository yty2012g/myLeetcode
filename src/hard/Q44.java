package hard;

/*
 * 2016.5.10
 * 这个和前面那个正则表达式匹配时非常类似的，规则略有不同，这里？代表任意一个字符，*代表若干个字符
 * 利用动态规划的方法，dp[i][j]表示s[0..i-1]和p[0...j-1]匹配的结果
 * 条件1，如果s的当前字符等于p的当前字符或者p当前为?号，那么如果s[0..i-2]和p[0...j-2]匹配的结果是成功，则结果是成功的，否则结果为失败
 * 条件2，如果不满足条件1，如果当前p的字符是*号，考虑两种情况，第一，*号代表0个字符。第二，*号代表多个字符
 * 如果是第一种情况，则根据dp[i][j-1]的结果决定，如果没有这个*号依然是成功的，则*号代表0个字符，匹配成功
 * 如果是第二中情况，则从dp[k][j-1]中寻找，0<=k<i，如果有一个k值，使得dp[k][j-1]成功，则说明k到第i-1个字符在p中可以用*号代表结果成功
 * 条件3，如果字符不相等，匹配失败。
 * 
 */
public class Q44 {
	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i <= p.length(); i++) {
			dp[0][i] = (dp[0][i - 1] && p.charAt(i - 1) == '*') ? true : false;
		}
		for (int i = 1; i <= s.length(); i++) {
			dp[i][0] = false;
		}
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
					if (dp[i - 1][j - 1])
						dp[i][j] = true;
				} else {
					if (p.charAt(j - 1) == '*') {
						if (dp[i][j - 1])
							dp[i][j] = true;
						else {
							for (int k = i - 1; k >= 0; k--) {
								if (dp[k][j - 1]) {
									dp[i][j] = true;
									break;
								}
							}
						}
					} else {
						dp[i][j] = false;
					}

				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
