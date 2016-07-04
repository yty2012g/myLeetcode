package medium;

import java.util.*;

/*
 * 2016.7.4
 * 应用了动态规划的方法。
 * dp[i]表示从s[0,i]得到的子字符串是否在字典中。
 * dp[i]=anyOf(dp[j]&&s[j,i]在字典中) 0<=j<i
 * 这表示，对于前i个字符构成的字符串，只要前j个字符构成的子字符串符合要求，并且j到i构成的子字符串也符合要求，即可。
 * 通过循环找到是否存在j。
 */
public class Q139 {
	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
	// public boolean wordBreak(String s, Set<String> wordDict) {
	// return valid(s, 0, wordDict);
	// }
	//
	// public boolean valid(String s, int start, Set<String> wordDict) {
	// if (start == s.length())
	// return true;
	// for (int i = s.length(); i > start; i--) {
	// String sub = s.substring(start, i);
	// if (wordDict.contains(sub)) {
	// if (valid(s, i, wordDict))
	// return true;
	// }
	// }
	// return false;
	// }
}
