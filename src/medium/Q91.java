package medium;

/*
 * 2016.5.20
 * 典型的动态规划的题目，和跳台阶非常类似，只是限制条件要多很多。
 * 生成一个长度为s.length()+1的dp数组，dp[i]表示从s[0...i-1]有多少种转换情况。
 * 初始条件是1.并且如果字符串是空，或者第一位是0，直接输出0；
 * 对于dp[i]，如果这一位是0，那么只能和第i-2位组成两位数来解码，所以如果前一位也是0或者前一位和当前位无法组成可以解码的数字，直接返回0
 * 如果可以组成，那么dp[i]=dp[i-2]
 * 如果这一位不是0，并且可以和前一位组成1到26的数字，则dp[i]=dp[i-1]+dp[i-2];
 * 否则dp[i]=dp[i-1]
 */
public class Q91 {
	public int numDecodings(String s) {
		if (s.length() == 0 || s.charAt(0) == '0')
			return 0;
		if (s.length() == 1)
			return 1;
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= s.length(); i++) {
			if (s.charAt(i - 1) == '0') {
				if ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') > 26 || s.charAt(i - 2) == '0') {
					return 0;
				} else {
					dp[i] = dp[i - 2];
				}
			} else {
				if ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') > 26 || s.charAt(i - 2) == '0') {
					dp[i] = dp[i - 1];
				} else {
					dp[i] = dp[i - 1] + dp[i - 2];
				}
			}
		}
		return dp[s.length()];
	}
}
