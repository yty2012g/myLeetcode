package medium;

import java.util.*;

/*
 * 2016.7.14
 * ǰ׺����ÿ���ڵ�����ݽṹ����һ���ڵ�ֵ����һ������������һ���ӽڵ��Hashmap
 * insert������ÿһ���ַ����в�⡣����һ���ڵ㣬Ȼ���ڸýڵ��hashmap�м�����һ���ַ���Ӧ���ӽڵ㡣
 *             ��Ҫע����ǣ��������ַ���������Ϻ󣬲���һ����0���ڵ㣬��������ַ���
 * search����������һ���ַ�һ���ַ��Ĳ��ң����ÿһ���ַ������֣��������һ���ַ����ӽڵ��н�������Ӧ���ӽڵ㣬�򷵻�true��
 * startsWith��������search�������ƣ�ֻ��������Ҫ�ж��Ƿ���ֽ������ӽڵ㡣
 */
public class Q208 {
	class TrieNode {
		// Initialize your data structure here.
		public char val;
		public HashMap<Character, TrieNode> map;

		public TrieNode() {
			this.val = 0;
			map = new HashMap<Character, TrieNode>();
		}
	}

	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		HashSet<String> set = new HashSet<String>();

		// Inserts a word into the trie.
		public void insert(String word) {
			if (search(word))
				return;
			set.add(word);
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				HashMap<Character, TrieNode> map = cur.map;
				if (map.containsKey(word.charAt(i))) {
					cur = map.get(word.charAt(i));
				} else {
					TrieNode temp = new TrieNode();
					temp.val = word.charAt(i);
					map.put(word.charAt(i), temp);
					cur = temp;
				}
			}
			cur.map.put('0', new TrieNode());
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			// TrieNode cur = root;
			// for (int i = 0; i < word.length(); i++) {
			// char temp = word.charAt(i);
			// if (cur.map.containsKey(temp)) {
			// cur = cur.map.get(temp);
			// } else {
			// return false;
			// }
			// if (i == word.length() - 1 && !cur.map.containsKey('0')) {
			// return false;
			// }
			// }
			return set.contains(word);
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			TrieNode cur = root;
			for (int i = 0; i < prefix.length(); i++) {
				char temp = prefix.charAt(i);
				if (cur.map.containsKey(temp)) {
					cur = cur.map.get(temp);
				} else {
					return false;
				}
			}
			return true;
		}
	}
}
