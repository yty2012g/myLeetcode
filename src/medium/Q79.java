package medium;
/*
 * 2016.7.15
 * ���ݷ���Ҫ�㡣onStack���顣
 * onStack�����¼�˵�ǰ����ջ���Ѿ����ʵĽڵ㣬�����һ��Ҫ���ʵĽڵ���onStack�У�����Ҫ���ʣ�������Լ������ʡ�
 */

public class Q79 {
	boolean[] onStack;
	int m;
	int n;
	boolean res = false;
	char[][] board;

	public boolean exist(char[][] board, String word) {
		this.board = board;
		m = board.length;
		if (m == 0)
			return false;
		n = board[0].length;
		if (n == 0)
			return false;
		onStack = new boolean[m * n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == word.charAt(0)) {
					onStack[i * n + j] = true;
					find(word, 1, i * n + j);
					onStack[i * n + j] = false;
				}
				if (res)
					return true;
			}
		}
		return res;
	}

	public void find(String word, int prefix, int start) {
		if (res)
			return;
		if (prefix == word.length()) {
			res = true;
			return;
		}
		char c = word.charAt(prefix);
		int x = start / n;
		int y = start - x * n;
		if (y - 1 >= 0 && board[x][y - 1] == c && !onStack[x * n + y - 1]) {
			onStack[x * n + y - 1] = true;
			find(word, prefix + 1, x * n + y - 1);
			onStack[x * n + y - 1] = false;
		}
		if (x - 1 >= 0 && board[x - 1][y] == c && !onStack[(x - 1) * n + y]) {
			onStack[(x - 1) * n + y] = true;
			find(word, prefix + 1, (x - 1) * n + y);
			onStack[(x - 1) * n + y] = false;
		}
		if (y + 1 < n && board[x][y + 1] == c && !onStack[x * n + y + 1]) {
			onStack[x * n + y + 1] = true;
			find(word, prefix + 1, x * n + y + 1);
			onStack[x * n + y + 1] = false;
		}
		if (x + 1 < m && board[x + 1][y] == c && !onStack[(x + 1) * n + y]) {
			onStack[(x + 1) * n + y] = true;
			find(word, prefix + 1, (x + 1) * n + y);
			onStack[(x + 1) * n + y] = false;
		}
	}

}
