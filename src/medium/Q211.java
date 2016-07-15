package medium;

import java.util.*;

/*
 * 2016.7.15
 * 没有用什么高级的办法。使用了一个set和一个hashmap，set记录出现过的单词，map记录长度对应的单词列表。
 * addWord方法比较简单，set和hashmap都加入即可。O(1)的方法。
 * search方法，如果set直接包含返回true。如果单词不包含.同时set也没有这个单词，返回false；如果map中没有对应长度的单词，返回false；
 *             剩下的就是从map中找到对应长度的单词列表，遍历列表即可。
 */
public class Q211 {
	public class WordDictionary {
		HashSet<String> set = new HashSet<String>();
		HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

		// Adds a word into the data structure.
		public void addWord(String word) {
			set.add(word);
			if (map.containsKey(word.length())) {
				map.get(word.length()).add(word);
			} else {
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(word);
				map.put(word.length(), temp);
			}
		}

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			if (set.contains(word))
				return true;
			if (!word.contains(".") && !set.contains(word))
				return false;
			if (map.get(word.length()) == null)
				return false;
			Iterator<String> iter = map.get(word.length()).iterator();
			while (iter.hasNext()) {
				String temp = iter.next();
				if (patch(word, temp))
					return true;
			}
			return false;
		}

		public boolean patch(String a, String b) {
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) == '.' || a.charAt(i) == b.charAt(i))
					continue;
				else
					return false;
			}
			return true;
		}
	}
}
