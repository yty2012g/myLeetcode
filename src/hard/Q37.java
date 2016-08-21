package hard;

import java.util.*;

/*
 * 2016.8.21
 * �����������ˡ���
 * ���ȣ�ʹ��һ����λ����flag[i][j][k]��������ǵ�i�У���j�е�λ�ã��ܷ���k��
 * Ȼ�󣬸��ݳ�ʼ�����������ÿ�������ֵ�λ�ã�������ݺ;Ź����ڵ�����λ�õĵ�ǰ���ֵı�־λ����Ϊtrue����ʾ�������ˡ�
 * ��Ȼ��ʹ��init��������֦�����ǣ��ڳ�ʼ���Ժ󣬿��ܻ���������λ��ֻ��1��ѡ����ôֱ����д���У����Ҹ��ĺ��ݺ;Ź���ı�־λ��ֱ��û��һ��λ��ֻ��һ�ֿ�����д�Ŀ�����Ϊֹ��
 * ��󣬿�ʼ���ݣ�����Ҫ��¼���ݺ;Ź���ı�־λ�������ָ��ֳ���Ȼ�������дһ������ʼ�ݹ顣�������һ��λ�õ����б�־λ��ɨ���꣬���ǻ����޷���д��ʱ�򣬷���false�����򣬼�����д��
 * ������ݺ󣬷��ֵ�������д������ȷʱ������Ҫ���ݸղŵ�����ָ��ֳ�����ѡ����һ����־λ��
 * �ֳ��������ᣬ�ݺ;Ź�����λ�õı�־λ�����
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
