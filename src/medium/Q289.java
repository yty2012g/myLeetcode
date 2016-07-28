package medium;

import java.util.*;

/*
 * 2016.7.28
 * ����������Ҫһ�ν����нڵ�ͬ�����£�������ձ���˳����»���ɴ���
 * ���ʹ��һ��arraylist��¼������Ҫ���µĵ㡣
 * Ȼ�����ͳһ���¡�
 * 
 * ������Լ����£�
 * �������������ھӣ���ýڵ�Ϊ�
 * �������������ھӣ���ýڵ�״̬���䡣
 * ����Ϊ����
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
