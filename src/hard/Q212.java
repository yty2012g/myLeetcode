package hard;

import java.util.*;

/*
 * 2016.7.15
 * 不知道是不是我的前缀树实现的有问题，但是使用前缀树总是TLE，所以这里只是应用了前缀树的思想。
 * Trie是一个前缀树的内部类，前缀树本来是一个树状结构，这里用两个hashset代替了前缀查找和单词查找。
 * 这道题的思想就是，把words里面的所有单词插入到前缀树中，然后从board开始dfs遍历，如果前缀存在就继续遍历，如果前缀不存在，返回上一层。
 */
public class Q212 {
	public class Trie {
		HashSet<String> set = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();

		public Trie() {
		}

		public void insert(String word) {
			for (int i = 0; i < word.length(); i++) {
				set.add(word.substring(0, i + 1));
			}
			set2.add(word);
		}

		public boolean search(String word) {
			return set2.contains(word);
		}

		public boolean startsWith(String prefix) {
			return set.contains(prefix);
		}
	}

	Set<String> res = new HashSet<String>();
	Trie trie = new Trie();
	int m;
	int n;

	public List<String> findWords(char[][] board, String[] words) {
		for (int i = 0; i < words.length; i++) {
			trie.insert(words[i]);
		}
		m = board.length;
		if (m == 0)
			return new ArrayList<String>();
		n = board[0].length;
		if (n == 0)
			return new ArrayList<String>();
		boolean[][] visit = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, visit, i, j, "");
			}
		}
		return new ArrayList<String>(res);
	}

	public void dfs(char[][] board, boolean[][] visit, int x, int y, String str) {
		if (x < 0 || x >= m || y < 0 || y >= n)
			return;
		if (visit[x][y])
			return;
		str += board[x][y];
		if (!trie.startsWith(str))
			return;
		if (trie.search(str))
			res.add(str);
		visit[x][y] = true;
		dfs(board, visit, x - 1, y, str);
		dfs(board, visit, x + 1, y, str);
		dfs(board, visit, x, y + 1, str);
		dfs(board, visit, x, y - 1, str);
		visit[x][y] = false;
		str = str.substring(0, str.length() - 1);
	}
}
