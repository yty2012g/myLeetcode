package medium;

import java.util.*;

/*
 * 2016.7.2
 * ��������̫����ʱ�䡣������û�и㶨BFS+Union-find
 * ����������˼�Ȩquick-Union������Ȼ�������α������нڵ㡣
 * ����X�ڵ㣬ֻ��X�ڵ�������
 * ����O�ڵ㣬���O�ڵ��ڱ�Ե����ô�������ڽڵ���ʲô����������������
 *            ������ڱ�Ե��ֻ��O�ڵ�������������
 * �жϸı�������ǣ��������ڵ���O�ڵ㣬ͬʱ���͵�һ��X�ڵ�����������X�ڵ㡣
 */
public class Q130 {
	int[] id;
	int[] sz;

	public void solve(char[][] board) {
		int m = board.length;
		if (m == 0)
			return;
		int n = board[0].length;
		init(m, n);
		int f = -1;
		boolean flag = true;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X') {
					if (flag) {
						f = i * n + j;
						flag = false;
					}
					if (i - 1 >= 0 && board[i - 1][j] == 'X')
						union(i * n + j, (i - 1) * n + j);
					if (j - 1 >= 0 && board[i][j - 1] == 'X')
						union(i * n + j, i * n + j - 1);
					if (i + 1 < m && board[i + 1][j] == 'X')
						union(i * n + j, (i + 1) * n + j);
					if (j + 1 < n && board[i][j + 1] == 'X')
						union(i * n + j, i * n + j + 1);
				} else {
					if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
						if (i - 1 >= 0)
							union(i * n + j, (i - 1) * n + j);
						if (j - 1 >= 0)
							union(i * n + j, i * n + j - 1);
						if (i + 1 < m)
							union(i * n + j, (i + 1) * n + j);
						if (j + 1 < n)
							union(i * n + j, i * n + j + 1);
					} else {
						if (i - 1 >= 0 && board[i - 1][j] == 'O')
							union(i * n + j, (i - 1) * n + j);
						if (j - 1 >= 0 && board[i][j - 1] == 'O')
							union(i * n + j, i * n + j - 1);
						if (i + 1 < m && board[i + 1][j] == 'O')
							union(i * n + j, (i + 1) * n + j);
						if (j + 1 < n && board[i][j + 1] == 'O')
							union(i * n + j, i * n + j + 1);
					}
				}
			}
		}
		if (f == -1)
			return;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O' && !connected((i * n + j), f))
					board[i][j] = 'X';
			}
		}
	}

	public void init(int m, int n) {
		id = new int[m * n];
		sz = new int[m * n];
		for (int i = 0; i < id.length; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	public int find(int p) {
		while (p != id[p])
			p = id[p];
		return p;
	}

	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot)
			return;
		if (sz[pRoot] < sz[qRoot]) {
			id[pRoot] = qRoot;
			sz[qRoot] += sz[pRoot];
		} else {
			id[qRoot] = pRoot;
			sz[pRoot] += sz[qRoot];
		}
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

}
