package easy;

import java.util.*;

/*
 * 2016.7.28
 * 题目很简单，要求pattern和str是双射的，即一一对应，并且没有拉下的。
 * 所以使用map记录字母->单词，使用map2记录单词->字母。
 * 如果，对于一组新的单词字母而言，如果都出现在了map和map2中，那么他们必须互相对应，否则返回false；
 * 如果，只出现在map或者map2中，返回false。因为是一一对应的关系。
 * 如果，哪个都没有出现，则在map和map2中增加映射关系。
 */
public class Q290 {
	public boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> map = new HashMap<Character, String>(26);
		HashMap<String, Character> map2 = new HashMap<String, Character>(26);
		String[] sc = str.split(" ");
		if (sc.length != pattern.length())
			return false;
		for (int i = 0; i < sc.length; i++) {
			if (map.containsKey(pattern.charAt(i)) && map2.containsKey(sc[i])) {
				if (map.get(pattern.charAt(i)).equals(sc[i]) && map2.get(sc[i]).equals(pattern.charAt(i))) {
				} else
					return false;
			} else if ((!map.containsKey(pattern.charAt(i)) && map2.containsKey(sc[i]))
					|| (map.containsKey(pattern.charAt(i)) && !map2.containsKey(sc[i]))) {
				return false;
			} else {
				map.put(pattern.charAt(i), sc[i]);
				map2.put(sc[i], pattern.charAt(i));
			}
		}
		return true;
	}
}
