package medium;

import java.util.*;

/*
 * 2016.7.14
 * 前缀树。每个节点的数据结构包含一个节点值，和一个包含所有下一级子节点的Hashmap
 * insert方法，每一个字符进行拆解。生成一个节点，然后在该节点的hashmap中加入下一个字符对应的子节点。
 *             需要注意的是，当所有字符都插入完毕后，插入一个‘0’节点，代表结束字符。
 * search方法，就是一个字符一个字符的查找，如果每一个字符都出现，并且最后一个字符的子节点有结束符对应的子节点，则返回true；
 * startsWith方法，和search方法类似，只不过不需要判断是否出现结束符子节点。
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
