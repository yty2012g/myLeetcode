package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
 * 2016.5.8
 * 方法很简单好理解，首先使用一个hashmap统计words里面每个单词和出现的次数，因为这里单词是可以重复的。
 * 然后，对于字符串s，每一位的开始查找，由于words里面的单词长度都是相同的，所以一次比较长度为wordl的子串即可。
 * 每一次匹配，得到一个hashmap的克隆，如果子串没有出现在hashmap中，或者出现的次数超过了words里面的次数，直接停止。
 * 这里应用到了滑动窗口的概念，如果匹配成功，那么最多匹配wordl*len的长度，超过这个长度的就不用比较。
 * 这个方法的时间是125ms。
 * 如果不使用滑动窗口的概念，则停止的条件是出现一次匹配不成功，也就是每一次成功匹配的字符都会多比较一次，所以时间会长一点
 * 129ms
 */
public class Q30 {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		if (words.length == 0 || words[0].length() == 0)
			return res;
		int wordl = words[0].length();
		int len = words.length;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < len; i++) {
			if (map.get(words[i]) == null)
				map.put(words[i], 1);
			else
				map.put(words[i], map.get(words[i]) + 1);
		}
		for (int i = 0; i < s.length() - len * wordl + 1; i++) {
			HashMap<String, Integer> copy = (HashMap<String, Integer>) map.clone();
			for (int start = i; start < i + wordl * len; start = start + wordl) {
				String sub = s.substring(start, start + wordl);
				if (copy.get(sub) == null)
					break;
				else {
					int times = copy.get(sub);
					times--;
					if (times == 0)
						copy.remove(sub);
					else
						copy.put(sub, times);
				}
			}
			if (copy.size() == 0)
				res.add(i);
		}
		return res;
	}

	public List<Integer> findSubstring2(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		if (words.length == 0 || words[0].length() == 0)
			return res;
		int wordl = words[0].length();
		int len = words.length;
		ArrayList<String> word = new ArrayList<String>();
		for (int i = 0; i < len; i++) {
			word.add(words[i]);
		}

		for (int i = 0; i < s.length() - len * wordl; i++) {
			int start = i;
			ArrayList<String> copy = new ArrayList<String>();
			for (int j = 0; j < len; j++) {
				copy.add(word.get(j));
			}
			while (start < s.length() - wordl + 1) {
				if (copy.remove(s.substring(start, start + wordl))) {
					start = start + wordl;
				} else
					break;
			}
			if (copy.size() == 0)
				res.add(i);
		}
		return res;
	}

	public void print(ArrayList<String> a) {
		for (int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + " ");
		}
		System.out.println();
	}
}
