package hard;
/*
 * 2016.5.3
 * 这是一道可以使用动态规划的题目，s是源字符串，p是正则表达式，要用p匹配s。要求：1.'.' 可以表示任意一个字符 2.'*'表示*号前的字符可以出现若干次，包括0
 * dp[i][j]表示，s[0...i]匹配p[0...j]是否成功。
 * 
 * isMath方法是空间复杂度为O(n平方)的方法。
 * isMath2空间复杂度为O(2n)，因为每一次判断只需要相邻上一行的数据即可。
 * 
 */
public class Q10 {
	public boolean isMatch(String s, String p) {
		int lens = s.length();
		int lenp = p.length();
		if (lens == 0 && lenp == 0)
			return true;
		boolean[][] dp = new boolean[lens + 1][lenp + 1];
		dp[0][0] = true;
		// 初始化，每个字符串前面先加上一个空字符，所以第一行表示，空字符匹配p[0...j]，成功的条件仅为p是由一个字符加一个*号这样的组合组成的。
		for (int i = 2; i <= lenp; i++) {
			dp[0][i] = (p.charAt(i - 1) == '*' && dp[0][i - 2]) ? true : false;
		}
		//任何字符串匹配空字符都是失败的。
		for (int i = 1; i <= lens; i++) {
			dp[i][0] = false;
		}
		for (int i = 1; i <= lens; i++) {
			for (int j = 1; j <= lenp; j++) {
				if (p.charAt(j - 1) == '*') {//第一类可能，当前字符是一个*号
					//可能性1，*号前的字符出现大于等于1次。条件是当前比较字符等于*号前的字符或者*号前的字符是.号
					//如果去掉当前字符匹配p[0...j]依然成功，则表明，当前字符是重复出现的字符，匹配成功。
					if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
						dp[i][j] = dp[i - 1][j] ? true : false;
					}
					//如果当前字符不等*号前的字符，则可能*号前的字符出现0次，所以通过和p[0...j-2]匹配，判断是否*号前的字符出现0次。
					if (j >= 2 && dp[i][j - 2])
						dp[i][j] = true;
				} else {//如果当前字符不是*号，则比较s[i]和p[j]是否相等。相等的话就取决于s[0..i-1]和p[0...j-1]匹配是否成功。
					if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
						dp[i][j] = dp[i - 1][j - 1] ? true : false;
					}
				}
			}
		}
		print(dp, lens + 1, lenp + 1);
		return dp[lens][lenp];
	}

	public void print(boolean[][] a, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean isMatch2(String s, String p) {
		int lens = s.length();
		int lenp = p.length();
		if (lens == 0 && lenp == 0)
			return true;

		// init
		boolean[][] dp = new boolean[2][lenp + 1];
		dp[0][0] = dp[1][0] = true;
		for (int j = 2; j <= lenp; ++j) {
			if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
				dp[0][j] = dp[1][j] = true;
			}
		}

		// dp
		for (int i = 1; i <= lens; ++i) {
			dp[i & 1][0] = false;
			for (int j = 1; j <= lenp; ++j) {
				dp[i & 1][j] = ((p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')
						&& dp[1 - (i & 1)][j - 1])
						|| p.charAt(j - 1) == '*' && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')
								&& dp[1 - (i & 1)][j]
						|| (j >= 2 && p.charAt(j - 1) == '*' && dp[i & 1][j - 2]);
			}
		}

		return dp[lens & 1][lenp];
	}
}
