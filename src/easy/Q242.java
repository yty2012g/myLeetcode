package easy;

/*
 * 2016.7.22
 * 这里由于确定只有小写字母。所以用数组速度会快很多。
 * 用一个数组记录每一个字母出现的次数。
 * 先遍历s，出现的字母次数+1；
 * 在遍历t,出现的字幕次数-1，如果次数为负数，则返回false；
 * 返回true；
 */
public class Q242 {
	public boolean isAnagram(String s, String t) {
		int[] times = new int[26];
		if (s.length() != t.length())
			return false;
		if (s.length() == 0)
			return true;
		for (int i = 0; i < s.length(); i++) {
			times[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			times[t.charAt(i) - 'a']--;
			if (times[t.charAt(i) - 'a'] < 0)
				return false;
		}
		return true;
	}
}
