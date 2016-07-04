package hard;

import java.util.*;

/*
 * 2016.7.4
 * 结合Q139的做法。首先判断，字符串s能不能被有效分割。如果可以的话，在进行下一步。
 * dp[i]和Q139的含义相同，在判断dp的过程中，如果dp[j]可以，并且s[i...j]在字典中，那么j位置对应的句子列表都可以加上s[i...j]
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
