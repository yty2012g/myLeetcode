package easy;

import java.util.*;

/*
 * 2016.7.14
 * 使用一个hashmap用来记录s中的字符和t中的字符的对应关系。
 * 使用一个hashset记录已经对应过的t中出现的字符。
 * 如果s中的字符已经出现在hashmap中，而对应t的字符不是hashmap中对应的字符，则返回false；
 * 如果t中的同一种字符对应的s中两种不同的字符，返回false；
 */
public class Q205 {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() == 0)
			return true;
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		HashSet<Character> set = new HashSet<Character>();
		map.put(s.charAt(0), t.charAt(0));
		set.add(t.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				if (map.get(s.charAt(i)) != t.charAt(i))
					return false;
			} else {
				if (set.contains(t.charAt(i)))
					return false;
				map.put(s.charAt(i), t.charAt(i));
				set.add(t.charAt(i));
			}
		}
		return true;
	}
}
