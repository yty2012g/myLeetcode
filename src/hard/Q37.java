package hard;

import java.util.*;

/*
 * 2016.8.21
 * 终于做出来了。。
 * 首先，使用一个三位数组flag[i][j][k]，用来标记第i行，第j列的位置，能否填k。
 * 然后，根据初始的情况，对于每个有数字的位置，将其横纵和九宫格内的其余位置的当前数字的标志位设置为true，表示不能填了。
 * 再然后，使用init来初步剪枝，就是，在初始化以后，可能会有少数的位置只有1种选择，那么直接填写就行，并且更改横纵和九宫格的标志位，直到没有一个位置只有一种可以填写的可能性为止。
 * 最后，开始回溯，首先要记录横纵和九宫格的标志位，用来恢复现场，然后就是填写一个，开始递归。如果出现一个位置的所有标志位都扫描完，但是还是无法填写的时候，返回false。否则，继续填写。
 * 如果回溯后，发现当初的填写并不正确时，就需要根据刚才的情况恢复现场，并选择下一个标志位。
 * 现场包括，横，纵和九宫格内位置的标志位情况。
 */
public class Q37 {
	public void solveSudoku(char[][] board) {
		boolean[][][] flag = new boolean[9][9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					for (int k = 0; k < 9; k++) {
						flag[i][j][k] = true;
						flag[i][k][board[i][j] - '1'] = true;
						flag[k][j][board[i][j] - '1'] = true;
					}
					for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) {
						for (int l = j / 3 * 3; l < j / 3 * 3 + 3; l++) {
							flag[k][l][board[i][j] - '1'] = true;
						}
					}
				}
			}
		}
		print(board);
		System.out.println();
		init(board, flag);
		print(board);
		bactrack(board, flag);
	}

	public boolean bactrack(char[][] board, boolean[][][] flag) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					boolean[][] x = new boolean[9][9];
					boolean[][] y = new boolean[9][9];
					boolean[][][] jiu = new boolean[3][3][9];
					for (int k = 0; k < 9; k++) {
						for (int l = 0; l < 9; l++) {
							x[k][l] = flag[i][k][l];
							y[k][l] = flag[k][j][l];
						}
					}
					for (int m = i / 3 * 3; m < i / 3 * 3 + 3; m++) {
						for (int n = j / 3 * 3; n < j / 3 * 3 + 3; n++) {
							for (int k = 0; k < 9; k++) {
								jiu[m - i / 3 * 3][n - j / 3 * 3][k] = flag[m][n][k];
							}
						}
					}
					for (int k = 0; k < 9; k++) {
						if (!flag[i][j][k]) {
							board[i][j] = (char) (k + '1');
							for (int l = 0; l < 9; l++) {
								flag[i][l][k] = true;
								flag[l][j][k] = true;
							}
							for (int m = i / 3 * 3; m < i / 3 * 3 + 3; m++) {
								for (int n = j / 3 * 3; n < j / 3 * 3 + 3; n++) {
									flag[m][n][k] = true;
								}
							}
							if (bactrack(board, flag))
								return true;
							else {
								for (int l = 0; l < 9; l++) {
									flag[i][l][k] = x[l][k];
									flag[l][j][k] = y[l][k];
								}
								for (int m = i / 3 * 3; m < i / 3 * 3 + 3; m++) {
									for (int n = j / 3 * 3; n < j / 3 * 3 + 3; n++) {
										for (int p = 0; p < 9; p++) {
											flag[m][n][p] = jiu[m - i / 3 * 3][n - j / 3 * 3][p];
										}
									}
								}
								board[i][j] = '.';
							}
						}
					}
					if (board[i][j] == '.')
						return false;
				}
			}
		}
		return true;
	}

	public void init(char[][] board, boolean[][][] flag) {
		int x = 0;
		int y = 0;
		int temp = -1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					int count = 0;
					for (int k = 0; k < 9; k++) {
						if (count > 1)
							break;
						if (!flag[i][j][k])
							count++;
					}
					if (count == 1) {
						x = i;
						y = j;
						for (int k = 0; k < 9; k++) {
							if (!flag[i][j][k])
								temp = k;
						}
						break;
					}
				}
			}
		}
		if (temp == -1)
			return;
		for (int i = 0; i < 9; i++) {
			flag[x][i][temp] = true;
			flag[i][y][temp] = true;
		}
		for (int k = x / 3 * 3; k < x / 3 * 3 + 3; k++) {
			for (int l = y / 3 * 3; l < y / 3 * 3 + 3; l++) {
				flag[k][l][temp] = true;
			}
		}
		board[x][y] = (char) (temp + '1');
		init(board, flag);
	}

	public void print(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
