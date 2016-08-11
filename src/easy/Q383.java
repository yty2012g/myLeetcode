package easy;

/*
 * 2016.8.11
 * 这个题目就是HashMap的应用。
 * 使用一个dict数组表示字母对应的频次。
 * 先统计magazine的每个字母的最大频次。
 * 然后ransom中，每次出现一个字母，其频次-1，如果出现频次为负数，则返回false；
 */
public class Q383 {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] dict = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			dict[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			dict[ransomNote.charAt(i) - 'a']--;
			if (dict[ransomNote.charAt(i) - 'a'] < 0)
				return false;
		}
		return true;
	}
}
