package hard;

import java.util.*;

/*
 * 2016.8.30
 * 对于一个字符串数组。首先将所有的字符串加入hashMap中。
 * 然后，便利每一个字符串。
 * 把字符串分成两部分。a和b。
 * 如果b是回文的，并且a的反序在hashmap中，且a的反序不是原字符串，则字符串和a的反序对应的字符串能组成回文字符串。
 * 如果a是回文的，并且b的反序在hashmap中，且b的反序不是原字符串，则b的反序对应的字符串和字符串能组成回文字符串。
 */
public class Q336 {
	public List<List<Integer>> palindromePairs(String[] words) {
		HashSet<List<Integer>> res = new HashSet<List<Integer>>();
		if (words == null || words.length < 2)
			return new ArrayList<List<Integer>>(res);
		HashMap<String, Integer> map = new HashMap<String, Integer>(words.length);
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j <= words[i].length(); j++) {
				String a = words[i].substring(0, j);
				String b = words[i].substring(j);
				String c = new StringBuilder(a).reverse().toString();
				String d = new StringBuilder(b).reverse().toString();
				Integer it = map.get(c);
				Integer it2 = map.get(d);
				if (check(b) && it != null && it != i) {
					res.add(Arrays.asList(i, it));
				}
				if (check(a) && it2 != null && it2 != i) {
					res.add(Arrays.asList(it2, i));
				}
			}
		}
		return new ArrayList<List<Integer>>(res);
	}

	public boolean check(String a) {
		char[] c = a.toCharArray();
		for (int i = 0; i < c.length / 2; i++) {
			if (c[i] != c[c.length - 1 - i])
				return false;
		}
		return true;
	}
}
