package medium;

import java.util.*;

/*
 * 2016.7.4
 * Ӧ���˶�̬�滮�ķ�����
 * dp[i]��ʾ��s[0,i]�õ������ַ����Ƿ����ֵ��С�
 * dp[i]=anyOf(dp[j]&&s[j,i]���ֵ���) 0<=j<i
 * ���ʾ������ǰi���ַ����ɵ��ַ�����ֻҪǰj���ַ����ɵ����ַ�������Ҫ�󣬲���j��i���ɵ����ַ���Ҳ����Ҫ�󣬼��ɡ�
 * ͨ��ѭ���ҵ��Ƿ����j��
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
