package medium;

import java.util.*;

/*
 * 2016.7.8
 * 还是union-find的题目。
 * 这次做法也比较简单。把所有的1连接在一起即可。
 * 然后，遍历，如果一个位置是1，则把该位置对应的root加入到hashset中。
 * 返回hashset的size即可。
 */
public class Q200 {
	public int[] id;
	public int[] sz;

	public int numIslands(char[][] grid) {
		int m = grid.length;
		if (m == 0)
			return 0;
		int n = grid[0].length;
		id = new int[m * n];
		sz = new int[m * n];
		for (int i = 0; i < m * n; i++) {
			id[i] = i;
			sz[i] = 1;
		}
		HashSet<String> set = new HashSet<String>();
		HashSet<Integer> Root = new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					if (i >= 1 && grid[i - 1][j] == '1') {
						String temp = ((i - 1) * n + j) + "," + (i * n + j);
						if (!set.contains(temp)) {
							union((i - 1) * n + j, (i * n + j));
							set.add(temp);
						}
					}
					if (j + 1 < n && grid[i][j + 1] == '1') {
						String temp = (i * n + j) + "," + (i * n + j + 1);
						if (!set.contains(temp)) {
							union(i * n + j, i * n + j + 1);
							set.add(temp);
						}
					}
					if (i + 1 < m && grid[i + 1][j] == '1') {
						String temp = (i * n + j) + "," + ((i + 1) * n + j);
						if (!set.contains(temp)) {
							union((i * n + j), ((i + 1) * n + j));
							set.add(temp);
						}
					}
					if (j - 1 >= 0 && grid[i][j - 1] == '1') {
						String temp = (i * n + j - 1) + "," + (i * n + j);
						if (!set.contains(temp)) {
							union((i * n + j - 1), (i * n + j));
							set.add(temp);
						}
					}
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					int root = find(i * n + j);
					Root.add(root);
				}
			}
		}
		return Root.size();
	}

	public int find(int p) {
		while (p != id[p]) {
			p = id[p];
		}
		return p;
	}

	public void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return;
		if (sz[aRoot] < sz[bRoot]) {
			id[aRoot] = bRoot;
			sz[bRoot] += sz[aRoot];
		} else {
			id[bRoot] = aRoot;
			sz[aRoot] += sz[bRoot];
		}
	}
}
