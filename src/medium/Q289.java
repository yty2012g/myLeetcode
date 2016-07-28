package medium;

import java.util.*;

/*
 * 2016.7.28
 * 由于这里需要一次将所有节点同步更新，如果按照遍历顺序更新会造成错误。
 * 因此使用一个arraylist记录所有需要更新的点。
 * 然后最后统一更新。
 * 
 * 规则可以简化如下：
 * 如果有三个活的邻居，则该节点为活。
 * 如果有两个活的邻居，则该节点状态不变。
 * 其余为死。
 */
public class Q289 {
	public void gameOfLife(int[][] board) {
		int m = board.length;
		if (m == 0)
			return;
		int n = board[0].length;
		if (n == 0)
			return;
		ArrayList<Integer> list = new ArrayList<Integer>(m * n);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int lives = 0;
				if (i - 1 >= 0) {
					if (j - 1 >= 0) {
						if (board[i - 1][j - 1] == 1)
							lives++;
					}
					if (board[i - 1][j] == 1)
						lives++;
					if (j + 1 < n) {
						if (board[i - 1][j + 1] == 1)
							lives++;
					}
				}
				if (j - 1 >= 0) {
					if (board[i][j - 1] == 1)
						lives++;
				}
				if (j + 1 < n) {
					if (board[i][j + 1] == 1)
						lives++;
				}
				if (i + 1 < m) {
					if (j - 1 >= 0) {
						if (board[i + 1][j - 1] == 1)
							lives++;
					}
					if (board[i + 1][j] == 1)
						lives++;
					if (j + 1 < n) {
						if (board[i + 1][j + 1] == 1)
							lives++;
					}
				}
				if (board[i][j] == 1) {
					if (lives < 2 || lives > 3) {
						list.add(i * n + j);
					}
				} else {
					if (lives == 3) {
						list.add(i * n + j);
					}
				}
			}
		}
		Iterator<Integer> iter = list.iterator();
		while (iter.hasNext()) {
			int temp = iter.next();
			board[temp / n][temp - temp / n * n] = 1 - board[temp / n][temp - temp / n * n];
		}
	}
}
