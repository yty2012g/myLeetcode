package medium;

import java.util.*;

/*
 * 2016.7.3
 * 典型的回溯法，每次先切出一个子字符串，判断是否回文，如果是的话，就继续判断剩余字符串。
 * 终止条件是判断完整个字符串，就把array拷贝一份，然后添加到结果集即可。 
 */
public class Q131 {
	List<List<String>> res = new ArrayList<List<String>>();

	public List<List<String>> partition(String s) {
		part(s, 0, new ArrayList<String>());
		return res;
	}

	public void part(String s, int start, ArrayList<String> array) {
		if (start == s.length()) {
			ArrayList<String> copy = (ArrayList<String>) array.clone();
			res.add(copy);
			return;
		}
		for (int i = start + 1; i <= s.length(); i++) {
			String sub = s.substring(start, i);
			if (check(sub)) {
				array.add(sub);
				part(s, i, array);
				array.remove(array.size() - 1);
			}
		}
	}

	public boolean check(String s) {
		int i = 0;
		while (i < s.length() - 1 - i) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
			i++;
		}
		return true;
	}
}
