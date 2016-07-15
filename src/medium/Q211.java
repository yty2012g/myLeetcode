package medium;

import java.util.*;

/*
 * 2016.7.15
 * û����ʲô�߼��İ취��ʹ����һ��set��һ��hashmap��set��¼���ֹ��ĵ��ʣ�map��¼���ȶ�Ӧ�ĵ����б�
 * addWord�����Ƚϼ򵥣�set��hashmap�����뼴�ɡ�O(1)�ķ�����
 * search���������setֱ�Ӱ�������true��������ʲ�����.ͬʱsetҲû��������ʣ�����false�����map��û�ж�Ӧ���ȵĵ��ʣ�����false��
 *             ʣ�µľ��Ǵ�map���ҵ���Ӧ���ȵĵ����б������б��ɡ�
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
