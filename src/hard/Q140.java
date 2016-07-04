package hard;

import java.util.*;

/*
 * 2016.7.4
 * ���Q139�������������жϣ��ַ���s�ܲ��ܱ���Ч�ָ������ԵĻ����ڽ�����һ����
 * dp[i]��Q139�ĺ�����ͬ�����ж�dp�Ĺ����У����dp[j]���ԣ�����s[i...j]���ֵ��У���ôjλ�ö�Ӧ�ľ����б����Լ���s[i...j]
 */
public class Q140 {
	public List<String> wordBreak(String s, Set<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		HashMap<Integer, List<String>> f = new HashMap<Integer, List<String>>();
		dp[0] = true;
		List<String> temp = new ArrayList<String>();
		if (!wordBreak2(s, wordDict))
			return temp;
		f.put(0, temp);
		for (int i = 1; i <= s.length(); i++) {
			List<String> test = new ArrayList<String>();
			f.put(i, test);
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					temp = (ArrayList<String>) f.get(j);
					List<String> t = new ArrayList<String>();
					if (temp.size() == 0) {
						t.add(s.substring(j, i));
					} else {
						for (int k = 0; k < temp.size(); k++) {
							t.add(temp.get(k) + " " + s.substring(j, i));
						}
					}
					if (f.containsKey(i)) {
						f.get(i).addAll(t);
					} else {
						f.put(i, t);
					}
					dp[i] = true;
				}
			}
		}
		return f.get(s.length());
	}

	public boolean wordBreak2(String s, Set<String> wordDict) {
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
}
