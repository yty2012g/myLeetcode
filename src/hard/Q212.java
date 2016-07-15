package hard;

import java.util.*;

/*
 * 2016.7.15
 * ��֪���ǲ����ҵ�ǰ׺��ʵ�ֵ������⣬����ʹ��ǰ׺������TLE����������ֻ��Ӧ����ǰ׺����˼�롣
 * Trie��һ��ǰ׺�����ڲ��࣬ǰ׺��������һ����״�ṹ������������hashset������ǰ׺���Һ͵��ʲ��ҡ�
 * ������˼����ǣ���words��������е��ʲ��뵽ǰ׺���У�Ȼ���board��ʼdfs���������ǰ׺���ھͼ������������ǰ׺�����ڣ�������һ�㡣
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
