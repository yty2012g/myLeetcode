package easy;
/*
 * 2016.5.8
 * 三个方法用来判断一行，一列，一个九宫格是否符合数独的规则。
 */
public class Q36 {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if ((checkH(board, i, j) && checkS(board, i, j) && checkN(board, i, j))) {
					} else
						return false;
				}
			}
		}
		return true;
	}

	public boolean checkH(char[][] board, int a, int b) {
		char temp = board[a][b];
		for (int i = 0; i < 9; i++) {
			if (i != b && board[a][i] == temp)
				return false;
		}
		return true;
	}

	public boolean checkS(char[][] board, int a, int b) {
		char temp = board[a][b];
		for (int i = 0; i < 9; i++) {
			if (i != a && board[i][b] == temp)
				return false;
		}
		return true;
	}

	public boolean checkN(char[][] board, int a, int b) {
		char temp = board[a][b];
		int startH = a / 3 * 3;
		int startL = b / 3 * 3;
		for (int i = startH; i < startH + 3; i++) {
			for (int j = startL; j < startL + 3; j++) {

				if (i != a && j != b && board[i][j] == temp)
					return false;
			}
		}
		return true;
	}
}
