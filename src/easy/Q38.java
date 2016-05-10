package easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
/*
 * 2016.5.9
 * 这道题比较简单，就是根据上一次的字符串得到下一次的字符串。
 * 首先使用一个HashMap，如果一个字符没有出现在hashmap中，说明前面的一个字符已经结束，因此结果加上“次数+前一个字符”
 * 注意是，在最后一次，需要将hashmap剩余的最后一个字符写入结果中。
 */
public class Q38 {
	public String countAndSay(int n) {
		if (n == 1)
			return "1";
		String old = "1";
		for (int i = 2; i <= n; i++) {
			old = say(old);
		}
		return old;
	}

	public String say(String old) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String res = "";
		map.put(old.charAt(0), 1);
		for (int i = 1; i < old.length(); i++) {
			if (map.get(old.charAt(i)) == null) {
				Iterator iter = map.entrySet().iterator();
				Map.Entry entry = (Entry) iter.next();
				res = res + entry.getValue() + entry.getKey();
				map.clear();
				map.put(old.charAt(i), 1);
			} else {
				map.put(old.charAt(i), map.get(old.charAt(i)) + 1);
			}
		}
		Iterator iter = map.entrySet().iterator();
		Map.Entry entry = (Entry) iter.next();
		res = res + entry.getValue() + entry.getKey();
		return res;
	}
}
